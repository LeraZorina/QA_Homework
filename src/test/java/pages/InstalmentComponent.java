package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class InstalmentComponent {
    public WebDriver driver;

    public InstalmentComponent(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    @FindBy(id = "score-instalment")
    private WebElement fieldAccountNum;
    @FindBy(id = "instalment-sum")
    private WebElement fieldSum;
    @FindBy(id = "instalment-email")
    private WebElement fieldEmail;

    public String getPlaceHolderAccount() {
        return fieldAccountNum.getAttribute("placeholder");
    }

    public String getPlaceHolderSum() {
        return fieldSum.getAttribute("placeholder");
    }

    public String getPlaceHolderEmail() {
        return fieldEmail.getAttribute("placeholder");
    }
}
