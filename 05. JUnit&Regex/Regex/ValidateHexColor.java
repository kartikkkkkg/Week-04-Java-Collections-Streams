import java.util.regex.Pattern;

public class ValidateHexColor {
    public static void main(String[] args) {
        String[] colors = {"#FFA500", "#ff4500", "#123"};
        Pattern pattern = Pattern.compile("^#[0-9A-Fa-f]{6}$");
        for (String color : colors) {
            System.out.println(color + " -> " + (pattern.matcher(color).matches() ? "Valid" : "Invalid"));
        }
    }
}