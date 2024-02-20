package counter;

public class Counter {

    public static String description;
    private int count;

    public static void init() {
        synchronized (Counter.class) {
            if (description == null)
                description = "Counter description";
        }
    }

    public synchronized void increment() {
        count++;
    }

    public void decrement() {
        synchronized (this) {
            count--;
        }
    }

    public int getCounter() {
        return count;
    }
}
