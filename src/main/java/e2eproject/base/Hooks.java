package e2eproject.base;

import java.io.IOException;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class Hooks {

    public Hooks() throws IOException {
        super();
        //TODO Auto-generated constructor stub
    }

    @BeforeTest
    public void setUP() throws IOException {
        WebDriverInstance.getDriver().get(PropertyConfig.getProperty("url"));
    }

    @AfterTest
    public void tearDown() {
        WebDriverInstance.cleanupDriver();
    }
}
