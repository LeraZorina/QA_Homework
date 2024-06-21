import java.math.BigInteger;

public class Factorial {
    public BigInteger CalcFactorial (int n) {
        if (n < 0) {
            throw new IllegalArgumentException("Нельзя вычислить факториал для отрицательного числа");
        }
        if (n == 0 || n == 1) {
            return BigInteger.valueOf(1);
        } else {
            return BigInteger.valueOf(n).multiply(CalcFactorial(n - 1));
        }
    }
}
