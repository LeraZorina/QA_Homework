import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.math.BigInteger;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertThrows;

public class TestFactorial {
    Factorial factorial;

    @BeforeClass
    void setUp() {
        factorial = new Factorial();
    }

    @Test(description = "Проверка факториала для нуля")
    void testWithZero() {
        assertEquals(BigInteger.valueOf(1), factorial.CalcFactorial(0));
    }

    @Test(description = "Проверка факториала для единицы")
    void testWithOne() {
        assertEquals(BigInteger.valueOf(1), factorial.CalcFactorial(1));
    }

    @Test(description = "Проверка факториала для натурального числа больше 1")
    void testPositive() {
        BigInteger result = new BigInteger("20922789888000");
        assertEquals(result, factorial.CalcFactorial(16));
        assertEquals(BigInteger.valueOf(120), factorial.CalcFactorial(5));
    }

    @Test(description = "Проверка на ввод отрицательного значения")
    void exceptionTesting() {
        assertThrows(IllegalArgumentException.class, () -> factorial.CalcFactorial(-8));
    }
}
