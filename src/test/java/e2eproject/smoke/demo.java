package e2eproject.smoke;

import java.io.IOException;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import e2eproject.base.BasePage;

@Listeners(e2eproject.resources.Listeners.class)
@Test
public class demo extends BasePage {
    
    public demo() throws IOException {
        super();
        //TODO Auto-generated constructor stub
    }

    @BeforeTest
    public void setUP() throws IOException {
        driver = getDriver();
        driver.get(getUrl());
    }

    @AfterTest
    public void tearDown() {
        driver.close();
        driver = null;
    }
    
    @Test
    public void navigateToProduct() {
        driver.navigate().to("https://teststore.automationtesting.co.uk/index.php?id_product=1&id_product_attribute=1&rewrite=hummingbird-printed-t-shirt&controller=product#/1-size-s/8-color-white");
        Assert.assertEquals(driver.findElement(By.cssSelector(".current-price-value")).getText(), "19.13");
    }

}
