package pi.approximators;

import org.apfloat.Apfloat;
import org.apfloat.ApfloatMath;
import org.apfloat.Apint;
import org.apfloat.ApintMath;

public class BPP implements IApproximator {
    private int precision = getFloatPrecision();
    @Override
    public String approximate(int precision) {
        return approximate(precision, 0, 1000001);
    }

    @Override
    public String approximate(int precision, int n, int limit) {
        StringBuilder hexLetters = new StringBuilder();
        this.precision = Math.max(getFloatPrecision(),precision);
        Apfloat d1 = calculateSubFormula(1, n);
        Apfloat d4 = calculateSubFormula(4, n);
        Apfloat d5 = calculateSubFormula(5, n);
        Apfloat d6 = calculateSubFormula(6, n);

        Apfloat pi = (new Apfloat(4, this.precision).multiply(d1)).
                subtract(new Apfloat(2, this.precision).multiply(d4))
                .subtract(d5).subtract(d6);
        pi = pi.subtract(ApfloatMath.floor(pi));

        for (int i = n; i < limit; i++) {
            Apint digit = ApfloatMath.floor(pi.multiply(new Apfloat(16, this.precision)));
            Character hex = Character.forDigit(digit.intValue(), 16);

            hexLetters.append(hex.charValue());
        }

        return hexLetters.toString();
    }

    private Apint expmod(Apint base, Apint exponent, Apint modulo) {
        Apint t = Apint.ONE;
        Apint r = Apint.ONE;
        Apint e = exponent.add(Apint.ZERO);
        while (t.compareTo(e) <= 0) {
            t = t.multiply(new Apint(2));
        }

        while (true) {
            if (e.compareTo(t) >= 0) {
                r = r.multiply(base).mod(modulo);
                e = e.subtract(t);
            }

            t = t.divide(new Apint(2));

            if (t.compareTo(Apint.ONE) >= 0)
                r = ApintMath.modPow(r, new Apint(2), modulo);
            else
                break;
        }
        return r;
    }

    public Apfloat calculateSubFormula(int formulaPartId, long d) {
        Apfloat result = Apfloat.ZERO;
        Apint i;
        Apint base = new Apint(16);
        Apint exp, mod;
        for (i = new Apint(0); i.compareTo(new Apint(d)) < 0; i = i.add(Apint.ONE)) {
            exp = new Apint(d).subtract(i);
            mod = i.multiply(new Apint(8)).add(new Apint(formulaPartId));
            result = result.add(expmod(base, exp, mod).divide(new Apfloat(mod.toString(),precision)));
            result = result.subtract(ApfloatMath.floor(result));
        }

        return result;

    }
}
