package by.aston.lesson10.testNG;

import org.testng.annotations.Test;

import java.math.BigInteger;

import static by.aston.lesson10.testNG.Factorial.factorial;
import static org.testng.Assert.assertEquals;

public class FactorialTest {

    @Test
    void testFactorialNull() {
        assertEquals(factorial(0), BigInteger.valueOf(1));
    }

    @Test
    void testFactorialOne() {
        assertEquals(factorial(1), BigInteger.valueOf(1));
    }

    @Test
    void testFactorialCalculation() {
        assertEquals(factorial(2), BigInteger.valueOf(2));
        assertEquals(factorial(3), BigInteger.valueOf(6));
        assertEquals(factorial(4), BigInteger.valueOf(24));
    }

    @Test
    void testFactorialTen() {
        assertEquals(factorial(10), BigInteger.valueOf(3628800));
    }

    @Test
    void testFactorialOneHundred() {
        assertEquals(new BigInteger("93326215443944152681699238856266700490715968264381621468592963895217599993229915608941463976156518286253697920827223758251185210916864000000000000000000000000"),
                factorial(100));
    }

    @Test(expectedExceptions = IllegalArgumentException.class)
    void testFactorialNegative() {
        factorial(-5);
    }
}