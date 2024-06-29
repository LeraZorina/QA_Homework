import org.testng.annotations.Test;

import java.math.BigInteger;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertThrows;

public class TestFactorial {


    @Test(description = "Проверка факториала для нуля")
    void testWithZero() {
        assertEquals(Factorial.calcFactorial(0), BigInteger.valueOf(1));
    }

    @Test(description = "Проверка факториала для единицы")
    void testWithOne() {
        assertEquals(Factorial.calcFactorial(1), BigInteger.valueOf(1));
    }

    @Test(description = "Проверка факториала для натурального числа больше 1")
    void testPositive() {
        BigInteger result = new BigInteger("20922789888000");
        assertEquals(Factorial.calcFactorial(16), result);
        assertEquals(Factorial.calcFactorial(5), BigInteger.valueOf(120));
    }

    @Test(description = "Проверка на ввод отрицательного значения")
    void exceptionTesting() {
        assertThrows(IllegalArgumentException.class, () -> Factorial.calcFactorial(-8));
    }
}
