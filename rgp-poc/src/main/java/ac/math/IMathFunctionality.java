package ac.math;

public interface IMathFunctionality<T> extends IMath {
    public T add(T a, T b);

    public T subtract(T a, T b);

    public T multiply(T a, T b);

    public T divide(T a, T b);

    public T sin(T a);

    public T cos(T a);

    public T tan(T a);

    public T ctg(T a);

    public T mod(T a, T b);

    public T power(T a, T b);

    public T sqrt(T a);

    public T factorial(T n);

    public T gcd(T a, T b);

    public T lcm(T a, T b);

}
