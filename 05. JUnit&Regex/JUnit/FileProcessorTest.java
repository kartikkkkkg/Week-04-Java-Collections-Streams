import org.junit.jupiter.api.Test;
import java.io.File;
import java.io.IOException;
import static org.junit.jupiter.api.Assertions.*;

class FileProcessorTest {
    private final FileProcessor processor = new FileProcessor();
    private final String filename = "test.txt";

    @Test
    void testWriteAndRead() throws IOException {
        String content = "Hello";
        processor.writeToFile(filename, content);
        assertEquals(content, processor.readFromFile(filename));
        assertTrue(new File(filename).exists());
    }

    @Test
    void testReadNonExistentFile() {
        assertThrows(IOException.class, () -> processor.readFromFile("nonexistent.txt"));
    }
}