package e2eproject.base;

import java.io.IOException;
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
        String browser = PropertyConfig.getProperty("browser");
        switch (browser) {
            case "firefox" -> {
                System.setProperty(
                        "webdriver.firefox.driver",
                        PropertyConfig.getProperty("fireFoxDriverPath"));
                driver = new FirefoxDriver();
                break;
            }
            case "edge" -> {
                break;
            }
            default -> {
                System.setProperty(
                        "webdriver.chrome.driver",
                        PropertyConfig.getProperty("chromeDriverPath"));
                driver = new ChromeDriver();
                break;
            }
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
