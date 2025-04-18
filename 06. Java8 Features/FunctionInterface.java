import java.util.function.Function;

public class FunctionInterface {
    public double calculateCircleArea(double radius) {
        Function<Double, Double> areaCalc = r -> Math.PI * r * r;
        return areaCalc.apply(radius);
    }
}