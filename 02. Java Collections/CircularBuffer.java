import java.util.LinkedList;
import java.util.Queue;

public class CircularBuffer {
    private Queue<Integer> buffer;
    private int size;

    public CircularBuffer(int size) {
        this.size = size;
        this.buffer = new LinkedList<>();
    }

    public void insert(int value) {
        if (buffer.size() == size) {
            buffer.poll();
        }
        buffer.add(value);
    }

    public void displayBuffer() {
        System.out.println("Buffer: " + buffer);
    }

    public static void main(String[] args) {
        CircularBuffer circularBuffer = new CircularBuffer(3);
        circularBuffer.insert(1);
        circularBuffer.insert(2);
        circularBuffer.insert(3);
        circularBuffer.displayBuffer();
        circularBuffer.insert(4);
        circularBuffer.displayBuffer();
    }
}