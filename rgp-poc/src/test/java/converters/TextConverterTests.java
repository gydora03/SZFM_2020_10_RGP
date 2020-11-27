package converters;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.tinylog.Logger;
import t2.Translator;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TextConverterTests {

    private final String FP = "FATHER PICARD";
    private final String FP_MORSE = ".._. ._ _ .... . ._. | .__. .. _._. ._ ._. _..";
    private final String FP_BINARY = "1000110 1000001 1010100 1001000 1000101 1010010 | 1010000 1001001 1000011 1000001 1010010 1000100";

    @BeforeAll
    public static void warnUser() {
        System.out.println("Running TextConverter tests");
        Logger.tag("TextConverter").warn("Running TextConverter tests");
    }
    @Test
    public void text2Morse() {
        assertEquals(FP_MORSE, Translator.translateTextToMorse(FP));
    }
    @Test
    public void morse2Text() {
        assertEquals(FP, Translator.translateMorseToText(FP_MORSE));
    }
    @Test
    public void text2binary() {
        assertEquals(FP_BINARY, Translator.translateTextToBinary(FP));
    }
    @Test
    public void binary2text() {
        assertEquals(FP, Translator.translateBinaryToText(FP_BINARY));
    }
    @Test
    public void binary2Morse() {
        var intermediate = Translator.translateBinaryToText(FP_BINARY);
        var result = Translator.translateTextToMorse(intermediate);
        assertEquals(FP_MORSE, result);
    }
    @Test
    public void morse2Binary() {
        var intermediate = Translator.translateMorseToText(FP_MORSE);
        var result = Translator.translateTextToBinary(intermediate);
        assertEquals(FP_BINARY, result);
    }

}
