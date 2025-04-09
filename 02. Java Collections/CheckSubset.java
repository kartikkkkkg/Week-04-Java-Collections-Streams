import java.util.HashSet;
import java.util.Set;

public class CheckSubset {
    public static void main(String[] args) {
        Set<Integer> set1 = new HashSet<>(Set.of(2, 3));
        Set<Integer> set2 = new HashSet<>(Set.of(1, 2, 3, 4));
        System.out.println("Is set1 a subset of set2? " + set2.containsAll(set1));
    }
}