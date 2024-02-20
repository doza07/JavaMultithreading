package account;

public class Account {

    private static int generator = 1;
    private int id;
    private int money;

    public Account(int money) {
        this.money = money;
        this.id = generator++;
    }

    public void addMoney(int money) {
        this.money += money;
    }

    public boolean takeOff(int money) {
        if (this.money >= money) {
            this.money -= money;
            return true;
        } else
            System.out.println("No money");
            return false;
    }

    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                ", money=" + money +
                '}';
    }
}
