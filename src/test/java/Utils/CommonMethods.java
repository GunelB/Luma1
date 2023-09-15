package Utils;

import Page.SignUp;
import org.apache.bcel.Constants;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;

import java.io.File;
import java.time.Duration;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

public class CommonMethods {

    public static final String ScreenShot_FilePath = System.getProperty("user.dir") + "/screenshots/";


    public CommonMethods() {


    }

    public static void staticWait(int second) {
        try {
            Thread.sleep(second * 1000);
        } catch (InterruptedException e) {
            System.out.println("thread.sleep not working");
        }
    }

    public static void setWaitTime() {
        Driver.getDriver().manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    public static void selectFromDropdown(WebElement element, String text) {
        Select select = new Select(element);
        select.selectByVisibleText(text);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void clickWithWait(WebElement p_element) {
        Wait wait = new FluentWait(Driver.getDriver())
                .withTimeout(Duration.ofSeconds(15)) //wait for 15 seconds
                .pollingEvery(Duration.ofMillis(800))//polling > it will check for that elements for > 5
                .ignoring(NoSuchElementException.class)
                .ignoring(ElementNotVisibleException.class)
                .ignoring(ElementClickInterceptedException.class)
                .ignoring(StaleElementReferenceException.class)
                .ignoring(WebDriverException.class);

        WebElement element = (WebElement) wait.until((Function<WebDriver, WebElement>) driver -> p_element);

        try {
            element.click();
        } catch (WebDriverException e) {
            e.printStackTrace();
        }
        try {
            Thread.sleep(1000);
        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    public static byte[] takeScreenShots(String fileName) {
        TakesScreenshot takesScreenshot = (TakesScreenshot) Driver.getDriver();

        byte[] picBytes = takesScreenshot.getScreenshotAs(OutputType.BYTES);
        File sourceFile = takesScreenshot.getScreenshotAs(OutputType.FILE);

        try {
            FileUtils.copyFile(sourceFile, new File(ScreenShot_FilePath + fileName + ".png"));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return picBytes;

    }

}