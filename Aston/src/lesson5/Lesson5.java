package lesson5;

public class Lesson5 {
    // задание 1
    public static void printThreeWords() {
        System.out.println("Orange");
        System.out.println("Banana");
        System.out.println("Apple");
    }

    // задание 2
    public static void checkSumSign() {
        int a = 12;
        int b = 15;
        int sum = a + b;
        if (sum >= 0) {
            System.out.println("Сумма положительная");
        } else {
            System.out.println("Сумма отрицательная");
        }
    }

    // задание 3
    public static void printColor() {
        int value = 32;
        if (value <= 0) {
            System.out.println("Красный");
        } else if (value > 0 && value < 100) {
            System.out.println("Желтый");
        } else {
            System.out.println("Зеленый");
        }
    }

    // задание 4
    public static void compareNumbers() {
        int a = 20;
        int b = 40;
        if (a >= b) {
            System.out.println("a >= b");
        }
        if (a < b) {
            System.out.println("a < b");
        }
    }

    // задание 5
    public static boolean sum(int a, int b) {
        if (10 <= a + b && a + b <= 20) {
            return true;
        } else {
            return false;
        }
    }

    // задание 6
    public static void number(int a) {
        if (a >= 0) {
            System.out.println("Положительное число");
        } else {
            System.out.println("Отрицательное число");
        }
    }

    // задание 7
    public static boolean wholeNumber(int a) {
        if (a < 0) {
            return true;
        } else {
            return false;
        }
    }

    // задание 8
    public static void stroka(String message, int b) {
        for (int k = 0; k < b; k++) {
            System.out.println(message);
        }
    }

    // задание 9
    public static boolean leapYear(int year) {
        if (year % 100 != 0 && year % 4 == 0) {
            return true;
        } else if (year % 400 == 0) {
            return true;
        } else {
            return false;
        }
    }

}

