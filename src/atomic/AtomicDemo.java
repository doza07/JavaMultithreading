package atomic;

import java.util.concurrent.atomic.AtomicInteger;

public class AtomicDemo {
    public static void main(String[] args) {

        AtomicInteger atomicInteger = new AtomicInteger();

        int value1 = atomicInteger.incrementAndGet();
        System.out.println(value1);

        int value2 = atomicInteger.addAndGet(10);
        System.out.println(value2);

        int value3 = atomicInteger.decrementAndGet();
        System.out.println(value3);

        System.out.println("---");
        System.out.println(atomicInteger);
    }
}
