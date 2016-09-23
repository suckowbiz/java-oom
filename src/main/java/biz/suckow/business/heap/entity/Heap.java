package biz.suckow.business.heap.entity;

public enum Heap {
    ;
    private static final long DIVISOR_B_TO_MIB = 1024L * 1024L;

    public static long getFreeMiB() {
        final long free = Runtime.getRuntime().freeMemory();
        final long result = Heap.bToMib(free);
        return result;
    }

    public static long getTotalMiB() {
        final long total = Runtime.getRuntime().totalMemory();
        final long result = Heap.bToMib(total);
        return result;
    }

    private static long bToMib(final long value) {
        return value / DIVISOR_B_TO_MIB;
    }
}