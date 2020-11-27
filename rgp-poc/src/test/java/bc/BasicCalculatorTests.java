package bc;

import bc.calculator.BasicCalculator;
import bc.providers.BasicMath;
import bc.providers.Calculation;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BasicCalculatorTests {

    @Test
    public void testEvaluate_addition() {
        BasicCalculator calc = new BasicCalculator(new BasicMath());
        Calculation c = new Calculation();
        c.setCurrentOperator("add");
        c.setCurrentValue(660.0);
        calc.evaluate(c);
        c = new Calculation();
        c.setCurrentValue(6.0);
        c.setCurrentOperator("=");

        assertEquals(666.0, calc.evaluate(c));

    }

    @Test
    public void testEvaluate_subtract() {
        BasicCalculator calc = new BasicCalculator(new BasicMath());
        Calculation c = new Calculation();
        c.setCurrentOperator("subtract");
        c.setCurrentValue(667.0);
        calc.evaluate(c);
        c = new Calculation();
        c.setCurrentValue(1.0);
        c.setCurrentOperator("=");

        assertEquals(666.0, calc.evaluate(c));
    }

    @Test
    public void testEvaluate_multiply() {
        BasicCalculator calc = new BasicCalculator(new BasicMath());
        Calculation c = new Calculation();
        c.setCurrentOperator("multiply");
        c.setCurrentValue(333.0);
        calc.evaluate(c);
        c = new Calculation();
        c.setCurrentValue(2.0);
        c.setCurrentOperator("=");

        assertEquals(666.0, calc.evaluate(c));
    }

    @Test
    public void testEvaluate_divide() {
        BasicCalculator calc = new BasicCalculator(new BasicMath());
        Calculation c = new Calculation();
        c.setCurrentOperator("divide");
        c.setCurrentValue(333.0);
        calc.evaluate(c);
        c = new Calculation();
        c.setCurrentValue(0.5);
        c.setCurrentOperator("=");

        assertEquals(666.0, calc.evaluate(c));

    }

    @Test
    public void testEvaluate_mod() {
        BasicCalculator calc = new BasicCalculator(new BasicMath());
        Calculation c = new Calculation();
        c.setCurrentOperator("mod");
        c.setCurrentValue(7.0);
        calc.evaluate(c);
        c = new Calculation();
        c.setCurrentValue(3d);
        c.setCurrentOperator("=");

        assertEquals(1.0, calc.evaluate(c), 0.1 * 15);

    }
}
