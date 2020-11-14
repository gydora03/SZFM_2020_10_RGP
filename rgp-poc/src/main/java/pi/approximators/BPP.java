package pi.approximators;

import java.util.List;
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

            double pi = 4.0 * d1 - 2.0 * d4 - d5 - d6;

            pi = pi - StrictMath.floor(pi);

            int digit = (int) StrictMath.floor(pi * 16.0);
            Character hex = Character.forDigit(digit, 16);
            hexLetters.append(hex.charValue());

        }
        return hexLetters.toString();
    }

    private int expmod(int base, int exponent, int modulo) {
        int t = 1;
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
                r = (int) (StrictMath.pow(r, 2) % modulo);
            else
                break;
        }
        return r;
    }

    public double calculateSubFormula(int formulaPartId, int d) {
        double result = 0.0;
        int i;
        int base = 16;
        int exp, mod;
        for (i = 0; i <= d; i += 1) {
            exp = d - i;
            mod = i * 8 + formulaPartId;
            result += (double) expmod(base, exp, mod) / mod;
            result -= StrictMath.floor(result);
        }
        return result;

    }
}
