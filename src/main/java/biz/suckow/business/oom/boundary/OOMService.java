package biz.suckow.business.oom.boundary;

import biz.suckow.business.oom.control.OOMStragegy;

import javax.enterprise.inject.Any;
import javax.enterprise.inject.Instance;
import javax.inject.Inject;
import java.util.Iterator;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by tobias on 9/23/16.
 */
public class OOMService {

    @Inject
    @Any
    Instance<OOMStragegy> strategies;

    public void provokeOOM() {
        final ExecutorService pool = Executors.newWorkStealingPool();
        final Iterator<OOMStragegy> iterator = this.strategies.iterator();
        while (iterator.hasNext()) {
            final OOMStragegy strategy = iterator.next();
            pool.execute(new Runnable() {
                @Override
                public void run() {
                    strategy.apply();
                }
            });
        }
    }
}
