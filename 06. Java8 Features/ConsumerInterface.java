import java.util.*;
import java.util.function.Consumer;

public class ConsumerInterface {
    public void printUppercase(List<String> strings) {
        Consumer<String> printUpper = s -> System.out.println(s.toUpperCase());
        strings.forEach(printUpper);
    }
}