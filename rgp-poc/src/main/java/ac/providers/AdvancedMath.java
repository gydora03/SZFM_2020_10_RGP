package ac.providers;

public class AdvancedMath implements IAdvancedMathFunctionality {
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

    public double sin(double a) {
        return StrictMath.sin(StrictMath.toRadians(a));
    }

    public double cos(double a) {
        return StrictMath.cos(StrictMath.toRadians(a));
    }

    public double tan(double a) {
        return StrictMath.tan(StrictMath.toRadians(a));
    }

    public double ctg(double a) {
        if (a < 0 || a > 0)
            return 1.0 / StrictMath.tan(StrictMath.toRadians(a));
        else
            return Double.NaN;
    }

    public double mod(double a, double b) {
        return a % b;
    }

    public double power(double a, double b) {
        return StrictMath.pow(a, b);
    }

    public double sqrt(double a)
    {
        if(a >= 0)
            return StrictMath.sqrt(a);
        else
            return Double.NaN;
    }

    public double factorial(double n) {
        double f = 1.0;
        long input = (long) n;
        for (; input > 0; input--) {
            f *= input;
        }

        return f;
    }

    public double gcd(double a, double b) {
        int _b = (int) b;
        if (_b == 0)
            return 0.0;
        int _a = (int) a;

        while (_b > 0) {
            int result = _a % _b;
            _a = _b;
            _b = result;
        }

        return _a;
    }

    public double lcm(double a, double b) {
        return (a * b) / gcd(a, b);
    }

}