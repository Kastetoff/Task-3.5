package accounts;

public class SavingsAccount extends Account {
    private long minBalance;

    public SavingsAccount(String name, long balance, long minBalance) {
        super(name, balance);
        if (minBalance >= 0) {
            this.minBalance = minBalance;
        }
    }

    public void setMinBalance(long minBalance) {
        if (minBalance >= 0) {
            this.minBalance = minBalance;
        }
    }

    @Override
    public boolean pay(long amount) {
        if (amount > 0 && (balance - amount) > minBalance) {
            balance -= amount;
            return true;
        } else return false;
    }
}