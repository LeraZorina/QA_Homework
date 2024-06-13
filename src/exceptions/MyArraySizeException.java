package exceptions;

public class MyArraySizeException extends Exception {
    public MyArraySizeException() {
        super("Размер массива должен быть 4 x 4");
    }
}
