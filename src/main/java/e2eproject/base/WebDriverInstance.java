package e2eproject.base;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class WebDriverInstance {

    // store driver session into ThreadLocal of Java to manage driver instances
    public static ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    public static WebDriver getDriver() {
        if (driver.get() == null) {
            try {
                driver.set(createDriver());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return driver.get();
    }

    public static WebDriver createDriver() throws IOException {
        WebDriver driver = null;

        Properties prop = new Properties();
        FileInputStream data = new FileInputStream("src\\main\\java\\e2eproject\\resources\\config.properties");
        prop.load(data);

        if (prop.getProperty("browser").equals("firefox")) {

            System.setProperty("webdriver.firefox.driver", "src\\main\\java\\e2eproject\\drivers\\geckodriver.exe");
            driver = new FirefoxDriver();

        } else {

            System.setProperty("webdriver.chrome.driver", "src\\main\\java\\e2eproject\\drivers\\chromedriver.exe");
            driver = new ChromeDriver();

        }

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        return driver;

    }

    public static void cleanupDriver() {
        driver.get().quit();
        driver.remove();
    }
}
