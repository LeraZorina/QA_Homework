package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ArrearsComponent {
    public WebDriver driver;

    public ArrearsComponent(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    @FindBy(id = "score-arrears")
    private WebElement fieldScore;
    @FindBy(id = "arrears-sum")
    private WebElement fieldSum;
    @FindBy(id = "arrears-email")
    private WebElement fieldEmail;

    public String getPlaceHolderScore() {
        return fieldScore.getAttribute("placeholder");
    }

    public String getPlaceHolderSum() {
        return fieldSum.getAttribute("placeholder");
    }

    public String getPlaceHolderEmail() {
        return fieldEmail.getAttribute("placeholder");
    }
}
