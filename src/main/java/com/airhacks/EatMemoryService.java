package com.airhacks;

import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

/**
 * Created by devops on 8/10/16.
 */
@Singleton
@Startup
public class EatMemoryService {

    @PostConstruct
    public void eatMemory() {

        System.out.println("Waiting for kill ...");
        try {
            Thread.sleep(TimeUnit.SECONDS.toMillis(30));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        java.util.Collection<Object> stack = new ArrayList<>();
        stack.add(new Object());
        while (true) {
            System.out.println("Killing .. ");
            stack.addAll(stack);
        }
    }
}
