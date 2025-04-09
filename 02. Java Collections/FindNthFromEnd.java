import java.util.LinkedList;

public class FindNthFromEnd {
    public static void main(String[] args) {
        LinkedList<String> list = new LinkedList<>();
        list.add("A");
        list.add("B");
        list.add("C");
        list.add("D");
        list.add("E");
        System.out.println("Original List: " + list);
        String result = findNthFromEnd(list, 2);
        System.out.println("Nth Element from the End: " + result);
    }

    public static <T> T findNthFromEnd(LinkedList<T> list, int n) {
        int size = list.size();
        if (n > size) return null;
        return list.get(size - n);
    }
}