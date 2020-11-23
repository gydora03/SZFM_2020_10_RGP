package ac.calculator;

import ac.providers.Calculation;

public interface ICalculator<T> {
    T evaluate(Calculation calculation);
}
