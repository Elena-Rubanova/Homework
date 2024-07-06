package by.aston.lesson10.testNG;

import java.math.BigInteger;

public class Factorial {
    public static BigInteger factorial(int number) {
        if (number < 0) throw new IllegalArgumentException("Число должно быть положительным");

        else if (number <= 1) {
            return BigInteger.valueOf(1);
        } else {
            return BigInteger.valueOf(number).multiply(factorial(number - 1));
        }
    }
}
