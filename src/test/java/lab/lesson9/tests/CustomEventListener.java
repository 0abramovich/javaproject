
package lab.lesson9.tests;
import io.qameta.allure.Allure;
import org.openqa.selenium.*;
import org.openqa.selenium.support.events.WebDriverListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;

public class CustomEventListener implements WebDriverListener {

    private static Logger logger = LoggerFactory.getLogger(CustomEventListener.class);
    @Override
    public void beforeClick(WebElement element) {
        Allure.step("Клик на " + element);
        System.out.println("About to click: " + element);
    }
    @Override
    public void afterClick(WebElement element) {
        System.out.println("Clicked: " + element);
    }

}

