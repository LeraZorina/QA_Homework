import exceptions.MyArrayDataException;
import exceptions.MyArraySizeException;

public class Main {
    public static void main(String[] args) {
        int sum;
        String[][] array = new String[][]{{"1", "2", "3", "4"}, {"5", "6", "7", "8"}, {"9", "10", "11", "12"}, {"13", "14", "15", "16"}};
        try {
            sum = sumArray(array);
            System.out.println("Сумма всех элементов массива: " + sum);
        } catch (MyArraySizeException | MyArrayDataException e) {
            System.out.println(e.getMessage());
        }
    }

    public static int sumArray(String[][] array) throws MyArraySizeException, MyArrayDataException {
        if (array.length != 4 || array[0].length != 4) {
            throw new MyArraySizeException();
        }
        int sumElements = 0;
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[0].length; j++) {
                try {
                    sumElements += Integer.parseInt(array[i][j]);
                } catch (NumberFormatException ex) {
                    throw new MyArrayDataException(i, j);
                }
            }
        }
        return sumElements;
    }
}