import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class BankAccountTest {
    private final BankAccount account = new BankAccount();

    @Test
    void testDeposit() {
        account.deposit(100);
        assertEquals(100, account.getBalance());
    }

    @Test
    void testWithdrawSuccess() {
        account.deposit(100);
        assertTrue(account.withdraw(50));
        assertEquals(50, account.getBalance());
    }

    @Test
    void testWithdrawInsufficientFunds() {
        account.deposit(20);
        assertFalse(account.withdraw(50));
        assertEquals(20, account.getBalance());
    }
}