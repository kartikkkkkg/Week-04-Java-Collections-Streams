import java.util.*;
import java.util.stream.Collectors;

public class WordFrequency {
    public List<Map.Entry<String, Long>> findTopNWords(String text, int n) {
        return Arrays.stream(text.toLowerCase().replaceAll("[^a-zA-Z\\s]", "").split("\\s+"))
                .filter(word -> !word.isEmpty())
                .collect(Collectors.groupingBy(
                        word -> word,
                        Collectors.counting()
                ))
                .entrySet().stream()
                .sorted(Map.Entry.<String, Long>comparingByValue().reversed())
                .limit(n)
                .collect(Collectors.toList());
    }
}