package pi.approximators;

import org.apfloat.Apfloat;
import org.apfloat.ApfloatMath;

import java.util.ArrayList;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class LeibnizApproximator implements IApproximator {

    private int floatPrecision;
    private ExecutorService execService;

    @Override
    public String approximate(int precision) {

        floatPrecision = StrictMath.max(precision, getFloatPrecision());
        Apfloat pi = Apfloat.ZERO;
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
            for (int i = 0; i < listOfSums.size(); i++) {
                pi = pi.add(listOfSums.get(i).get());
            }
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }

        pi = pi.multiply(new Apfloat("4", floatPrecision));
        return pi.toString(true);

    }

    @Override
    public String approximate(int from, int until) {
        return approximate(getFloatPrecision());
    }

    private Apfloat generateSum(int from, int until) {

        Apfloat sum = new Apfloat(0, floatPrecision);

        for (int i = from; i < until; i++) {
            var s =
                    new Apfloat("1", floatPrecision)
                    .divide(Apfloat.ONE
                            .add(new Apfloat("2", floatPrecision)
                                    .multiply(new Apfloat(i, floatPrecision))));
            sum = i % 2 == 0 ? sum.add(s) : sum.subtract(s);
        }

        return sum;
    }
}
