import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class MtsTest {
    static WebDriver driver;
    static String mainUrl = "https://www.mts.by/";

    @BeforeAll
    static void setupClass() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get(mainUrl);
    }

    @BeforeEach
    void closeCoockie() {
        try {
            driver.findElement(By.xpath("//button[@id='cookie-agree']")).click();
        } catch (Exception ignored) {
        }
    }

    @DisplayName("Проверка надписей в незаполненных полях варианта оплаты услуг: услуги связи")
    @Test
    void placeHolderComServicesTest() {
        String fieldPhone = driver.findElement(By.id("connection-phone")).getAttribute("placeholder");
        String fieldSum = driver.findElement(By.id("connection-sum")).getAttribute("placeholder");
        String fieldEmail = driver.findElement(By.id("connection-email")).getAttribute("placeholder");
        assertAll(
                () -> assertEquals("Номер телефона", fieldPhone),
                () -> assertEquals("Сумма", fieldSum),
                () -> assertEquals("E-mail для отправки чека", fieldEmail)
        );
    }

    @DisplayName("Проверка надписей в незаполненных полях варианта оплаты услуг: домашний интернет")
    @Test
    void placeHolderInternetTest() {
        String fieldPhoneSubscriber = driver.findElement(By.id("internet-phone")).getAttribute("placeholder");
        String fieldSum = driver.findElement(By.id("internet-sum")).getAttribute("placeholder");
        String fieldEmail = driver.findElement(By.id("internet-email")).getAttribute("placeholder");
        assertAll(
                () -> assertEquals("Номер абонента", fieldPhoneSubscriber),
                () -> assertEquals("Сумма", fieldSum),
                () -> assertEquals("E-mail для отправки чека", fieldEmail)
        );
    }

    @DisplayName("Проверка надписей в незаполненных полях варианта оплаты услуг: рассрочка")
    @Test
    void placeHolderInstalmentTest() {
        String fieldAccountNum = driver.findElement(By.id("score-instalment")).getAttribute("placeholder");
        String fieldSum = driver.findElement(By.id("instalment-sum")).getAttribute("placeholder");
        String fieldEmail = driver.findElement(By.id("instalment-email")).getAttribute("placeholder");
        assertAll(
                () -> assertEquals("Номер счета на 44", fieldAccountNum),
                () -> assertEquals("Сумма", fieldSum),
                () -> assertEquals("E-mail для отправки чека", fieldEmail)
        );
    }

    @DisplayName("Проверка надписей в незаполненных полях варианта оплаты услуг: задолженность")
    @Test
    void placeHolderArrearsTest() {
        String fieldScore = driver.findElement(By.id("score-arrears")).getAttribute("placeholder");
        String fieldSum = driver.findElement(By.id("arrears-sum")).getAttribute("placeholder");
        String fieldEmail = driver.findElement(By.id("arrears-email")).getAttribute("placeholder");
        assertAll(
                () -> assertEquals("Номер счета на 2073", fieldScore),
                () -> assertEquals("Сумма", fieldSum),
                () -> assertEquals("E-mail для отправки чека", fieldEmail)
        );
    }

    @AfterAll
    static void tearDown() {
        driver.quit();
    }
}
