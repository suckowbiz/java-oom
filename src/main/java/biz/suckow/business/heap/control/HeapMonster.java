package biz.suckow.business.heap.control;

import biz.suckow.business.oom.boundary.OOMService;

import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.inject.Inject;
import java.util.logging.Level;
import java.util.logging.Logger;

@Singleton
@Startup
public class HeapMonster {

    @Inject
    Logger logger;

    @Inject
    OOMService service;

    @PostConstruct
    public void consume() {
        logger.log(Level.INFO, "--> eat() Going to provoke OutOfMemoryError. Now!");
        this.service.provokeOOM();
    }
}
