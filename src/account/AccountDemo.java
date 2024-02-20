package account;

public class AccountDemo {
    public static void main(String[] args) {

        Account account1 = new Account(20000);
        Account account2 = new Account(10000);

        AccountThread accountThread1 = new AccountThread(account1, account2);
        AccountThread accountThread2 = new AccountThread(account2, account1);

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
