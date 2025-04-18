@FunctionalInterface
interface SumCalculator {
    int calculate(int a, int b);
}

public class FunctionalInterfaceSum {
    public static void main(String[] args) {
        SumCalculator sum = (a, b) -> a + b;
        System.out.println(sum.calculate(5, 3));
    }
}