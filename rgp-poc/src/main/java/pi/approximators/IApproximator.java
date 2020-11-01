package pi.approximators;

public interface IApproximator {
    String approximate(int precision);
    String approximate(int precision, int from, int until);
}
