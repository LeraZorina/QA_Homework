import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.math.BigInteger;

import static org.junit.jupiter.api.Assertions.*;

public class TestFactorial {
    @DisplayName("Факториал для нуля")
    @Test
    void testWithZero() {
        assertEquals(BigInteger.valueOf(1), Factorial.calcFactorial(0));
    }

    @DisplayName("Факториал для единицы")
    @Test
    void testWithOne() {
        assertEquals(BigInteger.valueOf(1), Factorial.calcFactorial(1));
    }

    @DisplayName("Проверка факториала для натурального числа больше 1")
    @Test
    void testPositive() {
        BigInteger result = new BigInteger("20922789888000");
        assertAll(
                () -> assertEquals(result, Factorial.calcFactorial(16)),
                () -> assertEquals(BigInteger.valueOf(120), Factorial.calcFactorial(5)),
                () -> assertEquals(BigInteger.valueOf(40320), Factorial.calcFactorial(8))
        );
    }

    @DisplayName("Проверка на исключение при вводе отрицательного значения")
    @Test
    void exceptionTesting() {
        assertThrows(IllegalArgumentException.class, () -> Factorial.calcFactorial(-8));
    }
}
