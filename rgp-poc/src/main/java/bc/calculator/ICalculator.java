package bc.calculator;

public interface ICalculator<T> {
    T evaluate(Calculation calculation);
}
