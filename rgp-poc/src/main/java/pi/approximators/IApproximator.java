package pi.approximators;

public interface IApproximator {
    String approximate(int precision);
    String approximate(int from, int until);

    default int getFloatPrecision() {
        return 64;
    }
}
