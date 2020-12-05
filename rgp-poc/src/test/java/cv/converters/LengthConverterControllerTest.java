package cv.converters;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LengthConverterControllerTest {

    @Test
    void testconvertUnitToMeter() {
        assertNotEquals(1, new LengthConverterController().convertUnitToMeter("millimeter", 100));
        assertNotEquals(10, new LengthConverterController().convertUnitToMeter("centimeter", 10));
        assertEquals(1000, new LengthConverterController().convertUnitToMeter("kilometer", 1));
    }

    @Test
    void testConvertToTargetUnit() {
        assertNotEquals(1, new LengthConverterController().convertToTargetUnit("millimeter", 10));
        assertNotEquals(1000, new LengthConverterController().convertToTargetUnit("centimeter", 100));
        assertEquals(1, new LengthConverterController().convertToTargetUnit("kilometer", 1000));
    }
}