import java.util.HashSet;
import java.util.Set;

public class SymmetricDifference {
    public static void main(String[] args) {
        Set<Integer> set1 = new HashSet<>(Set.of(1, 2, 3));
        Set<Integer> set2 = new HashSet<>(Set.of(3, 4, 5));
        Set<Integer> symmetricDifference = new HashSet<>(set1);
        symmetricDifference.addAll(set2);
        Set<Integer> intersection = new HashSet<>(set1);
        intersection.retainAll(set2);
        symmetricDifference.removeAll(intersection);
        System.out.println("Symmetric Difference: " + symmetricDifference);
    }
}