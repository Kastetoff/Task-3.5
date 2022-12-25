package accounts;

public class Account {
    protected String name;
    protected long balance;

    public Account(String name, long balance) {
        this.name = name;
        this.balance = balance;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setBalance(long balance) {
        if (balance >= 0) {
            this.balance = balance;
        }
    }

    public long getBalance() {
        return balance;
    }

    public boolean pay(long amount) {
        if (amount > 0 && amount < balance) {
            balance -= amount;
            return true;
        } else return false;
    }

    public boolean add(long amount) {
        if (amount > 0) {
            balance += amount;
            return true;
        } else return false;
    }
}