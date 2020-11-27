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
    }

    @Test
    void testMultiply() {
    }

    @Test
    void testDivide() {
    }

    @Test
    void testMod() {
    }
}