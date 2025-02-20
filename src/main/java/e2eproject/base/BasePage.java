package e2eproject.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class BasePage {

    protected String url;
    private Properties prop;

    public BasePage() throws IOException {
        prop = new Properties();
        FileInputStream data = new FileInputStream("src\\main\\java\\e2eproject\\resources\\config.properties");
        prop.load(data);
    }

    public WebDriver getDriver() throws IOException {
        return WebDriverInstance.getDriver();
    }

    public String getUrl() throws IOException {
        url = prop.getProperty("url");
        return url;
    }

    public void takeSnapShot(String name) throws IOException {

        File srcFile = ((TakesScreenshot) getDriver()).getScreenshotAs(OutputType.FILE);

        File destFile = new File("target\\screenshots\\"
                + timestamp() + ".png");

        FileUtils.copyFile(srcFile, destFile);
    }

    public static String timestamp() {
        return new SimpleDateFormat(" yyyy-mm-dd HH-mm-ss").format(new Date());
    }

}
