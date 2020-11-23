package bc.providers;

public class BasicMath implements IBasicMathFunctionality {
    public double add(double a, double b) {
        return a + b;
    }

    public double subtract(double a, double b) {
        return a - b;
    }

    public double multiply(double a, double b) {
        return a * b;
    }

    public double divide(double a, double b) {
        if (b > 0 || b < 0)
            return a / b;
        else
            return Double.NaN;
    }

    public double mod(double a, double b) {
        return a % b;
    }
}