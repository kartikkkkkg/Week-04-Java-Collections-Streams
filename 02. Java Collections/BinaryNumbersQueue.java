import java.util.LinkedList;
import java.util.Queue;

public class BinaryNumbersQueue {
    public static void main(String[] args) {
        int n = 5;
        generateBinaryNumbers(n);
    }

    public static void generateBinaryNumbers(int n) {
        Queue<String> queue = new LinkedList<>();
        queue.add("1");
        for (int i = 0; i < n; i++) {
            String binary = queue.poll();
            System.out.println(binary);
            queue.add(binary + "0");
            queue.add(binary + "1");
        }
    }
}