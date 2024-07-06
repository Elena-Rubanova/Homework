
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.math.BigInteger;

import static com.aston.lesson10.Factorial.factorial;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class FactorialTest {
    @Test
    public void testFactorialZero() {
        assertEquals(BigInteger.valueOf(1), factorial(0));
    }


    @Test
    public void testFactorialOne() {
        assertEquals(BigInteger.valueOf(1), factorial(1));
    }


    @Test
    public void testFactorialFive() {
        assertEquals(BigInteger.valueOf(120), factorial(5));
    }


    @Test
    public void testFactorialOneHundred() {
        assertEquals(new BigInteger("93326215443944152681699238856266700490715968264381621468592963895217599993229915608941463976156518286253697920827223758251185210916864000000000000000000000000"),
                factorial(100));
    }


    @Test
    public void testFactorialNegative() {
        IllegalArgumentException exception = Assertions.assertThrows(IllegalArgumentException.class, () -> factorial(-1));
        assertEquals("Число должно быть положительным", exception.getMessage());
    }


}

