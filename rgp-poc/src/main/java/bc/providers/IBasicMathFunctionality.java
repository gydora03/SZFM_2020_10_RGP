package providers;

public interface IBasicMathFunctionality extends IMath {
    public double add(double a, double b);

    public double subtract(double a, double b);

    public double multiply(double a, double b);

    public double divide(double a, double b);

    public double sin(double a);

    public double cos(double a);

    public double tan(double a);

    public double ctg(double a);

    public double mod(double a, double b);

    public double power(double a, double b);

    public double sqrt(double a);

    public double factorial(double n);

    public double gcd(double a, double b);

    public double lcm(double a, double b);

}
