package pi.approximators;

import org.apfloat.Apfloat;

public class LeibnizApproximator implements IApproximator {
    @Override
    public String approximate(int precision) {
        int floatPrecision = getFloatPrecision();
        Apfloat pi = Apfloat.ONE;
        Apfloat sum = new Apfloat(0, floatPrecision);

        for (int i = 1; i < precision*2; i++) {
            sum = Apfloat.ONE.divide(new Apfloat(String.valueOf(i), floatPrecision)
                    .multiply(new Apfloat("2", floatPrecision)).add(Apfloat.ONE));
            if((i-1) % 2 == 0)
                pi = pi.subtract(sum);
            else
                pi = pi.add(sum);
        }
        pi = pi.multiply(new Apfloat("4", floatPrecision));
        return pi.toString(true);

    }

    @Override
    public String approximate(int from, int until) {
        return approximate(getFloatPrecision());
    }
}
