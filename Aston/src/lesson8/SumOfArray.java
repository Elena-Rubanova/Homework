package lesson8;

import java.util.Arrays;

public class SumOfArray {
    public static int I_LENGTH = 4;
    public static int J_LENGTH = 4;

    public static class MyArraySizeException extends Exception {
        public MyArraySizeException(String[][] arr) {
            super("Массив " + Arrays.deepToString(arr) + " неверного размера. Ожидаемый массив размером " + I_LENGTH + "x" + J_LENGTH);
        }
    }

    public static class MyArrayDataException extends Exception {
        public MyArrayDataException(String[][] arr, int i, int j) {
            super("Массив " + Arrays.deepToString(arr) + " содержит неверный элемент. Преобразование не удалось. " +
                    "Ошибка в ячейке [" + i + "][" + j + "]");
        }
    }

    public static void print(String[][] arr) throws Exception {
        if (arr.length != I_LENGTH) {
            throw new MyArraySizeException(arr);
        }

        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i].length != J_LENGTH) {
                throw new MyArraySizeException(arr);
            }

            for (int j = 0; j < arr[i].length; j++) {
                try {
                    sum = sum + Integer.parseInt(arr[i][j]);
                } catch (NumberFormatException e) {
                    throw new MyArrayDataException(arr, i, j);
                }
            }
        }

        System.out.println("Массив " + Arrays.deepToString(arr) + " верный. Сумма элементов  = " + sum);
    }
}

