import java.util.ArrayList;
import java.util.List;

public class RotateList {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>(List.of(10, 20, 30, 40, 50));
        System.out.println("Original List: " + list);
        rotateList(list, 2);
        System.out.println("Rotated List: " + list);
    }

    public static <T> void rotateList(List<T> list, int positions) {
        int size = list.size();
        if (size == 0) return;
        positions = positions % size;
        List<T> tempList = new ArrayList<>(list.subList(size - positions, size));
        list.subList(0, size - positions).clear();
        list.addAll(0, tempList);
    }
}