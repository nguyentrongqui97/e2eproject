package e2eproject.pageObjects;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import e2eproject.base.CommonFunctions;

public class ShopHomepage extends CommonFunctions {

    public WebDriver driver;

    By productOne = By.linkText("Hummingbird Printed T-Shirt");
    By productTwo = By.linkText("Hummingbird Printed Sweater");
    By productThree = By.linkText("The Best Is Yet To Come'...");
    By productFour = By.linkText("The Adventure Begins Framed...");
    By productFive = By.linkText("Today Is A Good Day Framed...");
    By productSix = By.linkText("Mug The Best Is Yet To Come");
    By productSeven = By.linkText("Mug The Adventure Begins");
    By productEight = By.linkText("Mug Today Is A Good Day");

    public ShopHomepage() throws IOException {
        super();
    }

    public WebElement getProdOne() throws IOException {
        this.driver = getDriver();
        return driver.findElement(productOne);
    }

    public WebElement getProdTwo() throws IOException {
        this.driver = getDriver();
        return driver.findElement(productTwo);
    }

    public WebElement getProdThree() throws IOException {
        this.driver = getDriver();
        return driver.findElement(productThree);
    }

    public WebElement getProdFour() throws IOException {
        this.driver = getDriver();
        return driver.findElement(productFour);
    }

    public WebElement getProdFive() throws IOException {
        this.driver = getDriver();
        return driver.findElement(productFive);
    }

    public WebElement getProdSix() throws IOException {
        this.driver = getDriver();
        return driver.findElement(productSix);
    }

    public WebElement getProdSeven() throws IOException {
        this.driver = getDriver();
        return driver.findElement(productSeven);
    }

    public WebElement getProdEight() throws IOException {
        this.driver = getDriver();
        return driver.findElement(productEight);
    }
}
