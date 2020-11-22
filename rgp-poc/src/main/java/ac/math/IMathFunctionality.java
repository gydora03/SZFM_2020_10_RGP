package ac.math;

import org.apfloat.Apfloat;

public interface IMathFunctionality extends IMath {
    public Apfloat add(Apfloat a, Apfloat b);

    public Apfloat subtract(Apfloat a, Apfloat b);

    public Apfloat multiply(Apfloat a, Apfloat b);

    public Apfloat divide(Apfloat a, Apfloat b);

    public Apfloat sin(Apfloat a);

    public Apfloat cos(Apfloat a);

    public Apfloat tan(Apfloat a);

    public Apfloat ctg(Apfloat a);

    public Apfloat mod(Apfloat a, Apfloat b);

    public Apfloat power(Apfloat a, Apfloat b);

    public Apfloat sqrt(Apfloat a);

    public Apfloat factorial(Apfloat n);

}
