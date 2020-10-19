package calculator;

import providers.Calculation;

public interface ICalculator<T> {
    T evaluate(Calculation calculation);
}