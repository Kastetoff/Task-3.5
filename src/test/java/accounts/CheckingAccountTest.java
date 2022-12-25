package accounts;

import org.junit.jupiter.api.*;

@DisplayName("Тестирование расчетного счета")
public class CheckingAccountTest {
    private CheckingAccount checkingAccount;

    @BeforeEach
    void createAccount() {
        checkingAccount = new CheckingAccount("Test", 1_000);
    }

    @Test
    @DisplayName("Положительный баланс")
    void positiveBalance() {
        Assertions.assertEquals(1_000, checkingAccount.getBalance());
    }

    @Test
    @DisplayName("Отрицательный баланс")
    void negativeBalance() {
        Assertions.assertThrows(RuntimeException.class, () -> new CheckingAccount("Test", -1_000));
    }

    @Test
    @DisplayName("Баланс больше чем сумма платежа")
    void positivePay() {
        Assertions.assertTrue(checkingAccount.pay(750));
        Assertions.assertEquals(250, checkingAccount.getBalance());
    }

    @Test
    @DisplayName("Баланс меньше чем сумма платежа")
    void negativePay() {
        Assertions.assertFalse(checkingAccount.pay(1_500));
        Assertions.assertEquals(1_000, checkingAccount.getBalance());
    }
}