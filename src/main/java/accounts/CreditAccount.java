package accounts;

public class CreditAccount extends Account {

    public CreditAccount(String name, long balance) {
        super(name, balance);
        if (balance < 0) {
            this.balance = balance;
        } else throw new RuntimeException("Баланс не может быть положительным");
    }

    @Override
    public void setBalance(long balance) {
        if (balance <= 0) {
            this.balance = balance;
        }
    }

    @Override
    public boolean pay(long amount) {
        if (amount > 0) {
            balance -= amount;
            return true;
        } else return false;
    }

    @Override
    public boolean add(long amount) {
        if (balance + amount <= 0) {
            balance += amount;
            return true;
        } else return false;
    }
}