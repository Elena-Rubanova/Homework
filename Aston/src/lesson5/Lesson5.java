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
        int a = -40;
        int b = 40;
        if (a >= b) {
            System.out.println("a >= b");
        } else {
            System.out.println("a < b");
        }
    }

    // задание 5
    public static boolean sum(int a, int b) {
        return (a + b) >= 10 && (a + b) <= 20;
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
    public static void wholeNumber(int a) {
        boolean b = (a < 0);
        System.out.println(b);
    }

    // задание 8
    public static void stroka(String message, int b) {
        for (int i = 0; i < b; i++) {
            System.out.println(message);
        }
    }

    // задание 9
    public static boolean leapYear(int year) {
        if ((year % 100 != 0 && year % 4 == 0) || (year % 400 == 0)) {
            return true;
        } else {
            return false;
        }
    }

    // задание 10
    public static void array() {
        int[] arr = {1, 1, 0, 0, 1, 0, 1, 1, 0, 1};
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 1) {
                arr[i] = 0;
            } else if (arr[i] == 0) {
                arr[i] = 1;
            }
            {
                System.out.print(arr[i] + " ");
            }
        }
        System.out.println();
    }

    // Заданаие 11
    public static void array2() {
        int counter = 1;
        int[] arr2 = new int[100];
        for (int i = 0; i < arr2.length; i++) {
            arr2[i] = counter;
            System.out.print(arr2[i] + " ");
            counter++;
        }
        System.out.println();
    }

    // задание 12
    public static void array3() {
        int[] arr3 = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        for (int i = 0; i < arr3.length; i++) {
            if (arr3[i] < 6)
                arr3[i] *= 2;
            System.out.print(arr3[i] + " ");
        }
        System.out.println();
    }

    // задание 13
    public static void array4() {
        int n = 5;
        int[][] arr4 = new int[n][n];
        for (int i = 0; i < arr4.length; i++) {
            arr4[i][i] = 1;
            arr4[i][arr4.length - i - 1] = 1;
        }
        for (int i = 0; i < arr4.length; i++) {
            for (int j = 0; j < arr4.length; j++) {
                System.out.print(arr4[i][j] + " ");
            }
            System.out.println();
        }
    }

    // задание 14
    public static void arrayArgument(int len, int initialValue) {
        int[] arr5 = new int[len];
        for (int i = 0; i < len; i++) {
            arr5[i] = initialValue;
            System.out.print("[" + i + "]" + arr5[i] + " ");
        }
    }
}








