class UserAlreadyExistsException extends Exception {
    public UserAlreadyExistsException(String message) {
        super(message);
    }
}

class UserNotFoundException extends Exception {
    public UserNotFoundException(String message) {
        super(message);
    }
}

public class UserService {
    public void registerUser(String username) throws UserAlreadyExistsException {
        if (checkUserExistence(username)) {
            throw new UserAlreadyExistsException("User " + username + " already exists");
        }
        System.out.println("User " + username + " registered");
    }

    public boolean checkUserExistence(String username) {
        return username.equals("existingUser");
    }

    public static void main(String[] args) {
        UserService service = new UserService();
        try {
            service.registerUser("existingUser");
        } catch (UserAlreadyExistsException e) {
            System.err.println("Registration failed: " + e.getMessage());
        }
        try {
            service.registerUser("newUser");
        } catch (UserAlreadyExistsException e) {
            System.err.println("Registration failed: " + e.getMessage());
        }
    }
}