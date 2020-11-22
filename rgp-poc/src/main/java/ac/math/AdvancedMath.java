package ac.math;

import org.apfloat.Apfloat;
import org.apfloat.ApfloatMath;
import org.apfloat.ApintMath;

public class AdvancedMath implements IMathFunctionality{

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
        return ApfloatMath.sin(ApfloatMath.toRadians(a));
    }

    @Override
    public Apfloat cos(Apfloat a) {
        return ApfloatMath.cos(ApfloatMath.toRadians(a));
    }

    @Override
    public Apfloat tan(Apfloat a) {
        return ApfloatMath.tan(ApfloatMath.toRadians(a));
    }

    @Override
    public Apfloat ctg(Apfloat a) {
        return a.compareTo(Apfloat.ZERO) == 0 ? Apfloat.ZERO : Apfloat.ONE.
                divide(ApfloatMath.tan(ApfloatMath.toRadians(a)));
    }

    @Override
    public Apfloat mod(Apfloat a, Apfloat b) {
        return a.mod(b);
    }

    @Override
    public Apfloat power(Apfloat a, Apfloat b) {
        return ApfloatMath.pow(a,b);
    }

    @Override
    public Apfloat sqrt(Apfloat a) {
        return ApfloatMath.sqrt(a);
    }

    @Override
    public Apfloat factorial(Apfloat n) {
        return ApintMath.factorial(n.longValue());
    }

}
