package cv.converters;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TemperatureConverterControllerTest {

    @Test
    void testConvertUnitToCelsius() {
        assertNotEquals(20, new TemperatureConverterController().convertUnitToCelsius("kelvin", 70));
        assertNotEquals(34, new TemperatureConverterController().convertUnitToCelsius("fahrenheit", 6));
        assertEquals(10, new TemperatureConverterController().convertUnitToCelsius("fahrenheit", 50));
    }

    @Test
    void testConvertToTargetUnit() {
        assertNotEquals(6, new TemperatureConverterController().convertToTargetUnit("kelvin", 56));
        assertNotEquals(150, new TemperatureConverterController().convertToTargetUnit("fahrenheit", 73));
        assertEquals(303.15, new TemperatureConverterController().convertToTargetUnit("kelvin", 30));
    }
}