package ac.math;

import org.apfloat.Apfloat;
import org.apfloat.ApfloatMath;

public class AdvancedMath implements IMathFunctionality<Apfloat>{

    @Override
    public Apfloat add(Apfloat a, Apfloat b) {
        return a.add(b);
    }

    @Override
    public Apfloat subtract(Apfloat a, Apfloat b) {
        return a.subtract(b);
    }

    @Override
    public Apfloat multiply(Apfloat a, Apfloat b) {
        return a.multiply(b);
    }

    @Override
    public Apfloat divide(Apfloat a, Apfloat b) {
        return b.compareTo(Apfloat.ZERO) == 0 ? Apfloat.ZERO : a.divide(b);
    }

    @Override
    public Apfloat sin(Apfloat a) {
        return ApfloatMath.sin(a);
    }

    @Override
    public Apfloat cos(Apfloat a) {
        return null;
    }

    @Override
    public Apfloat tan(Apfloat a) {
        return null;
    }

    @Override
    public Apfloat ctg(Apfloat a) {
        return null;
    }

    @Override
    public Apfloat mod(Apfloat a, Apfloat b) {
        return null;
    }

    @Override
    public Apfloat power(Apfloat a, Apfloat b) {
        return null;
    }

    @Override
    public Apfloat sqrt(Apfloat a) {
        return null;
    }

    @Override
    public Apfloat factorial(Apfloat n) {
        return null;
    }

    @Override
    public Apfloat gcd(Apfloat a, Apfloat b) {
        return null;
    }

    @Override
    public Apfloat lcm(Apfloat a, Apfloat b) {
        return null;
    }
}
