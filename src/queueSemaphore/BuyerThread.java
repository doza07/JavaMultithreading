package queueSemaphore;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Semaphore;

public class BuyerThread implements Runnable {

    private final Semaphore cashBoxes;

    public BuyerThread(Semaphore cashBoxes) {
        this.cashBoxes = cashBoxes;
    }


    @Override
    public void run() {
        try {
            cashBoxes.acquire();
            System.out.println(Thread.currentThread().getName() + " use in cashbox ");
            Thread.sleep(5L);
            System.out.println(Thread.currentThread().getName() + " free cashbox ");
            cashBoxes.release();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
