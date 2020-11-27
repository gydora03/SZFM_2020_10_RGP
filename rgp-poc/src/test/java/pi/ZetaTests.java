package pi;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.tinylog.Logger;
import pi.approximators.ZetaApproximator;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ZetaTests {
    @BeforeAll
    public static void warnUser() {
        System.out.println("Running Zeta tests");
        Logger.tag("Zeta").warn("Running Zeta tests");
    }
    @Test
    public void firstFewDigitsAfter1000Iter() {
        ZetaApproximator za = new ZetaApproximator();
        var result = Double.parseDouble(za.approximate(1000).substring(0,4));
        var expected = Double.parseDouble("3.14");

        assertEquals(expected,result,0.001);
    }
}
