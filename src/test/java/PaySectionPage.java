import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PaySectionPage {
    public WebDriver driver;

    public PaySectionPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    @FindBy(id = "connection-phone")
    private WebElement fieldPhone;
    @FindBy(id = "connection-sum")
    private WebElement fieldSum;
    @FindBy(id = "connection-email")
    private WebElement fieldEmail;
    @FindBy(xpath = "//*[@id='pay-connection']/button")
    private WebElement continueBtn;

    public void inputPhone(String phone) {
        fieldPhone.click();
        fieldPhone.sendKeys(phone);
    }

    public void inputSum(String sum) {
        fieldSum.click();
        fieldSum.sendKeys(sum);
    }

    public void inputEmail(String email) {
        fieldEmail.click();
        fieldEmail.sendKeys(email);
    }

    public void clickContinueBtn() {
        continueBtn.click();
    }

    public String getPlaceHolderPhone() {
        return fieldPhone.getAttribute("placeholder");
    }

    public String getPlaceHolderSum() {
        return fieldSum.getAttribute("placeholder");
    }

    public String getPlaceHolderEmail() {
        return fieldEmail.getAttribute("placeholder");
    }
}
