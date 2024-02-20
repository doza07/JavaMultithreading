package counter;

public class CounterDemo {
    public static void main(String[] args) {
        Counter counter = new Counter();

        var thread1 = new CounterThread(counter);
        var thread2 = new CounterThread(counter);
        var thread3 = new CounterThread(counter);
        var thread4 = new CounterThread(counter);
        var thread5 = new CounterThread(counter);
        var thread6 = new CounterThread(counter);
        var thread7 = new CounterThread(counter);
        var thread8 = new CounterThread(counter);
        var thread9 = new CounterThread(counter);

        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();
        thread5.start();
        thread6.start();
        thread7.start();
        thread8.start();
        thread9.start();

        try {
            thread1.join();
            thread2.join();
            thread3.join();
            thread4.join();
            thread5.join();
            thread6.join();
            thread7.join();
            thread8.join();
            thread9.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println(counter.getCounter());
    }
}
