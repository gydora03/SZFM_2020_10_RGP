package pi.approximators;

import com.sun.glass.ui.Application;
import org.apfloat.Apfloat;
import org.apfloat.ApfloatMath;
import org.apfloat.Apint;
import org.apfloat.ApintMath;

import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class BPP implements IApproximator {
    double d1, d4, d5, d6;
    List<Future<Double>> ds = null;

    private ExecutorService execService;

    @Override
    public String approximate(int precision) {
        return approximate(1000000, 1000001);
    }

    @Override
    public String approximate(int from, int limit) {
        StringBuilder hexLetters = new StringBuilder();
        execService = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());
        for (int i = from; i < limit; i++) {

            final int iter = i;
            try {
                ds = execService.invokeAll(List.of(
                        () -> calculateSubFormula(1, iter),
                        () -> calculateSubFormula(4, iter),
                        () -> calculateSubFormula(5, iter),
                        () -> calculateSubFormula(6, iter)

                ));

                d1 = ds.get(0).get();
                d4 = ds.get(1).get();
                d5 = ds.get(2).get();
                d6 = ds.get(3).get();
            } catch (Exception e) {
                System.err.println(e.getMessage());
                System.exit(-6);
            }

            double pi = 4.0*d1-2.0*d4-d5-d6;

            pi = pi - StrictMath.floor(pi);

            int digit = (int)StrictMath.floor(pi*16.0);
            Character hex = Character.forDigit(digit, 16);
            hexLetters.append(hex.charValue());

        }
        return hexLetters.toString();
    }

    private int expmod(int base, int exponent, int modulo) {
        int t =1;
        int r = 1;
        int e = exponent;
        while (t <= e) {
            t *= 2;
        }

        while (true) {
            if (e >= t) {
                r = (r * base) % (modulo);
                e -= t;
            }

            t /= 2;

            if (t >= 1)
                r = (int)(StrictMath.pow(r,2) % modulo);
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
        for (i = new Apint(0); i.compareTo(new Apint(d)) <= 0; i = i.add(Apint.ONE)) {
            exp = new Apint(d).subtract(i);
            mod = i.multiply(new Apint(8)).add(new Apint(formulaPartId));
            result = result.add(expmod(base, exp, mod).divide(new Apfloat(mod.toString(), precision)));
            result = result.subtract(ApfloatMath.floor(result));
            System.out.println(i.toString(true));
        }

        return result;

    }
}
