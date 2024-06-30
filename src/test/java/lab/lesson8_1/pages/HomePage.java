package lab.lesson8_1.pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
    WebDriver driver;

    @FindBy(xpath = "//button[contains(text(), 'Принять')]")
    WebElement acceptCookiesButton;

    @FindBy(xpath = "//div[@class='pay__wrapper']/h2")
    WebElement blockTitle;

    @FindBy(xpath = "//a[contains(@href, '/help/poryadok-oplaty-i-bezopasnost-internet-platezhey/')]")
    WebElement moreInfoLink;

    @FindBy(xpath = "//form[@id='pay-connection']//button[@type='submit']")
    WebElement continueButton;

    @FindBy(xpath = "//form[@id='pay-connection']//input[@id='connection-phone']")
    WebElement phoneField;

    @FindBy(xpath = "//form[@id='pay-connection']//input[@id='connection-email']")
    WebElement emailField;

    @FindBy(xpath = "//form[@id='pay-connection']//input[@id='connection-sum']")
    WebElement sumField;

    public HomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void acceptCookies() {
        acceptCookiesButton.click();
    }

    public String getBlockTitleText() {
        scrollToElement(blockTitle);
        return blockTitle.getText().replace("\n", " ");
    }

    public void clickMoreInfoLink() {
        //scrollToElement(moreInfoLink);
        moreInfoLink.click();
    }

    public void clickContinueButton() {
         scrollToElement(continueButton);
        continueButton.click();
    }

    public void enterPhoneNumber(String phone) {
        phoneField.sendKeys(phone);
    }

    public void enterEmail(String email) {
        emailField.sendKeys(email);
    }

    public void enterSum(String sum) {
        sumField.sendKeys(sum);
    }

    public WebElement getPhoneField() {
        return phoneField;
    }
    public void clearEmail() {
        emailField.clear();
    }
    public WebElement getContinueButton() {
        return continueButton;
    }
    public String getContinueButtonText() {
        return continueButton.getText();
    }
    private void scrollToElement(WebElement element) {
        Actions actions = new Actions(driver);
        actions.moveToElement(element).perform();
    }
}
