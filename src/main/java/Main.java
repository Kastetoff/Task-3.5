import accounts.Account;
import accounts.CheckingAccount;
import accounts.CreditAccount;
import accounts.SavingsAccount;

public class Main {
    public static void main(String[] args) throws Exception {
        Account account = new Account("", 0);
        account.setName("Maksim");
        account.getName();
        account.setBalance(200);
        account.getBalance();
        account.add(100);
        account.pay(250);

//        Накопительный счет
        SavingsAccount savingAccount = new SavingsAccount("", 0, 1000);
        savingAccount.setName("Save");
        savingAccount.setBalance(1000);
        savingAccount.setMinBalance(1500);
        savingAccount.add(500);
        savingAccount.pay(200);

//        Расчетный счет
        CheckingAccount checkingAccount = new CheckingAccount("", 0);
        checkingAccount.setName("Main");
        checkingAccount.setBalance(2000);
        checkingAccount.add(400);
        checkingAccount.pay(4000);

//        Кредитный счет
        CreditAccount creditAccount = new CreditAccount("", -10);
        creditAccount.setName("Credit");
        creditAccount.setBalance(-500);
        creditAccount.pay(1500);
        creditAccount.add(1000);
    }
}