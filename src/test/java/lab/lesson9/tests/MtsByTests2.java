package lab.lesson9.tests;

import io.qameta.allure.*;
import lab.lesson9.pages.HomePage;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;

import java.time.Duration;

@Epic("Оплата мобильного телефона")
@Feature("Проверка полей формы оплаты")
public class MtsByTests2 {
    private WebDriver driver;
    private HomePage homePage;

    @BeforeClass
    @Step("Настройка драйвера и открытие главной страницы")
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://mts.by");
        waitForPageLoad(driver);
        homePage = new HomePage(driver);
        homePage.acceptCookies();
    }

    @Step("Ожидание загрузки страницы")
    private void waitForPageLoad(WebDriver driver) {
        new WebDriverWait(driver, Duration.ofSeconds(30)).until(
                webDriver -> ((JavascriptExecutor) webDriver).executeScript("return document.readyState").equals("complete"));
    }

    @AfterClass
    @Step("Закрытие драйвера")
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    @Test(priority = 1)
    @Epic("Оплата мобильного телефона - Проверка фрейма оплаты")
    @Description("Проверка отображения фрейма оплаты после ввода данных")
    @Severity(SeverityLevel.CRITICAL)
    public void getPaymentFrame() throws InterruptedException {
        homePage.enterPhoneNumber("297777777");
        homePage.enterSum("10");
        homePage.enterEmail("test@test.com");
        homePage.clickContinueButton();

        // Ожидание загрузки фрейма
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.xpath("//iframe[@style='visibility: visible;'][1]")));
    }

    @Test(priority = 2)
    @Epic("Оплата мобильного телефона - Проверка суммы оплаты")
    @Description("Проверка, что сумма на форме оплаты равна введенной сумме")
    @Severity(SeverityLevel.NORMAL)
    public void checkSumma() throws InterruptedException {
        Thread.sleep(2000);
        WebElement summa = driver.findElement(By.xpath("//div[@class='pay-description__cost']/span[text()='10.00 BYN']"));
        Assert.assertTrue(summa.isDisplayed(), "Сумма оплаты не соответствует введенной");
    }

    @Test(priority = 3)
    @Epic("Оплата мобильного телефона - Проверка суммы на кнопке оплаты")
    @Description("Проверка, что сумма на кнопке оплаты равна введенной сумме")
    @Severity(SeverityLevel.NORMAL)
    public void checkSummaButton() throws InterruptedException {
        Thread.sleep(2000);
        WebElement summaButton = driver.findElement(By.xpath("//button[@class='colored disabled'][contains(text(), 'Оплатить  10.00 BYN')]"));
        Assert.assertTrue(summaButton.isDisplayed(), "Сумма на кнопке не соответствует введенной");
    }

    @Test(priority = 4)
    @Epic("Оплата мобильного телефона - Проверка номера телефона")
    @Description("Проверка, что номер телефона на форме оплаты присутствует и равен введенному номеру")
    @Severity(SeverityLevel.NORMAL)
    public void checkPhoneNumber() throws InterruptedException {
        Thread.sleep(2000);
        WebElement phoneNumber = driver.findElement(By.xpath("//div[@class='pay-description__text']/span[contains(text(), 'Номер:375297777777')]"));
        Assert.assertTrue(phoneNumber.isDisplayed(), "Номер телефона не соответствует");
    }

    @Test(priority = 5)
    @Epic("Оплата мобильного телефона - Проверка плейсхолдера 'Номер карты'")
    @Description("Проверка, что плейсхолдер 'Номер карты' присутствует в поле для ввода кредитной карты")
    @Severity(SeverityLevel.NORMAL)
    public void checkCardNumberPlaceholder() throws InterruptedException {
        Thread.sleep(2000);
        WebElement cardNumberPlaceholder = driver.findElement(By.xpath("//label[@class='ng-tns-c46-1 ng-star-inserted'][text()='Номер карты']"));
        Assert.assertTrue(cardNumberPlaceholder.isDisplayed(), "Плейсхолдер 'Номер Карты' не отображается");
    }

    @Test(priority = 6)
    @Epic("Оплата мобильного телефона - Проверка плейсхолдера 'Срок действия'")
    @Description("Проверка, что плейсхолдер 'Срок действия' присутствует в поле для ввода срока кредитной карты")
    @Severity(SeverityLevel.NORMAL)
    public void checkCardExpirationPlaceholder() throws InterruptedException {
        Thread.sleep(2000);
        WebElement cardExpirationPlaceholder = driver.findElement(By.xpath("//label[@class='ng-tns-c46-4 ng-star-inserted'][text()='Срок действия']"));
        Assert.assertTrue(cardExpirationPlaceholder.isDisplayed(), "Плейсхолдер 'Срок Действия' не отображается");
    }

    @Test(priority = 7)
    @Epic("Оплата мобильного телефона - Проверка плейсхолдера 'CVC'")
    @Description("Проверка, что плейсхолдер 'CVC' присутствует в поле для ввода")
    @Severity(SeverityLevel.NORMAL)
    public void checkCVCPlaceholder() throws InterruptedException {
        Thread.sleep(2000);
        WebElement cvcPlaceholder = driver.findElement(By.xpath("//label[@class='ng-tns-c46-5 ng-star-inserted'][text()='CVC']"));
        Assert.assertTrue(cvcPlaceholder.isDisplayed(), "Плейсхолдер 'CVC' не отображается");
    }

    @Test(priority = 8)
    @Epic("Оплата мобильного телефона - Проверка плейсхолдера 'Имя держателя (как на карте)'")
    @Description("Проверка, что плейсхолдер 'Имя держателя (как на карте)' присутствует в поле для ввода имени держателя карты")
    @Severity(SeverityLevel.NORMAL)
    public void checkCardholderNamePlaceholder() throws InterruptedException {
        Thread.sleep(2000);
        WebElement cardholderNamePlaceholder = driver.findElement(By.xpath("//label[@class='ng-tns-c46-3 ng-star-inserted'][text()='Имя держателя (как на карте)']"));
        Assert.assertTrue(cardholderNamePlaceholder.isDisplayed(), "Плейсхолдер 'Имя держателя (как на карте)' не отображается");
    }

    @Test(priority = 9)
    @Epic("Оплата мобильного телефона - Проверка иконки 'Mastercard'")
    @Description("Проверка, что иконка 'Mastercard' присутствует на форме оплаты")
    @Severity(SeverityLevel.MINOR)
    public void checkMastercardIcon() throws InterruptedException {
        Thread.sleep(2000);
        WebElement mastercardIcon = driver.findElement(By.xpath("//img[@class='ng-tns-c61-0 ng-star-inserted'][@src='assets/images/payment-icons/card-types/mastercard-system.svg']"));
        Assert.assertTrue(mastercardIcon.isDisplayed(), "Иконка 'Mastercard' не отображается");
    }

    @Test(priority = 10)
    @Epic("Оплата мобильного телефона - Проверка иконки 'Visa'")
    @Description("Проверка, что иконка 'Visa' присутствует на форме оплаты")
    @Severity(SeverityLevel.MINOR)
    public void checkVisaIcon() throws InterruptedException {
        Thread.sleep(2000);
        WebElement visaIcon = driver.findElement(By.xpath("//img[@class='ng-tns-c61-0 ng-star-inserted'][@src='assets/images/payment-icons/card-types/visa-system.svg']"));
        Assert.assertTrue(visaIcon.isDisplayed(), "Иконка 'Visa' не отображается");
    }

    @Test(priority = 11)
    @Epic("Оплата мобильного телефона - Проверка иконки 'BelCard'")
    @Description("Проверка, что иконка 'BelCard' присутствует на форме оплаты")
    @Severity(SeverityLevel.MINOR)
    public void checkBelCardIcon() throws InterruptedException {
        Thread.sleep(2000);
        WebElement belCardIcon = driver.findElement(By.xpath("//img[@class='ng-tns-c61-0 ng-star-inserted'][@src='assets/images/payment-icons/card-types/belkart-system.svg']"));
        Assert.assertTrue(belCardIcon.isDisplayed(), "Иконка 'BelCard' не отображается");
    }

    @Test(priority = 12)
    @Epic("Оплата мобильного телефона - Проверка иконки 'MIR' или 'Maestro'")
    @Description("Проверка, что иконка 'MIR' или 'Maestro' присутствует на форме оплаты")
    @Severity(SeverityLevel.MINOR)
    public void checkMirOrMaestroIcon() throws InterruptedException {
        Thread.sleep(2000);
        WebElement mirIcon = driver.findElement(By.xpath("//img[@src='assets/images/payment-icons/card-types/mir-system.svg']"));
        WebElement maestroIcon = driver.findElement(By.xpath("//img[@src='assets/images/payment-icons/card-types/maestro-system.svg']"));
        boolean isMirOrMaestroDisplayed = mirIcon.isDisplayed() || maestroIcon.isDisplayed();
        Assert.assertTrue(isMirOrMaestroDisplayed, "Иконка 'MIR' или 'Маестро' не отображается");

        driver.switchTo().defaultContent();
    }
}