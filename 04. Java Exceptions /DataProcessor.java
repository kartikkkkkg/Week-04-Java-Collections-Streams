import java.io.IOException;

public class DataProcessor {
    public void processData(String data) throws IOException {
        if (data == null) {
            throw new NullPointerException("Data cannot be null");
        }
        if (data.isEmpty()) {
            throw new IOException("Data cannot be empty");
        }
        System.out.println("Data processed: " + data);
    }

    public static void main(String[] args) {
        DataProcessor processor = new DataProcessor();
        try {
            processor.processData(null);
        } catch (NullPointerException e) {
            System.err.println("Unchecked exception: " + e.getMessage());
        } catch (IOException e) {
            System.err.println("Checked exception: " + e.getMessage());
        }
        try {
            processor.processData("");
        } catch (NullPointerException e) {
            System.err.println("Unchecked exception: " + e.getMessage());
        } catch (IOException e) {
            System.err.println("Checked exception: " + e.getMessage());
        }
    }
}