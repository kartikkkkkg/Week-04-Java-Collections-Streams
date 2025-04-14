import java.util.regex.Pattern;

public class ValidateLicensePlate {
    public static void main(String[] args) {
        String[] plates = {"AB1234", "A12345"};
        Pattern pattern = Pattern.compile("^[A-Z]{2}\\d{4}$");
        for (String plate : plates) {
            System.out.println(plate + " -> " + (pattern.matcher(plate).matches() ? "Valid" : "Invalid"));
        }
    }
}