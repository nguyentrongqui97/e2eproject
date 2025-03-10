package e2eproject.pageObjects;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import e2eproject.base.CommonFunctions;

public class ShopContentPanel extends CommonFunctions {

    public WebDriver driver;

    By continueShoppingBtn = By.xpath("//button[contains(text(), 'Continue')]");
    By checkoutBtn = By.cssSelector(".cart-content-btn .btn-primary");

    public ShopContentPanel() throws IOException {
        super();
    }

    public WebElement getContinueShopBtn() throws IOException {
        this.driver = getDriver();
        return driver.findElement(continueShoppingBtn);
    }

    public WebElement getCheckoutBtn() throws IOException {
        this.driver = getDriver();
        return driver.findElement(checkoutBtn);
    }
}
