package accounts;

public class CheckingAccount extends Account {
    private final long MIN_BALANCE = 0;

    public CheckingAccount(String name, long balance) {
        super(name, balance);
        if (balance >= 0) {
            this.balance = balance;
        } else throw new RuntimeException("Баланс не может быть отрицательным!");
    }

    @Override
    public boolean pay(long amount) {
        if (amount > 0 && (balance - amount) >= MIN_BALANCE) {
            balance -= amount;
            return true;
        } else return false;
    }
}