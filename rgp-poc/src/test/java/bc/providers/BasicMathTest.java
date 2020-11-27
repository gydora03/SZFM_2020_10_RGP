package bc.providers;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BasicMathTest {

    @Test
    void testAdd() {
        assertNotEquals(15, new BasicMath().add(4, 2));
        assertNotEquals(6, new BasicMath().add(2, 1));
        assertEquals(10, new BasicMath().add(5, 5));
    }

    @Test
    void testSubtract() {
        assertNotEquals(9, new BasicMath().subtract(21, 4));
        assertNotEquals(12, new BasicMath().subtract(22, 19));
        assertEquals(3, new BasicMath().subtract(8, 5));
    }

    @Test
    void testMultiply() {
        assertNotEquals(41, new BasicMath().multiply(3, 4));
        assertNotEquals(37, new BasicMath().multiply(2, 8));
        assertEquals(56, new BasicMath().multiply(7, 8));
    }

    @Test
    void testDivide() {
        assertNotEquals(10, new BasicMath().divide(8, 4));
        assertNotEquals(3, new BasicMath().divide(25, 5));
        assertEquals(4, new BasicMath().divide(28, 7));
    }

    @Test
    void testMod() {
    }
}