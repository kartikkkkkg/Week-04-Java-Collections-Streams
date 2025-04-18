import java.util.function.BiFunction;

public class BiFunctionInterface {
    public String concatenateStrings(String s1, String s2) {
        BiFunction<String, String, String> concat = (a, b) -> a + " " + b;
        return concat.apply(s1, s2);
    }
}