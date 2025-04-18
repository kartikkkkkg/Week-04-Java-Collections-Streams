import java.util.*;

public class OptionalHandling {
    public Optional<Integer> findMax(List<Integer> numbers) {
        return numbers.stream()
                .max(Integer::compare);
    }
}