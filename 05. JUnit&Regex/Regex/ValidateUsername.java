import java.util.regex.Pattern;

public class ValidateUsername {
    public static void main(String[] args) {
        String[] usernames = {"user_123", "123user", "us"};
        Pattern pattern = Pattern.compile("^[a-zA-Z][a-zA-Z0-9_]{4,14}$");
        for (String username : usernames) {
            System.out.println(username + " -> " + (pattern.matcher(username).matches() ? "Valid" : "Invalid"));
        }
    }
}