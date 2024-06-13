package exceptions;

public class MyArrayDataException extends Exception {
    public MyArrayDataException(int i, int j) {
        super("В ячейке [" + i + "," + j + "] находятся неверные данные");
    }
}
