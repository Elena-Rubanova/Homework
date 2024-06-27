import lesson8.SumOfArray;

public class Main {
    public static void main(String[] args) {

        String[][] arr = {{"1", "2", "3", "4"}, {"5", "6", "7", "8"}, {"9", "8", "7", "6"}, {"5", "4", "3", "2"}};

        String[][][] examples = {arr};
        for (int i = 0; i < examples.length; i++) {
            try {
                SumOfArray.print(examples[i]);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }
}



