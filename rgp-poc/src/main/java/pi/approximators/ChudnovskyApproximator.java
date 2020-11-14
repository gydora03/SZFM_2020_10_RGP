package pi.approximators;

import org.apfloat.Apfloat;
import org.apfloat.ApfloatMath;
import org.apfloat.Apint;
import org.apfloat.ApintMath;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class ChudnovskyApproximator implements IApproximator {

    private int floatPrecision;
    private ExecutorService execService;

    @Override
    public String approximate(int precision) {

        floatPrecision = StrictMath.max(precision, getFloatPrecision());
        Apfloat sum = new Apfloat(0, floatPrecision);
        int threadCount = Runtime.getRuntime().availableProcessors();
        execService = Executors.newFixedThreadPool(threadCount);
        int threshold = precision / threadCount;
        var listOfCallables = new ArrayList<Callable<Apfloat>>();

        for (int i = 0; i < threadCount - 1; i++) {
            final int solution = threshold * i;
            final int limit = threshold * (i + 1);
            listOfCallables.add(() -> generateSum(solution, limit));
        }
        listOfCallables.add(() -> generateSum(threshold * threadCount, precision));

        try {
            var listOfSums = execService.invokeAll(listOfCallables);
            for (Future<Apfloat> af : listOfSums) {
                sum = sum.add(af.get());
            }
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        Apfloat partial = new Apfloat("426880", floatPrecision)
                .multiply(ApfloatMath.sqrt(new Apfloat("10005", floatPrecision)));
        sum = partial.divide(sum);
        return sum.toString(true);
    }

    @Override
    public String approximate(int from, int until) {
        return approximate(getFloatPrecision());
    }

    private Apint factorial(Apint number) {
        Apint i;
        Apint fact = Apint.ONE;
        for (i = Apint.ONE; i.compareTo(number) <= 0; i = i.add(Apint.ONE)) {
            fact = fact.multiply(i);
        }
        return fact;
    }

    private Apfloat generateSum(int from, int until) {
        Apfloat sum = Apfloat.ZERO;

        Apint dividend, divisor;

        for (int i = from; i < until; i++) {
            dividend = factorial(new Apint(i)
                    .multiply(new Apint(6)))
                    .multiply(new Apint(13591409)
                            .add(new Apint(545140134)
                                    .multiply(new Apint(i))));

            divisor =
                    factorial(new Apint(3).multiply(new Apint(i)))
                            .multiply(ApintMath.pow(factorial(new Apint(i)), 3))
                            .multiply(ApintMath.pow(new Apint("-262537412640768000"), i))
            ;

            sum = sum.add(new Apfloat(dividend.toString(), floatPrecision)
                    .divide(new Apfloat(divisor.toString(), floatPrecision)));
        }

        return sum;
    }
}
