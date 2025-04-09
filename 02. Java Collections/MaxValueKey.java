import java.util.HashMap;
import java.util.Map;

public class MaxValueKey {
    public static void main(String[] args) {
        Map<String, Integer> map = new HashMap<>();
        map.put("A", 10);
        map.put("B", 20);
        map.put("C", 15);
        String keyWithMaxValue = findKeyWithMaxValue(map);
        System.out.println("Key with the highest value: " + keyWithMaxValue);
    }

    public static String findKeyWithMaxValue(Map<String, Integer> map) {
        String keyWithMaxValue = null;
        int maxValue = Integer.MIN_VALUE;
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            if (entry.getValue() > maxValue) {
                maxValue = entry.getValue();
                keyWithMaxValue = entry.getKey();
            }
        }
        return keyWithMaxValue;
    }
}