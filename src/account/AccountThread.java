package account;

public class AccountThread extends Thread {

    private final Account account1;
    private final Account account2;

    public AccountThread(Account account1, Account account2) {
        this.account1 = account1;
        this.account2 = account2;
    }

    @Override
    public void run() {
        for (int i = 0; i < 2000; i++) {
            synchronized (account1) {
                synchronized (account2) {
                    if (account1.takeOff(10)) {
                        account2.addMoney(10);
                    }
                }
            }
        }
    }
}
