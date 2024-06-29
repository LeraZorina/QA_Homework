import java.math.BigInteger;

public class Factorial {
    public static BigInteger calcFactorial(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("Нельзя вычислить факториал для отрицательного числа");
        }
        if (n == 0 || n == 1) {
            return BigInteger.valueOf(1);
        }
        return BigInteger.valueOf(n).multiply(calcFactorial(n - 1));
    }
}
