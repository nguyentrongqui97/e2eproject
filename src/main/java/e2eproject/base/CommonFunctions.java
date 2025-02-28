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

public class CommonFunctions {

    private final static Logger LOGGER = Logger.getLogger(CommonFunctions.class.getName());
    protected String url;
    protected  WebDriver driver;

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

    public void waitForElementVisibility() {

    }

    public void clickElement(WebElement element) throws IOException {
        element.click();
    }

    public void waitForElementVisibilityThenClick() {

    }

    public void typeValuesIntoTextBox() {

    }

    public void scrollToElements(WebElement element) throws InterruptedException, IOException  {
        JavascriptExecutor jse = (JavascriptExecutor) getDriver();
        jse.executeScript("arguments[0].scrollIntoView(true);", element);
        Thread.sleep(2000);
    }

    public void selectVisibleTextInDropdown(String value) {

    }


}
