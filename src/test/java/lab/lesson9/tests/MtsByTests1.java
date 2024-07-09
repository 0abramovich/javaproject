
package lab.lesson9.tests;
import io.qameta.allure.*;
import lab.lesson9.pages.HomePage;
import org.junit.jupiter.api.DisplayName;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.events.EventFiringDecorator;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;
import java.time.Duration;

@Epic("Функциональное тестирование MTS.by")
@Feature("Проверка плейсхолдеров")
    public class MtsByTests1 {
    private WebDriver driver;
    private HomePage homePage;
    private Actions action;

        @BeforeClass
        public void setup() {
            System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver");
            WebDriver baseDriver = new ChromeDriver();
            WebDriver eventDriver = new EventFiringDecorator<>(new CustomEventListener()).decorate(baseDriver);
            driver = eventDriver;
            driver.manage().window().maximize();
            driver.get("https://mts.by");
            waitForPageLoad(driver);
            homePage = new HomePage(driver);
            homePage.acceptCookies();
            action = new Actions(driver);
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

        @DataProvider(name = "servicePlans")
        public Object[][] createServicePlanData() {
            return new Object[][]{
                    {"connection-sum", "Сумма", "connection-email", "E-mail для отправки чека"}
            };
        }

        @Test(priority = 1, dataProvider = "servicePlans")
        @Epic("Проверка плейсхолдеров плана услуг")
        @DisplayName("Проверка плейсхолдеров плана услуг")
        @Description("Проверка, что плейсхолдеры для плана услуг отображаются правильно")
        @Severity(SeverityLevel.CRITICAL)
        public void checkServicesPlanPlaceholders(String sumFieldId, String expectedSumPlaceholder, String emailFieldId, String expectedEmailPlaceholder) throws InterruptedException {
            try {
                action.scrollToElement(driver.findElement(By.className("pay__partners")));
                action.moveToElement(driver.findElement(By.className("select__now"))).build().perform();
                Assert.assertTrue(homePage.isServicesPlanSelectedDisplayed(), "План 'Услуги связи' выбран по умолчанию");
                Assert.assertTrue(homePage.isNumberPhonePlaceholderServicesDisplayed(), "Плейсхолдер 'Номер телефона' присутствует");
                WebElement inputSummaServices = driver.findElement(By.id(sumFieldId));
                String placeholderServicesValue = inputSummaServices.getAttribute("placeholder");
                Assert.assertEquals(placeholderServicesValue, expectedSumPlaceholder, "Значение плейсхолдера 'Сумма' не соответствует ожидаемому.");
                WebElement inputEmail = driver.findElement(By.id(emailFieldId));
                String emailPlaceholderValue = inputEmail.getAttribute("placeholder");
                Assert.assertEquals(emailPlaceholderValue, expectedEmailPlaceholder, "Значение плейсхолдера 'E-mail' не соответствует ожидаемому.");
            } finally {
                ScreenshotUtils.takeScreenshot(driver);
            }
        }

    @Test(priority = 2)
    @Epic("Проверка плейсхолдеров плана Домашний интернет")
    @DisplayName("Проверка плейсхолдеров плана Домашний интернет")
    @Description("Проверка, что плейсхолдеры для плана Домашний интернет отображаются правильно")
    @Severity(SeverityLevel.CRITICAL)
    public void checkHomeInternetPlanPlaceholders() throws InterruptedException {
        try {
            action.moveToElement(driver.findElement(By.className("select__now"))).build().perform();
            driver.findElement(By.xpath("//span[@class='select__now']")).click();
            Thread.sleep(2000);
            driver.findElement(By.xpath("//li[@class='select__item']/p[text()='Домашний интернет']")).click();
            Thread.sleep(2000);
            Assert.assertTrue(homePage.isNumberInternetHomePlaceholderDisplayed(), "Плейсхолдер 'Номер абонента' присутствует");
            Assert.assertTrue(homePage.isSummaInternetHomePlaceholderDisplayed(), "Плейсхолдер 'Сумма' присутствует");
            Assert.assertTrue(homePage.isEmailInternetHomePlaceholderDisplayed(), "Плейсхолдер 'E-mail для отправки чека' присутствует");
        } finally {
            ScreenshotUtils.takeScreenshot(driver); // Скриншот после выполнения теста
        }
    }

    @Test(priority = 3)
    @Epic("Проверка плейсхолдеров плана Рассрочка")
    @DisplayName("Проверка плейсхолдеров плана Рассрочка")
    @Description("Проверка, что плейсхолдеры для плана Рассрочка отображаются правильно")
    @Severity(SeverityLevel.CRITICAL)
    public void checkInstalmentPlanPlaceholders() throws InterruptedException {
        try {
            action.moveToElement(driver.findElement(By.className("select__now"))).build().perform();
            driver.findElement(By.xpath("//span[@class='select__now']")).click();
            Thread.sleep(2000);
            driver.findElement(By.xpath("//li[@class='select__item']/p[text()='Рассрочка']")).click();
            Thread.sleep(2000);
            Assert.assertTrue(homePage.isNumberAccountPlaceholderDisplayed(), "Плейсхолдер 'Номер счета на 44' присутствует");
            Assert.assertTrue(homePage.isSummaPlaceholderDisplayed(), "Плейсхолдер 'Сумма' присутствует");
            Assert.assertTrue(homePage.isEmailPlaceholderDisplayed(), "Плейсхолдер 'E-mail для отправки чека' присутствует");
        } finally {
            ScreenshotUtils.takeScreenshot(driver); // Скриншот после выполнения теста
        }
    }

    @Test(priority = 4)
    @Epic("Проверка плейсхолдеров плана Задолженность")
    @DisplayName("Проверка плейсхолдеров плана Задолженность")
    @Description("Проверка, что плейсхолдеры для плана Задолженность отображаются правильно")
    @Severity(SeverityLevel.CRITICAL)
    public void checkArrearsPlanPlaceholders() throws InterruptedException {
        try {
            action.moveToElement(driver.findElement(By.className("select__now"))).build().perform();
            driver.findElement(By.xpath("//span[@class='select__now']")).click();
            Thread.sleep(2000);
            driver.findElement(By.xpath("//li[@class='select__item']/p[text()='Задолженность']")).click();
            Thread.sleep(2000);
            Assert.assertTrue(homePage.isNumberAccountArrearsPlaceholderDisplayed(), "Плейсхолдер 'Номер счета на 2073' присутствует");
            Assert.assertTrue(homePage.isSummaArrearsPlaceholderDisplayed(), "Плейсхолдер 'Сумма' присутствует");
            Assert.assertTrue(homePage.isEmailArrearsPlaceholderDisplayed(), "Плейсхолдер 'E-mail для отправки чека' присутствует");
        } finally {
            ScreenshotUtils.takeScreenshot(driver); // Скриншот после выполнения теста
        }
    }
}
