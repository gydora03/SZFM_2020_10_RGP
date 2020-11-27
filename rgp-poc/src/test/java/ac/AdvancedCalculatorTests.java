package ac;

import ac.calculator.AdvancedCalculator;
import ac.module.HistoryModule;
import ac.providers.AdvancedMath;
import ac.providers.Calculation;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class AdvancedCalculatorTests {

    @Test
    public void testEvaluate_addition() {
        AdvancedCalculator calc = new AdvancedCalculator(new AdvancedMath());
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
        AdvancedCalculator calc = new AdvancedCalculator(new AdvancedMath());
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
        AdvancedCalculator calc = new AdvancedCalculator(new AdvancedMath());
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
        AdvancedCalculator calc = new AdvancedCalculator(new AdvancedMath());
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
    public void testEvaluate_sin() {
        AdvancedCalculator calc = new AdvancedCalculator(new AdvancedMath());
        Calculation c = new Calculation();
        c.setCurrentOperator("sin");
        c.setCurrentValue(30d);
        assertEquals(0.5, calc.evaluate(c), 0.1 * 15);
    }

    @Test
    public void testEvaluate_cos() {
        AdvancedCalculator calc = new AdvancedCalculator(new AdvancedMath());
        Calculation c = new Calculation();
        c.setCurrentOperator("cos");
        c.setCurrentValue(60d);
        assertEquals(0.5, calc.evaluate(c), 0.1 * 15);
    }

    @Test
    public void testEvaluate_tan() {
        AdvancedCalculator calc = new AdvancedCalculator(new AdvancedMath());
        Calculation c = new Calculation();
        c.setCurrentOperator("tan");
        c.setCurrentValue(45d);
        assertEquals(1, calc.evaluate(c), 0.1 * 15);
    }

    @Test
    public void testEvaluate_ctg() {
        AdvancedCalculator calc = new AdvancedCalculator(new AdvancedMath());
        Calculation c = new Calculation();
        c.setCurrentOperator("ctg");
        c.setCurrentValue(45d);
        assertEquals(1, calc.evaluate(c), 0.1 * 15);
    }

    @Test
    public void testEvaluate_mod() {
        AdvancedCalculator calc = new AdvancedCalculator(new AdvancedMath());
        Calculation c = new Calculation();
        c.setCurrentOperator("mod");
        c.setCurrentValue(7.0);
        calc.evaluate(c);
        c = new Calculation();
        c.setCurrentValue(3d);
        c.setCurrentOperator("=");

        assertEquals(1.0, calc.evaluate(c), 0.1 * 15);

    }

    @Test
    public void testEvaluate_power() {
        AdvancedCalculator calc = new AdvancedCalculator(new AdvancedMath());
        Calculation c = new Calculation();
        c.setCurrentOperator("power");
        c.setCurrentValue(2.0);
        calc.evaluate(c);
        c = new Calculation();
        c.setCurrentValue(3d);
        c.setCurrentOperator("=");

        assertEquals(8.0, calc.evaluate(c), 0.1 * 15);

    }

    @Test
    public void testEvaluate_sqrt() {
        AdvancedCalculator calc = new AdvancedCalculator(new AdvancedMath());
        Calculation c = new Calculation();
        c.setCurrentOperator("sqrt");
        c.setCurrentValue(4.0);

        assertEquals(2.0, calc.evaluate(c), 0.1 * 15);
    }

    @Test
    public void testEvaluate_factorial() {
        AdvancedCalculator calc = new AdvancedCalculator(new AdvancedMath());
        Calculation c = new Calculation();
        c.setCurrentOperator("factorial");
        c.setCurrentValue(5.0);

        assertEquals(120.0, calc.evaluate(c), 0.1 * 15);

    }

    @Test
    public void testEvaluate_gcd() {
        AdvancedCalculator calc = new AdvancedCalculator(new AdvancedMath());
        Calculation c = new Calculation();
        c.setCurrentOperator("gcd");
        c.setCurrentValue(2.0);
        calc.evaluate(c);
        c = new Calculation();
        c.setCurrentValue(3d);
        c.setCurrentOperator("=");

        assertEquals(1.0, calc.evaluate(c), 0.1 * 15);

    }

    @Test
    public void testEvaluate_lcm() {
        AdvancedCalculator calc = new AdvancedCalculator(new AdvancedMath());
        Calculation c = new Calculation();
        c.setCurrentOperator("lcm");
        c.setCurrentValue(2.0);
        calc.evaluate(c);
        c = new Calculation();
        c.setCurrentValue(3d);
        c.setCurrentOperator("=");

        assertEquals(6.0, calc.evaluate(c), 0.1 * 15);

    }

    @Test
    public void testEvaluate_complexCalculation() {
        AdvancedCalculator calc = new AdvancedCalculator(new AdvancedMath());
        Calculation c = new Calculation();
        c.setCurrentOperator("lcm");
        c.setCurrentValue(2.0);
        calc.evaluate(c);
        c = new Calculation();
        c.setCurrentValue(3d);
        c.setCurrentOperator("=");
        calc.evaluate(c);

        //stored 6.0
        Calculation c2 = new Calculation();
        c2.setCurrentValue(6d);
        c2.setCurrentOperator("multiply");
        calc.evaluate(c2);
        c2 = new Calculation();
        c2.setCurrentValue(30d);
        c2.setCurrentOperator("=");
        calc.evaluate(c2);

        //stored 180
        Calculation c3 = new Calculation();
        c3.setCurrentValue(180d);
        c3.setCurrentOperator("divide");
        calc.evaluate(c3);
        c3 = new Calculation();
        c3.setCurrentValue(38d);
        c3.setCurrentOperator("=");
        calc.evaluate(c3);

        //stored 5

        Calculation c4 = new Calculation();
        c4.setCurrentOperator("factorial");
        c4.setCurrentValue(5d);

        assertEquals(120d, calc.evaluate(c4));


    }

    @Test
    public void testModuleRegistration() {
        AdvancedCalculator calc = new AdvancedCalculator(new AdvancedMath());
        calc.registerModule("history", HistoryModule.getInstance());
        assertEquals(HistoryModule.getInstance(), calc.<HistoryModule>getModule("history"));
    }

    @Test
    public void testUpdateOperator() {
        AdvancedCalculator calc = new AdvancedCalculator(new AdvancedMath());
        Calculation c = new Calculation();
        c.setCurrentValue(5d);
        c.setCurrentOperator("multiply");

        double r = calc.evaluate(c);

        Calculation c2 = new Calculation();
        c2.setCurrentValue(2d);
        c2.setCurrentOperator("power");
        calc.updateOperator(c2.getCurrentOperator());
        r = calc.evaluate(c2);

        assertEquals(25d, r);
        assertNotEquals(10d, r);

    }
}
