package ac.providers;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AdvancedMathTest {

    @Test
    void testAdd() {
        assertNotEquals(5, new AdvancedMath().add(1,2));
        assertNotEquals(20, new AdvancedMath().add(5,6));
        assertEquals(2, new AdvancedMath().add(1,1));
    }

    @Test
    void testSubtract() {
        assertNotEquals(5, new AdvancedMath().subtract(3,2));
        assertNotEquals(20, new AdvancedMath().subtract(32,17));
        assertEquals(1, new AdvancedMath().subtract(5,4));
    }

    @Test
    void testMultiply() {
        assertNotEquals(5, new AdvancedMath().multiply(3,2));
        assertNotEquals(87, new AdvancedMath().multiply(10,10));
        assertEquals(25, new AdvancedMath().multiply(5,5));
    }

    @Test
    void testDivide() {
        assertNotEquals(5, new AdvancedMath().divide(3,2));
        assertNotEquals(3, new AdvancedMath().divide(6,3));
        assertEquals(1, new AdvancedMath().divide(5,5));
    }

    @Test
    void testSin() {
        assertNotEquals(5, new AdvancedMath().sin(9));
        assertNotEquals(2, new AdvancedMath().sin(10));
        assertEquals(0.0175, new AdvancedMath().sin(1), 0.3);
    }

    @Test
    void testCos() {
        assertNotEquals(6, new AdvancedMath().cos(2));
        assertNotEquals(23, new AdvancedMath().cos(4));
        assertEquals(0.99985, new AdvancedMath().cos(1), 0.3);
    }

    @Test
    void testTan() {
        assertNotEquals(7, new AdvancedMath().tan(2.4));
        assertNotEquals(8, new AdvancedMath().tan(6.5));
        assertEquals(0.026, new AdvancedMath().tan(1.5), 0.3);
    }

    @Test
    void testCtg() {
        assertNotEquals(9, new AdvancedMath().ctg(4.7));
        assertNotEquals(6, new AdvancedMath().ctg(3.3));
        assertEquals(38.188, new AdvancedMath().ctg(1.5), 0.3);
    }

    @Test
    void testMod() {
        assertNotEquals(2, new AdvancedMath().mod(8, 2));
        assertNotEquals(7, new AdvancedMath().mod(9, 6));
        assertEquals(4, new AdvancedMath().mod(24, 5));
    }

    @Test
    void testPower() {
        assertNotEquals(5, new AdvancedMath().power(3, 2));
        assertNotEquals(34, new AdvancedMath().power(6, 7));
        assertEquals(625, new AdvancedMath().power(5, 4));
    }

    @Test
    void testSqrt() {
        assertNotEquals(5, new AdvancedMath().sqrt(9));
        assertNotEquals(10, new AdvancedMath().sqrt(81));
        assertEquals(4, new AdvancedMath().sqrt(16));
    }

    @Test
    void testFactorial() {
        assertNotEquals(100, new AdvancedMath().factorial(9));
        assertNotEquals(32, new AdvancedMath().factorial(2));
        assertEquals(6, new AdvancedMath().factorial(3));
    }

    @Test
    void testGcd() {
        assertNotEquals(5, new AdvancedMath().gcd(15,9));
        assertNotEquals(2, new AdvancedMath().gcd(20,10));
        assertEquals(3, new AdvancedMath().gcd(6,9));
    }

    @Test
    void testLcm() {
        assertNotEquals(22, new AdvancedMath().lcm(3,6));
        assertNotEquals(30, new AdvancedMath().lcm(10,21));
        assertEquals(4, new AdvancedMath().lcm(2,4));
    }
}