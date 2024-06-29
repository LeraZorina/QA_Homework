import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
import java.util.concurrent.TimeUnit;

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
    void blockNameTest() {
        String blockName = driver.findElement(By.xpath("//*[@class='pay__wrapper']//h2")).getText();
        String expName = "Онлайн пополнение\n" +
                "без комиссии";
        assertEquals(expName, blockName);
    }

    @AfterAll
    static void tearDown() {
        driver.quit();
    }
}
