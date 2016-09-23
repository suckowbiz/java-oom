package biz.suckow.business.oom.control;

import biz.suckow.business.heap.entity.Heap;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.Collection;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by tobias on 9/23/16.
 */
public class GrowingCollectionOOMStrategy implements OOMStragegy {

    @Inject
    Logger logger;

    public void apply() {
        final Collection<Object> list = new ArrayList<>();
        while (true) {
            this.logger.log(Level.INFO, "--> apply() {0}/{1} MiB left.", new Object[]{Heap.getFreeMiB(), Heap.getTotalMiB()});
            list.add(new Object[Integer.MAX_VALUE]);
        }
    }
}
