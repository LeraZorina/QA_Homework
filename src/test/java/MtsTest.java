import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
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

    @DisplayName("Проверка корректности отображения суммы (в том числе на кнопке), номера телефона")
    @Test
    void displayAmountAndPhoneTest() {
        switchToFrame();
        String textLabel = driver.findElement(By.xpath("//*[@class='pay-description__cost']//span[1]")).getText();
        String textButton = driver.findElement(By.xpath("//* [@class='card-page__card']//button")).getText();
        String textPhone = driver.findElement(By.xpath("//* [@class='pay-description__text']")).getText();
        assertAll(
                () -> assertEquals("20.00 BYN", textLabel),
                () -> assertEquals("Оплатить 20.00 BYN", textButton),
                () -> assertEquals("Оплата: Услуги связи Номер:375297777777", textPhone)
        );
        clearData();
    }

    @DisplayName("Проверка надписей в незаполненных полях для ввода реквизитов карты")
    @Test
    void placeHolderCardTest() {
        switchToFrame();
        String fieldCardNum = driver.findElement(By.xpath("//label[contains(@class,'ng-tns-c46-1 ng-star-inserted')]")).getText();
        String fieldValidity = driver.findElement(By.xpath("//label[contains(@class,'ng-tns-c46-4 ng-star-inserted')]")).getText();
        String fieldCvc = driver.findElement(By.xpath("//label[contains(@class,'ng-tns-c46-5 ng-star-inserted')]")).getText();
        String fieldHolderName = driver.findElement(By.xpath("//label[contains(@class,'ng-tns-c46-3 ng-star-inserted')]")).getText();
        assertAll(
                () -> assertEquals("Номер карты", fieldCardNum),
                () -> assertEquals("Срок действия", fieldValidity),
                () -> assertEquals("CVC", fieldCvc),
                () -> assertEquals("Имя держателя (как на карте)", fieldHolderName)
        );
        clearData();
    }

    @DisplayName("Проверка наличия иконок платёжных систем")
    @Test
    void paymentSystemIconsTest() {
        switchToFrame();
        List<WebElement> icons = driver.findElements(By.xpath("//*[@class='cards-brands ng-tns-c46-1']//img"));
        assertEquals(5, icons.size());
        clearData();
    }

    private void switchToFrame() {
        WebElement connectionPhone = driver.findElement(By.id("connection-phone"));
        WebElement connectionSum = driver.findElement(By.id("connection-sum"));
        connectionPhone.click();
        connectionPhone.sendKeys("297777777");
        connectionSum.click();
        connectionSum.sendKeys("20");
        driver.findElement(By.xpath("//*[@id='pay-connection']/button")).click();
        WebElement iframe = driver.findElement(By.xpath("//iframe[@class='bepaid-iframe']"));
        driver.switchTo().frame(iframe);
        WebDriverWait wait = new WebDriverWait(driver, 15);
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//*[@class='pay-description__cost']//span[1]"))));
    }

    private void clearData() {
        driver.findElement(By.xpath("//svg-icon[@class='header__close-icon']")).click();
        driver.switchTo().defaultContent();
        driver.findElement(By.id("connection-phone")).clear();
        driver.findElement(By.id("connection-sum")).clear();
    }

    @AfterAll
    static void tearDown() {
        driver.quit();
    }
}
