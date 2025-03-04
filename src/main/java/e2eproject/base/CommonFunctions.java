package e2eproject.base;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Logger;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.base.Function;

public class CommonFunctions {

    private final static Logger LOGGER = Logger.getLogger("");
    protected String url;
    protected WebDriver driver;

    public void open() {
        driver.get(url);
    }

    public WebDriver getDriver() {
        return WebDriverInstance.getDriver();
    }

    public void takeSnapShot(String name) throws IOException {
        File srcFile = ((TakesScreenshot) getDriver()).getScreenshotAs(OutputType.FILE);
        File destFile = new File("target\\screenshots\\" + timestamp() + ".png");
        FileUtils.copyFile(srcFile, destFile);
    }

    public static String timestamp() {
        return new SimpleDateFormat(" yyyy-mm-dd HH-mm-ss").format(new Date());
    }

    public void acceptCookies() {

    }

    public void declineCookies() {

    }

    public void waitForElementVisibilityWithTimeOut(WebElement element, long timeOutInSeconds) {
        LOGGER.info("Waiting for element " + element + " to be visible within " + timeOutInSeconds + "seconds");
        Function<? super WebDriver, ?> condition;
        condition = ExpectedConditions.visibilityOf(element);
        WebDriverWait wait = new WebDriverWait(getDriver(), timeOutInSeconds);
        wait.until(condition);

    }

    public void waitForElementToBeClickableWithTimeOut(WebElement element, long timeOutInSeconds) {
        LOGGER.info("Waiting for element " + element + " to be clickable within " + timeOutInSeconds + "seconds");
        Function<? super WebDriver, ?> condition;
        condition = ExpectedConditions.elementToBeClickable(element);
        WebDriverWait wait = new WebDriverWait(getDriver(), timeOutInSeconds);
        wait.until(condition);
    }

    public void clickElement(WebElement element) throws IOException {
        LOGGER.info("Click element " + element);
        element.click();
    }

    public void waitForElementVisibilityThenClick() {

    }

    public void typeValuesIntoTextBox(WebElement element, String value) {
        LOGGER.info("Element " + element + " is sent values: " + value);
        element.sendKeys(value);
    }

    public void scrollToElements(WebElement element) throws InterruptedException, IOException {
        LOGGER.info("Scroll into element: " + element);
        JavascriptExecutor jse = (JavascriptExecutor) getDriver();
        jse.executeScript("arguments[0].scrollIntoView(true);", element);
        Thread.sleep(2000);
    }

    public void selectVisibleTextInDropdown(WebElement element, String value) {
        Select dropdown = new Select((WebElement) element);
        dropdown.selectByVisibleText(value);
    }

}




