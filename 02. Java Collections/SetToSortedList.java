import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class SetToSortedList {
    public static void main(String[] args) {
        Set<Integer> set = new HashSet<>(Set.of(5, 3, 9, 1));
        List<Integer> sortedList = set.stream().sorted().collect(Collectors.toList());
        System.out.println("Sorted List: " + sortedList);
    }
}