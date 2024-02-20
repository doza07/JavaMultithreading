package accountWithLock;

public class AccountLockDemo {
    public static void main(String[] args) {

        AccountLock account1 = new AccountLock(20000);
        AccountLock account2 = new AccountLock(10000);

        AccountLockThread accountThread1 = new AccountLockThread(account1, account2);
        AccountLockThread accountThread2 = new AccountLockThread(account2, account1);

        accountThread1.start();
        accountThread2.start();

        try {
            accountThread1.join();
            accountThread2.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println(account1 + " Acc One");
        System.out.println(account2 + " Acc Two");

    }
}
