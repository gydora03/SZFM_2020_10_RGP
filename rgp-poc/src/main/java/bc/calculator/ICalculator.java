package bc.calculator;

import bc.providers.Calculation;

public interface ICalculator<T> {
    T evaluate(Calculation calculation);
}
