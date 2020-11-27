package ac.providers;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AdvancedMathTest {

    @Test
    void testAdd() {
    }

    @Test
    void testSubtract() {
    }

    @Test
    void testMultiply() {
    }

    @Test
    void testDivide() {
    }

    @Test
    void testSin() {
        assertNotEquals(5, new AdvancedMath().sin(9));
        assertNotEquals(2, new AdvancedMath().sin(10));
        assertEquals(0.0175, new AdvancedMath().sin(1), 0.3);
    }

    @Test
    void testCos() {
    }

    @Test
    void testTan() {
    }

    @Test
    void testCtg() {
    }

    @Test
    void testMod() {
    }

    @Test
    void testPower() {
        assertNotEquals(5, new AdvancedMath().power(3, 2));
        assertNotEquals(34, new AdvancedMath().power(6, 7));
        assertEquals(625, new AdvancedMath().power(5, 4));
    }

    @Test
    void testSqrt() {
    }

    @Test
    void testFactorial() {
    }

    @Test
    void testGcd() {
    }

    @Test
    void testLcm() {
    }
}