import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.*;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.*;

public class MtsTest {
    static WebDriver driver;
    static String mainUrl = "https://www.mts.by/";
    PaySectionPage paySectionPage;
    FramePage framePage;
    InternetPayComponent internetPayComponent;
    InstalmentComponent instalmentComponent;
    ArrearsComponent arrearsComponent;

    @BeforeEach
    void setupClass() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get(mainUrl);
        driver.findElement(By.xpath("//button[@id='cookie-agree']")).click();
        paySectionPage = new PaySectionPage(driver);
        framePage = new FramePage(driver);
        internetPayComponent = new InternetPayComponent(driver);
        instalmentComponent = new InstalmentComponent(driver);
        arrearsComponent = new ArrearsComponent(driver);
    }

    @DisplayName("Проверка надписей в незаполненных полях варианта оплаты услуг: услуги связи")
    @Test
    void placeHolderComServicesTest() {
        paySectionPage = new PaySectionPage(driver);
        assertAll(
                () -> assertEquals("Номер телефона", paySectionPage.getPlaceHolderPhone()),
                () -> assertEquals("Сумма", paySectionPage.getPlaceHolderSum()),
                () -> assertEquals("E-mail для отправки чека", paySectionPage.getPlaceHolderEmail())
        );
    }

    @DisplayName("Проверка надписей в незаполненных полях варианта оплаты услуг: домашний интернет")
    @Test
    void placeHolderInternetTest() {
        assertAll(
                () -> assertEquals("Номер абонента", internetPayComponent.getPlaceHolderPhone()),
                () -> assertEquals("Сумма", internetPayComponent.getPlaceHolderSum()),
                () -> assertEquals("E-mail для отправки чека", internetPayComponent.getPlaceHolderEmail())
        );
    }

    @DisplayName("Проверка надписей в незаполненных полях варианта оплаты услуг: рассрочка")
    @Test
    void placeHolderInstalmentTest() {
        assertAll(
                () -> assertEquals("Номер счета на 44", instalmentComponent.getPlaceHolderAccount()),
                () -> assertEquals("Сумма", instalmentComponent.getPlaceHolderSum()),
                () -> assertEquals("E-mail для отправки чека", instalmentComponent.getPlaceHolderEmail())
        );
    }

    @DisplayName("Проверка надписей в незаполненных полях варианта оплаты услуг: задолженность")
    @Test
    void placeHolderArrearsTest() {
        assertAll(
                () -> assertEquals("Номер счета на 2073", arrearsComponent.getPlaceHolderScore()),
                () -> assertEquals("Сумма", arrearsComponent.getPlaceHolderSum()),
                () -> assertEquals("E-mail для отправки чека", arrearsComponent.getPlaceHolderEmail())
        );
    }

    @DisplayName("Проверка корректности отображения суммы (в том числе на кнопке), номера телефона")
    @Test
    void displayAmountAndPhoneTest() {
        switchToFrame();
        assertAll(
                () -> assertEquals("20.00 BYN", framePage.getPayText()),
                () -> assertEquals("Оплатить 20.00 BYN", framePage.getBtnText()),
                () -> assertEquals("Оплата: Услуги связи Номер:375297777777", framePage.getPhone())
        );
    }

    @DisplayName("Проверка надписей в незаполненных полях для ввода реквизитов карты")
    @Test
    void placeHolderCardTest() {
        switchToFrame();
        assertAll(
                () -> assertEquals("Номер карты", framePage.getPlaceHolderCardName()),
                () -> assertEquals("Срок действия", framePage.getPlaceHolderValidity()),
                () -> assertEquals("CVC", framePage.getPlaceHolderCvc()),
                () -> assertEquals("Имя держателя (как на карте)", framePage.getHolderName())
        );
    }

    @DisplayName("Проверка наличия иконок платёжных систем")
    @Test
    void paymentSystemIconsTest() {
        switchToFrame();
        ArrayList<String> srcList = framePage.getSrcIcons();
        assertAll(
                () -> assertEquals(5, framePage.countIcons()),
                () -> assertTrue(srcList.contains("mastercard-system.svg")),
                () -> assertTrue(srcList.contains("visa-system.svg")),
                () -> assertTrue(srcList.contains("belkart-system.svg")),
                () -> assertTrue(srcList.contains("mir-system-ru.svg")),
                () -> assertTrue(srcList.contains("maestro-system.svg"))
        );
    }

    private void switchToFrame() {
        paySectionPage.inputPhone("297777777");
        paySectionPage.inputSum("20");
        paySectionPage.clickContinueBtn();
        framePage.switchToIframe();
    }

    @AfterEach
    void tearDown() {
        driver.quit();
    }
}
