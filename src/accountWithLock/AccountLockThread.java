package accountWithLock;

public class AccountLockThread extends Thread {

    private final AccountLock account1;
    private final AccountLock account2;

    public AccountLockThread(AccountLock account1, AccountLock account2) {
        this.account1 = account1;
        this.account2 = account2;
    }

    @Override
    public void run() {
        for (int i = 0; i < 2000; i++) {
            lockAccounts();
            try {
                if (account1.takeOff(10)) {
                    account2.addMoney(10);
                }
            } finally {
                account1.getLock().unlock();
                account2.getLock().unlock();
            }

        }
    }

    private void lockAccounts() {
        while (true) {
            boolean tryFromLock = account1.getLock().tryLock();
            boolean tryToLock = account2.getLock().tryLock();
            if (tryFromLock && tryToLock) {
                break;
            }
            if (tryFromLock) {
                account1.getLock().unlock();
            }
            if (tryToLock) {
                account2.getLock().unlock();
            }
        }
    }
}
