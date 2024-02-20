package barrier;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class RocketDetailRunnable implements Runnable{

    private final RocketDetail rocketDetail;
    private final CyclicBarrier cyclicBarrier;

    public RocketDetailRunnable(RocketDetail rocketDetail, CyclicBarrier cyclicBarrier) {
        this.rocketDetail = rocketDetail;
        this.cyclicBarrier = cyclicBarrier;
    }


    @Override
    public void run() {
        System.out.println("Wait part rocket: " + rocketDetail);
        try {
            Thread.sleep(1000L);
            System.out.println("Part ready: " + rocketDetail);
            cyclicBarrier.await();
            System.out.println("Part use: " + rocketDetail);
        } catch (BrokenBarrierException | InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
