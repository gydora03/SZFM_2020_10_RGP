package cv.converters;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class VolumeConverterControllerTest {

    @Test
    void testconvertUnitToMeter() {
        assertNotEquals(100, new VolumeConverterController().convertUnitToLiter("milliliter", 10));
        assertNotEquals(1000, new VolumeConverterController().convertUnitToLiter("centiliter", 100));
        assertEquals(1, new VolumeConverterController().convertUnitToLiter("deciliter", 10));
    }

    @Test
    void testConvertToTargetUnit() {
        assertNotEquals(1, new VolumeConverterController().convertToTargetUnit("milliliter", 10));
        assertNotEquals(1000, new VolumeConverterController().convertToTargetUnit("centiliter", 100));
        assertEquals(10, new VolumeConverterController().convertToTargetUnit("deciliter", 1));
    }
}