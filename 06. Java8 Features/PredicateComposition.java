import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class PredicateComposition {
    public List<String> filterStrings(List<String> strings, String substring) {
        Predicate<String> lengthCheck = s -> s.length() > 5;
        Predicate<String> substringCheck = s -> s.contains(substring);
        return strings.stream()
                .filter(lengthCheck.and(substringCheck))
                .collect(Collectors.toList());
    }
}