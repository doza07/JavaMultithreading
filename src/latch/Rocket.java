package latch;

import java.util.concurrent.CountDownLatch;

public class Rocket implements Runnable {

    private final CountDownLatch countDownLatch;

    public Rocket(CountDownLatch countDownLatch) {
        this.countDownLatch = countDownLatch;
    }

    @Override
    public void run() {
        System.out.println("Wait to start");
        try {
            countDownLatch.await();
            System.out.println("GO!");
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
