import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

public class FileProcessor {
    public void processFiles(List<String> filePaths) {
        for (String path : filePaths) {
            try (BufferedReader reader = new BufferedReader(new FileReader(path))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    System.out.println(line);
                }
            } catch (IOException e) {
                System.err.println("Error reading file " + path + ": " + e.getMessage());
            }
        }
    }
}