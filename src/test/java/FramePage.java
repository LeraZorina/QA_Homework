import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;

public class FramePage {
    public WebDriver driver;

    public FramePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    @FindBy(xpath = "//iframe[@class='bepaid-iframe']")
    private WebElement iframe;
    @FindBy(xpath = "//*[@class='pay-description__cost']//span[1]")
    private WebElement textField;
    @FindBy(xpath = "//* [@class='card-page__card']//button")
    private WebElement payBtn;
    @FindBy(xpath = "//* [@class='pay-description__text']")
    private WebElement fieldPhone;
    @FindBy(xpath = "//label[contains(@class,'ng-tns-c46-1 ng-star-inserted')]")
    private WebElement fieldCardNum;
    @FindBy(xpath = "//label[contains(@class,'ng-tns-c46-4 ng-star-inserted')]")
    private WebElement fieldValidity;
    @FindBy(xpath = "//label[contains(@class,'ng-tns-c46-5 ng-star-inserted')]")
    private WebElement fieldCvc;
    @FindBy(xpath = "//label[contains(@class,'ng-tns-c46-3 ng-star-inserted')]")
    private WebElement fieldHolderName;
    @FindBy(xpath = "//*[@class='cards-brands ng-tns-c46-1']//img")
    private List<WebElement> icons;

    public void switchToIframe() {
        driver.switchTo().frame(iframe);
        WebDriverWait wait = new WebDriverWait(driver, 15);
        wait.until(ExpectedConditions.visibilityOf(textField));
    }

    public String getPayText() {
        return textField.getText();
    }

    public String getBtnText() {
        return payBtn.getText();
    }

    public String getPhone() {
        return fieldPhone.getText();
    }

    public String getPlaceHolderCardName() {
        return fieldCardNum.getText();
    }

    public String getPlaceHolderValidity() {
        return fieldValidity.getText();
    }

    public String getPlaceHolderCvc() {
        return fieldCvc.getText();
    }

    public String getHolderName() {
        return fieldHolderName.getText();
    }

    public int countIcons() {
        return icons.size();
    }

    public ArrayList<String> getSrcIcons() {
        ArrayList<String> result = new ArrayList<String>();
        for (WebElement element : icons) {
            String src = element.getAttribute("src");
            result.add(src.substring(src.lastIndexOf("/") + 1));
        }
        return result;
    }
}
