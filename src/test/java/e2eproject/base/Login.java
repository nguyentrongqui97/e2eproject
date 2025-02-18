package e2eproject.base;

import java.io.IOException;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class Login extends BasePage {

    public Login() throws IOException {
        super();
    }

    @Test
    public void signIn() throws InterruptedException, IOException {

        driver = getDriver();
        driver.get(getUrl());

        driver.findElement(By.cssSelector(".user-info .hidden-sm-down")).click();
        Thread.sleep(2000);
        driver.findElement(By.cssSelector("#field-email")).sendKeys("testuser@gmail.com");
        Thread.sleep(2000);
        driver.findElement(By.cssSelector("#field-password")).sendKeys("Testing123!");
        Thread.sleep(2000);
        driver.findElement(By.cssSelector("button#submit-login")).click();
        Thread.sleep(2000);
    }
}
