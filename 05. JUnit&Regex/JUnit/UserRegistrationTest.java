import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class UserRegistrationTest {
    private final UserRegistration registration = new UserRegistration();

    @Test
    void testValidRegistration() {
        assertDoesNotThrow(() -> registration.registerUser("user1", "user@example.com", "password123"));
    }

    @Test
    void testInvalidUsername() {
        assertThrows(IllegalArgumentException.class,
            () -> registration.registerUser("", "user@example.com", "password123"));
    }

    @Test
    void testInvalidEmail() {
        assertThrows(IllegalArgumentException.class,
            () -> registration.registerUser("user1", "invalid", "password123"));
    }

    @Test
    void testInvalidPassword() {
        assertThrows(IllegalArgumentException.class,
            () -> registration.registerUser("user1", "user@example.com", "pass"));
    }
}