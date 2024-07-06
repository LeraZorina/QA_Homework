package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class InternetPayComponent {
    public WebDriver driver;

    public InternetPayComponent(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    @FindBy(id = "internet-phone")
    private WebElement fieldPhoneSubscriber;
    @FindBy(id = "internet-sum")
    private WebElement fieldSum;
    @FindBy(id = "internet-email")
    private WebElement fieldEmail;

    public String getPlaceHolderPhone() {
        return fieldPhoneSubscriber.getAttribute("placeholder");
    }

    public String getPlaceHolderSum() {
        return fieldSum.getAttribute("placeholder");
    }

    public String getPlaceHolderEmail() {
        return fieldEmail.getAttribute("placeholder");
    }
}
