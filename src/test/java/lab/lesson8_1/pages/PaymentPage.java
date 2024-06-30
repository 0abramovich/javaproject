package lab.lesson8_1.pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import java.util.List;

public class PaymentPage {
    WebDriver driver;

    @FindBy(xpath = "//div[contains(@class, 'pay__partners')]//img")
    List<WebElement> logos;

    public PaymentPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public List<WebElement> getLogos() {
        return logos;
    }
}


