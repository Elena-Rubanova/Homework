package lesson5;

public class Lesson5 {
    public static void printThreeWords() {   // задание 1
        System.out.println("Orange");
        System.out.println("Banana");
        System.out.println("Apple");
    }

    public static void checkSumSign() {      // задание 2
        int a = 12;
        int b = 15;
        int sum = a + b;
        if (sum >= 0) {
            System.out.println("Сумма положительная");
        } else {
            System.out.println("Сумма отрицательная");
        }
    }

    public static void printColor() {        // задание 3
        int value = 32;
        if (value <= 0) {
            System.out.println("Красный");
        } else if (value > 0 && value < 100) {
            System.out.println("Желтый");
        } else {
            System.out.println("Зеленый");
        }
    }

    public static void compareNumbers() {    // задание 4
        int a = 20;
        int b = 40;
        if (a >= b) {
            System.out.println("a >= b");
        }
        if (a < b) {
            System.out.println("a < b");
        }
    }
}

