package accounts;

import org.junit.jupiter.api.*;

@DisplayName("Тестирование кредитного счета")

public class CreditAccountTest {
    private CreditAccount creditAccount;

    @BeforeEach
    void createAccount() {
        creditAccount = new CreditAccount("Test", -1_000);
    }

    @Test
    @DisplayName("Положительный баланс")
    void positiveBalance() {
        Assertions.assertThrows(RuntimeException.class, () -> new CreditAccount("PositiveBalance", 1_000));
    }

    @Test
    @DisplayName("Отрицательный баланс")
    void negativeBalance() {
        Assertions.assertEquals(-1_000, creditAccount.getBalance());
    }

    @Test
    @DisplayName("Оплата")
    void pay() {
        Assertions.assertTrue(creditAccount.pay(5_000));
        Assertions.assertEquals(-6_000, creditAccount.getBalance());
    }

    @Test
    @DisplayName("Пополнение")
    void add() {
//        creditAccount = new CreditAccount("PayTest", 1_000);
        Assertions.assertFalse(creditAccount.add(2_000));
        Assertions.assertEquals(-1_000, creditAccount.getBalance());
    }
}