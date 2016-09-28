package biz.suckow.business.heap.control;

import biz.suckow.business.oom.boundary.OOMService;

import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.inject.Inject;
import java.sql.Time;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

@Singleton
@Startup
public class HeapMonster {
    private static final long SLEEP_MILLIS = TimeUnit.SECONDS.toMillis(30);

    @Inject
    Logger logger;

    @Inject
    OOMService service;

    @PostConstruct
    public void wakeUpAndConsume() {
        try {
            logger.log(Level.INFO, "Sleeping for {0} s before provoking OutOfMemoryError.", TimeUnit.MILLISECONDS.toSeconds(SLEEP_MILLIS));
            Thread.sleep(SLEEP_MILLIS);
        } catch (InterruptedException e) {
            logger.log(Level.SEVERE, "Interruption while sleeping: {0}.", e.getMessage());
        }
        this.consume();
    }

    private void consume() {
        logger.log(Level.INFO, "Going to provoke OutOfMemoryError. Now!");
        this.service.provokeOOM();
    }
}
