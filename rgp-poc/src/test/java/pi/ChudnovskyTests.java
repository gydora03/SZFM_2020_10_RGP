package pi;


import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.tinylog.Logger;
import pi.approximators.ChudnovskyApproximator;


import static org.junit.jupiter.api.Assertions.assertEquals;

public class ChudnovskyTests {

    @BeforeAll
    public static void warnUser() {
        System.out.println("Running Chudnovsky tests");
        Logger.tag("Chudnovsky").warn("Running Chudnovsky tests");
    }

    @Test
    public void testChudOneIter() {
        ChudnovskyApproximator ca = new ChudnovskyApproximator();
        var result = Double.parseDouble(ca.approximate(1));
        var expected = Double.parseDouble("3.1415926535897");
        assertEquals(result, expected,0.0000001);
    }
    @Test
    public void testChud100Iter() {
        ChudnovskyApproximator ca = new ChudnovskyApproximator();
        var result = Double.parseDouble(ca.approximate(100));
        var expected = Double.parseDouble("3.14159265358979323846264338327950288419716939937510");
        assertEquals(expected,result,0.0000001);
    }
}
