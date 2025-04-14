import java.util.regex.Pattern;

public class ValidateCreditCard {
    public static void main(String[] args) {
        String[] cards = {"4123456789012345", "5123456789012345", "3123456789012345"};
        Pattern pattern = Pattern.compile("^(4|5)\\d{15}$");
        for (String card : cards) {
            System.out.println(card + " -> " + (pattern.matcher(card).matches() ? "Valid" : "Invalid"));
        }
    }
}