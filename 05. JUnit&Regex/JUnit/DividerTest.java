import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class DividerTest {
    private final Divider divider = new Divider();

    @Test
    void testDivideByZero() {
        assertThrows(ArithmeticException.class, () -> divider.divide(4, 0));
    }
}