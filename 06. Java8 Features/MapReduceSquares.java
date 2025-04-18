import java.util.*;

public class MapReduceSquares {
    public int sumOfSquares(List<Integer> numbers) {
        return numbers.stream()
                .filter(n -> n % 2 == 0)
                .map(n -> n * n)
                .reduce(0, (a, b) -> a + b);
    }
}