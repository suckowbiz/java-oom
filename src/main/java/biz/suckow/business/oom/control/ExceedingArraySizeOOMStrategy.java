package biz.suckow.business.oom.control;

import java.util.ArrayList;

/**
 * Created by tobias on 9/23/16.
 */
public class ExceedingArraySizeOOMStrategy implements OOMStragegy {

    @Override
    public void apply() {
        // OutOfMemoryError: Requested array size exceeds VM limit.
        new ArrayList<>(Integer.MAX_VALUE);
    }
}
