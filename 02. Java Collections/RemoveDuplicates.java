import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class RemoveDuplicates {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>(List.of(3, 1, 2, 2, 3, 4));
        System.out.println("Original List: " + list);
        removeDuplicates(list);
        System.out.println("List without duplicates: " + list);
    }

    public static <T> void removeDuplicates(List<T> list) {
        Set<T> seen = new LinkedHashSet<>(list);
        list.clear();
        list.addAll(seen);
    }
}