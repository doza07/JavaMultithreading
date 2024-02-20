package queueSafeThreadCollections;

import java.util.concurrent.BlockingQueue;

public class BuyerThread implements Runnable {

    private final BlockingQueue<CashBox> cashBoxes;

    public BuyerThread(BlockingQueue<CashBox> cashBoxes) {
        this.cashBoxes = cashBoxes;
    }

    @Override
    public void run() {
        try {
            CashBox cashBox = cashBoxes.take();
            System.out.println(Thread.currentThread().getName() + " use in cashbox " + cashBox);
            Thread.sleep(5L);
            System.out.println(Thread.currentThread().getName() + " free cashbox " + cashBox);
            cashBoxes.add(cashBox);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
