import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class WordFrequencyCounter {
    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("sample.txt");
        Scanner scanner = new Scanner(file);
        Map<String, Integer> wordFrequency = new HashMap<>();
        while (scanner.hasNext()) {
            String word = scanner.next().replaceAll("[^a-zA-Z]", "").toLowerCase();
            if (!word.isEmpty()) {
                wordFrequency.put(word, wordFrequency.getOrDefault(word, 0) + 1);
            }
        }
        scanner.close();
        System.out.println("Word Frequency: " + wordFrequency);
    }
}