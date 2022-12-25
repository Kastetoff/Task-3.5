package accounts;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Тестирование накопительного счета")

public class SavingsAccountTest {
    private SavingsAccount savingsAccount;

    @BeforeEach
    void createAccount() {
        savingsAccount = new SavingsAccount("Test", 15_000, 5_000);
    }

    @Test
    @DisplayName("Положительный баланс")
    void positiveBalance() {
        Assertions.assertEquals(15_000, savingsAccount.getBalance());
    }

    @Test
    @DisplayName("Отрицательный баланс")
    void negativeBalance() {
        Assertions.assertThrows(RuntimeException.class, () -> new CheckingAccount("Test", -1_000));
    }

    @Test
    @DisplayName("Оплата без превышения минимального баланса")
    void positivePay() {
        Assertions.assertTrue(savingsAccount.pay(8_000));
        Assertions.assertEquals(7_000, savingsAccount.getBalance());
    }


    @Test
    @DisplayName("Оплата с превышением минимального баланса")
    void negativePay() {
        Assertions.assertFalse(savingsAccount.pay(12_000));
        Assertions.assertEquals(15_000, savingsAccount.getBalance());
    }
}