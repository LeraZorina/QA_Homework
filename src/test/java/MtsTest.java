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

    @DisplayName("Проверить название блока онлайн пополнения")
    @Test
    void blockNameTest() {
        String blockName = driver.findElement(By.xpath("//*[@class='pay__wrapper']//h2")).getText();
        String expName = "Онлайн пополнение\n" +
                "без комиссии";
        assertEquals(expName, blockName);
    }

    @DisplayName("Проверить наличие логотипов платёжных систем")
    @Test
    void availabilityLogoTest() {
        List<WebElement> logoSystems = driver.findElements(By.xpath("//*[@class='pay__partners']//img[contains(@alt,'Visa')]"));
        logoSystems.addAll(driver.findElements(By.xpath("//*[@class='pay__partners']//img[contains(@alt,'MasterCard')]")));
        logoSystems.add(driver.findElement(By.xpath("//*[@class='pay__partners']//img[contains(@alt,'Белкарт')]")));
        assertEquals(5, logoSystems.size());
    }

    @DisplayName("Проверить работу ссылки «Подробнее о сервисе»")
    @Test
    void linkTest() {
        driver.findElement(By.xpath("//*[@class='pay__wrapper']//a[text()='Подробнее о сервисе']")).click();
        String expLink = "https://www.mts.by/help/poryadok-oplaty-i-bezopasnost-internet-platezhey/";
        String actLink = driver.getCurrentUrl();
        assertEquals(expLink, actLink);
        driver.switchTo().defaultContent();
    }

    @DisplayName("Проверить работу кнопки «Продолжить» после заполнения полей")
    @Test
    void onlineReplenishmentTest() {
        WebElement connectionPhone = driver.findElement(By.id("connection-phone"));
        WebElement connectionSum = driver.findElement(By.id("connection-sum"));
        connectionPhone.click();
        connectionPhone.sendKeys("297777777");
        connectionSum.click();
        connectionSum.sendKeys("20");
        driver.findElement(By.xpath("//*[@id='pay-connection']/button")).click();
        WebElement frame = driver.findElement(By.xpath("//iframe[@class='bepaid-iframe']"));
        String link = frame.getAttribute("src");
        assertEquals("https://checkout.bepaid.by/widget_v2/index.html", link);
        driver.get(mainUrl);
    }

    @AfterAll
    static void tearDown() {
        driver.quit();
    }
}
