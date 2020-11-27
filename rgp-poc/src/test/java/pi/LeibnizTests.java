package pi;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.tinylog.Logger;
import pi.approximators.LeibnizApproximator;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LeibnizTests {
    @BeforeAll
    public static void warnUser() {
        System.out.println("Running Leibniz tests");
        Logger.tag("Leibniz").warn("Running Leibniz tests");
    }
    @Test
    public void firstFewDigitsAfter500Iter() {
        LeibnizApproximator za = new LeibnizApproximator();
        var result = Double.parseDouble(za.approximate(500).substring(0,4));
        var expected = Double.parseDouble("3.14");

        assertEquals(expected,result,0.0001);
    }
}
