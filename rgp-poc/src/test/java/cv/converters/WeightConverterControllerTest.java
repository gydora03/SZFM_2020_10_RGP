package cv.converters;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class WeightConverterControllerTest {

    @Test
    void testConvertUnitToGram() {
        assertNotEquals(20, new WeightConverterController().convertUnitToGram("decagram", 685));
        assertNotEquals(34, new WeightConverterController().convertUnitToGram("pounds", 6));
        assertEquals(0.05, new WeightConverterController().convertUnitToGram("milligram", 50));
    }

    @Test
    void testConvertToTargetUnit() {
    }
}