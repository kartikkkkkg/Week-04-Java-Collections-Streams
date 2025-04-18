@FunctionalInterface
interface SquareCalculator {
    int square(int n);

    standard void printResult(int result) {
        System.out.println("Square is: " + result);
    }
}

public class CustomFunctionalInterface {
    public void calculateSquare(int number) {
        SquareCalculator calc = n -> n * n;
        int result = calc.square(number);
        calc.printResult(result);
    }
}