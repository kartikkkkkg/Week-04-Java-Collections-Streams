import java.util.*;
import java.util.stream.Collectors;

public class FilterStrings {
    public List<String> filterStrings(List<String> strings) {
        return strings.stream()
                .filter(s -> !s.startsWith("A"))
                .collect(Collectors.toList());
    }
}