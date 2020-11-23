package bc.providers;

public interface IBasicMathFunctionality extends IMath {
    public double add(double a, double b);

    public double subtract(double a, double b);

    public double multiply(double a, double b);

    public double divide(double a, double b);

    public double mod(double a, double b);
}