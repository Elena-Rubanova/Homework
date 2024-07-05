package org.example.test;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {

    @Test
    void sum() {
        Calculator calculator = new Calculator();
        int result = calculator.sum(100, 400);
        assertEquals(500, result);

    }

    @Test
    void sumNotEquals() {
        Calculator calculator = new Calculator();
        int result = calculator.sum(100, 400);
        assertNotEquals(100, result);

    }


    @Test
    void divide() {
        Calculator calculator =new Calculator();

        assertThrows(ArithmeticException.class, () -> {
            calculator.divide(7,0);
        });
    }

    @Test
    void divideNullPointerException() {
        Calculator calculator =new Calculator();

        assertThrows(NullPointerException.class, () -> {
            calculator.divide(7,0);
        });
    }
}