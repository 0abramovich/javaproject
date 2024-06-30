package lab.lesson8_1.tests;
import lab.lesson8_1.pages.HomePage;
import lab.lesson8_1.pages.PaymentPage;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;
import java.time.Duration;

public class MtsByTests {
    private WebDriver driver;
    private HomePage homePage;
    private PaymentPage paymentPage;

    @BeforeClass
    public void setup() {
        System.setProperty("webdriver.chrome.driver",
                "src/main/resources/chromedriver");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://mts.by");
        waitForPageLoad(driver);
        homePage = new HomePage(driver);
        homePage.acceptCookies();
        paymentPage = new PaymentPage(driver);
    }

    private void waitForPageLoad(WebDriver driver) {
        new WebDriverWait(driver, Duration.ofSeconds(30)).until(
                webDriver -> ((JavascriptExecutor) webDriver).executeScript("return document.readyState").equals("complete"));
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    @Test
    public void testBlockTitle() {
        String expectedTextPart1 = "Онлайн пополнение";
        String expectedTextPart2 = "без комиссии";
        String actualText = homePage.getBlockTitleText();
        // Проверяем, что обе части текста присутствуют и находятся в правильном порядке с пробелом или новой строкой между ними
        boolean isCorrectOrder = actualText.matches(".*" + expectedTextPart1 + "\\s+.*" + expectedTextPart2 + ".*");
        Assert.assertTrue(isCorrectOrder,
                "Block title is incorrect. Found: " + actualText);
    }

@Test
    public void testMoreInfoLink() {
        homePage.clickMoreInfoLink();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.urlContains("/help/poryadok-oplaty-i-bezopasnost-internet-platezhey/"));
        String currentUrl = driver.getCurrentUrl();
        Assert.assertTrue(currentUrl.contains("/help/poryadok-oplaty-i-bezopasnost-internet-platezhey/"),
                "Failed to navigate to 'Подробнее о сервисе' page. Current URL: " + currentUrl);

        driver.navigate().back();
        wait.until(ExpectedConditions.urlToBe("https://www.mts.by/"));
        currentUrl = driver.getCurrentUrl();
        Assert.assertEquals(currentUrl, "https://www.mts.by/", "Failed to return to the home page after clicking 'Подробнее о сервисе'");
    }

    @Test
    public void testPaymentSystemLogos() {
        Assert.assertNotNull(paymentPage.getLogos(), "Payment system logos are missing.");
    }

    @Test
    public void testContinueButtonTextTitle() {
        String continueButtonText = homePage.getContinueButtonText();
        Assert.assertEquals(continueButtonText, "Продолжить", "Button text is not as expected.");
    }

    @Test
    public void testContinueButtonEmptyFields() {
        homePage.clickContinueButton();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(homePage.getPhoneField()));
        WebElement activeElement = driver.switchTo().activeElement();
        Assert.assertEquals(activeElement, homePage.getPhoneField(), "Focus is not on the phone field.");

        String currentUrl = driver.getCurrentUrl();
        Assert.assertEquals(currentUrl, "https://www.mts.by/", "Transition occurred when it should not have.");

        // Проверка, что кнопка continueButton все еще присутствует
        Assert.assertTrue(homePage.getContinueButton().isDisplayed(), "Continue button is not displayed.");
    }

    @Test
    public void testContinueButtonOnlyEmail() {
        homePage.enterEmail("test@example.com");
      WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        homePage.clickContinueButton();
        WebElement activeElement = driver.switchTo().activeElement();
        Assert.assertEquals(activeElement, homePage.getPhoneField(), "Focus is not on the phone field.");
        // Проверка, что переход на другую страницу не произошел
        String currentUrl = driver.getCurrentUrl();
        Assert.assertEquals(currentUrl, "https://www.mts.by/", "Transition occurred when it should not have.");
        // Проверка, что кнопка continueButton все еще присутствует
        Assert.assertTrue(homePage.getContinueButton().isDisplayed(), "Continue button is not displayed.");
    }


    @Test
    public void testContinueButtonRequiredFields() {
        homePage.clearEmail();
        homePage.enterPhoneNumber("297777777");
        homePage.enterSum("10");
        homePage.clickContinueButton();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.urlToBe("https://www.mts.by/"));
        // Проверка, что кнопка Продолжить больше не отображается
        String continueButtonText = homePage.getContinueButtonText();
        Assert.assertEquals(continueButtonText, "Продолжить", "Button text is not as expected after clearing fields.");

    }

}
