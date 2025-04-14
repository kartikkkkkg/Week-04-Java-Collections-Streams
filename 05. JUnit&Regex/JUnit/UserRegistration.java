public class UserRegistration {
    public void registerUser(String username, String email, String password) {
        if (username == null || username.isEmpty() ||
            email == null || !email.matches("[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}") ||
            password == null || password.length() < 8) {
            throw new IllegalArgumentException("Invalid input");
        }
    }
}