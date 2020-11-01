package pi.approximators;

import org.apfloat.Apfloat;
import org.apfloat.ApfloatMath;

public class ZetaApproximator implements IApproximator{
    @Override
    public String approximate(int precision) {
        Apfloat sum = Apfloat.ZERO;
        int floatPrecision = getFloatPrecision();
        for(int i = 1; i < precision*2; i++) {
            sum = sum.add(Apfloat.ONE.
                    divide(ApfloatMath
                            .pow(new Apfloat(i,floatPrecision),
                                    new Apfloat(2, floatPrecision))));
        }
        sum = ApfloatMath.sqrt(sum.multiply(new Apfloat(6,floatPrecision)));
        return sum.toString(true);
    }

    @Override
    public String approximate(int precision, int from, int until) {
        return approximate(precision);
    }
}
