package ac.math;

public class BasicMath implements IMathFunctionality<Double> {
    public Double add(Double a, Double b) {
        return a + b;
    }

    public Double subtract(Double a, Double b) {
        return a - b;
    }

    public Double multiply(Double a, Double b) {
        return a * b;
    }

    public Double divide(Double a, Double b) {
        if (b > 0 || b < 0)
            return a / b;
        else
            return Double.NaN;
    }

    public Double sin(Double a) {
        return StrictMath.sin(StrictMath.toRadians(a));
    }

    public Double cos(Double a) {
        return StrictMath.cos(StrictMath.toRadians(a));
    }

    public Double tan(Double a) {
        return StrictMath.tan(StrictMath.toRadians(a));
    }

    public Double ctg(Double a) {
        if (a < 0 || a > 0)
            return 1.0 / StrictMath.tan(StrictMath.toRadians(a));
        else
            return Double.NaN;
    }

    public Double mod(Double a, Double b) {
        return a % b;
    }

    public Double power(Double a, Double b) {
        return StrictMath.pow(a, b);
    }

    public Double sqrt(Double a) {
        if (a >= 0)
            return StrictMath.sqrt(a);
        else
            return Double.NaN;
    }

    public Double factorial(Double n) {
        Double f = 1.0;
        long input = n.longValue();
        for (; input > 0; input--) {
            f *= input;
        }

        return f;
    }

    public Double gcd(Double a, Double b) {
        int _b =  b.intValue();
        if (_b == 0)
            return 0.0;
        int _a = a.intValue();

        while (_b > 0) {
            int result = _a % _b;
            _a = _b;
            _b = result;
        }

        return Double.parseDouble(String.valueOf(_a));    }

    public Double lcm(Double a, Double b) {
        return (a * b) / gcd(a, b);
    }

}
