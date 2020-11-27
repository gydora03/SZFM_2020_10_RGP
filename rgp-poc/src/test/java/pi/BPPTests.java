package pi;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.tinylog.Logger;
import pi.approximators.BPP;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BPPTests {

    @BeforeAll
    public static void warnUser() {
        System.out.println("RUNNING BPP TESTS! THESE MAY TAKE A WHILE, BE PATIENT!");
        Logger.tag("BPP").warn("RUNNING BPP TESTS! THESE MAY TAKE A WHILE, BE PATIENT!");
    }
    @Test
    public void is1mDigitCorrect() {
        BPP bpp = new BPP();
        var result = bpp.approximate(999999,1000000);
        assertEquals("2",result);
    }
    @Test
    public void is1mSeqTo14Correct() {
        BPP bpp = new BPP();
        var result = bpp.approximate(999999,1000013);
        assertEquals("26C65E52CB4593",result);
    }
    @Test
    public void isBeginningSeqTo11Correct() {
        BPP bpp = new BPP();
        var result = bpp.approximate(0,11);
        assertEquals("243F6A8885A",result);
    }
}
