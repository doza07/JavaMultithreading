package baseThread;

public class SimpleThread extends Thread {

    @Override
    public void run() {
        System.out.println("Hello From thread: " + Thread.currentThread().getName());
    }
}
