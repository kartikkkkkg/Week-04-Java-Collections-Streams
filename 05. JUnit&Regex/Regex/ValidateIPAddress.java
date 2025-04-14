import java.util.regex.Pattern;

public class ValidateIPAddress {
    public static void main(String[] args) {
        String[] ips = {"192.168.1.1", "256.1.2.3"};
        Pattern pattern = Pattern.compile("^(?:(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.){3}(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)$");
        for (String ip : ips) {
            System.out.println(ip + " -> " + (pattern.matcher(ip).matches() ? "Valid" : "Invalid"));
        }
    }
}