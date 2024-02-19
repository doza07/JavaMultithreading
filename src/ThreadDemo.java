public class ThreadDemo {
    public static void main(String[] args) {

        SimpleThread simpleThread = new SimpleThread();
        Thread threadRunnable = new Thread(new SimpleRunnable());
        Thread lambdaThread = new Thread(() -> System.out.println("Hello from lambda: " + Thread.currentThread().getName()));

        simpleThread.start();
        threadRunnable.start();
        lambdaThread.start();
        try {
            simpleThread.join();
            threadRunnable.join();
            lambdaThread.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println("Hello From: " + Thread.currentThread().getName());
    }
}