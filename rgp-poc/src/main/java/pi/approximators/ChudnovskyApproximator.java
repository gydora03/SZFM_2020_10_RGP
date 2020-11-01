package pi.approximators;

import org.apfloat.Apfloat;
import org.apfloat.ApfloatMath;
import org.apfloat.Apint;
import org.apfloat.ApintMath;

public class ChudnovskyApproximator implements IApproximator {
    @Override
    public String approximate(int precision) {
        int floatPrecision = getFloatPrecision();
        Apfloat sum = Apfloat.ZERO;
        Apint dividend, divisor;

        for(int i=0; i<precision; i++) {
            dividend = factorial(new Apint(i)
                    .multiply(new Apint(6)))
                    .multiply(new Apint(13591409)
                            .add(new Apint(545140134)
                                    .multiply(new Apint(i))));

            divisor =
                    factorial(new Apint(3).multiply(new Apint(i)))
                            .multiply(ApintMath.pow(factorial(new Apint(i)),3))
                            .multiply(ApintMath.pow(new Apint("-262537412640768000"), floatPrecision))
            ;

            sum = sum.add(new Apfloat(dividend.toString(), floatPrecision)
                    .divide(new Apfloat(divisor.toString(), floatPrecision)));
        }
        sum = sum.divide(new Apfloat("426880",floatPrecision)
                            .multiply(
                                    ApfloatMath.sqrt(new Apfloat("10005", floatPrecision))
                                    ));
        sum = ApfloatMath.pow(sum,new Apfloat("-1", floatPrecision));
        return sum.toString(true);
    }

    @Override
    public String approximate(int precision, int from, int until) {
        return approximate(precision);
    }

    private Apint factorial(Apint number) {
        Apint i;
        Apint fact = Apint.ONE;
        for (i = Apint.ONE; i.compareTo(number) <= 0; i = i.add(Apint.ONE)) {
            fact = fact.multiply(i);
        }
        return fact;
    }
}
