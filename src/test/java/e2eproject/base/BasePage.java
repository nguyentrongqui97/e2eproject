package e2eproject.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BasePage {

    public static WebDriver driver;
    private String url;
    private Properties prop;

    public BasePage() throws IOException {
        prop = new Properties();
        FileInputStream data = new FileInputStream("C:Users\\ntqi\\OneDrive - Netcompany\\Desktop\\e2esmoke\\src\\test\\java\\e2eproject\\resources\\config.properties");
        prop.load(data);
    }

    public WebDriver getDriver() throws IOException {
        if (prop.getProperty("browser").equals("chrome")) {
            System.setProperty("webdriver.chrome.driver", "C:\\Users\\ntqi\\OneDrive - Netcompany\\Desktop\\e2esmoke\\src\\test\\java\\e2eproject\\drivers\\chromedriver.exe");

            driver = new ChromeDriver();
        } else {
            System.setProperty("webdriver.chrome.driver", "C:\\Users\\ntqi\\OneDrive - Netcompany\\Desktop\\e2esmoke\\src\\test\\java\\e2eproject\\drivers\\geckodriver.exe");
            driver = new FirefoxDriver();
        }

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        takeSnapShot(driver);

        return driver;

    }

    public String getUrl() throws IOException {
        Properties prop = new Properties();
        FileInputStream data = new FileInputStream(
                "C:\\Users\\ntqi\\OneDrive - Netcompany\\Desktop\\e2esmoke\\src\\test\\java\\e2eproject\\resources\\config.properties");
        prop.load(data);
        url = prop.getProperty("url");
        return url;
    }

    public static void takeSnapShot(WebDriver webdriver) throws IOException {
        // webdriver instance is needed because we need to take screen shot of the
        // current screen
        File srcFile = ((TakesScreenshot) webdriver).getScreenshotAs(OutputType.FILE);

        // store the snapshot file
        File destFile = new File("C:\\Users\\ntqi\\OneDrive - Netcompany\\Desktop\\e2esmoke\\target\\screenshots"
                + timestamp() + ".png");

        // copy the snapshot file from srcFile to destFile
        FileUtils.copyFile(srcFile, destFile);
    }

    public static String timestamp() {
        return new SimpleDateFormat("yyyy-mm-dd HH-mm-ss").format(new Date());
    }

}
