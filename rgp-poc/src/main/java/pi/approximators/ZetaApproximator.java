package pi.approximators;

import org.apfloat.Apfloat;
import org.apfloat.ApfloatMath;

import java.util.ArrayList;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ZetaApproximator implements IApproximator{

    private int floatPrecision;
    private ExecutorService execService;

    @Override
    public String approximate(int precision) {
        Apfloat sum = Apfloat.ZERO;
        floatPrecision = getFloatPrecision();

        int threadCount = Runtime.getRuntime().availableProcessors();
        execService = Executors.newFixedThreadPool(threadCount);
        int threshold = precision / threadCount;
        var listOfCallables = new ArrayList<Callable<Apfloat>>();

        for (int i = 0; i < threadCount - 1; i++) {
            final int solution = i == 0 ? 1 : threshold * i;
            final int limit = threshold * (i + 1);
            listOfCallables.add(() -> generateSum(solution, limit));
        }
        listOfCallables.add(() -> generateSum(threshold * threadCount, precision));

        try {
            var listOfSums = execService.invokeAll(listOfCallables);
            for (int i = 0; i < listOfSums.size(); i++) {
                sum = sum.add(listOfSums.get(i).get());
            }
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }

        sum = ApfloatMath.sqrt(sum.multiply(new Apfloat(6,floatPrecision)));
        return sum.toString(true);
    }

    @Override
    public String approximate(int from, int until) {
        return approximate(getFloatPrecision());
    }

    private Apfloat generateSum(int from, int until) {
        Apfloat sum = Apfloat.ZERO;
        for(int i = from; i < until; i++) {
            sum = sum.add(Apfloat.ONE.
                    divide(ApfloatMath
                            .pow(new Apfloat(i,floatPrecision),
                                    new Apfloat(2, floatPrecision))));
        }

        return sum;
    }
}
