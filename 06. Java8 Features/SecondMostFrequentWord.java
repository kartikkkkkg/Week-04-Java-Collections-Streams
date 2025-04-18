import java.util.*;
import java.util.stream.Collectors;

public class SecondMostFrequentWord {
    public String findSecondMostFrequent(String text) {
        return Arrays.stream(text.toLowerCase().replaceAll("[^a-zA-Z\\s]", "").split("\\s+"))
                .filter(word -> !word.isEmpty())
                .collect(Collectors.groupingBy(
                        word -> word,
                        Collectors.counting()
                ))
                .entrySet().stream()
                .sorted(Map.Entry.<String, Long>comparingByValue().reversed())
                .skip(1)
                .findFirst()
                .map(Map.Entry::getKey)
                .orElse("");
    }
}