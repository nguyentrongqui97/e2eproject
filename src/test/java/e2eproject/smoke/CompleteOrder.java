package e2eproject.smoke;

import java.io.IOException;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import e2eproject.base.Hooks;
import e2eproject.pageObjects.Homepage;
import e2eproject.pageObjects.OrderFormDelivery;
import e2eproject.pageObjects.OrderFormPayment;
import e2eproject.pageObjects.OrderFormPersInfo;
import e2eproject.pageObjects.OrderFormShippingMethod;
import e2eproject.pageObjects.ShopContentPanel;
import e2eproject.pageObjects.ShopHomepage;
import e2eproject.pageObjects.ShopProductPage;
import e2eproject.pageObjects.ShoppingCart;

@Listeners
public class CompleteOrder extends Hooks {

    public CompleteOrder() throws IOException {
        super();
    }

    @Test
    public void completeOrderWithPromotionCode() throws IOException, Exception {
        Homepage home = new Homepage();
        if(!home.getSideBar().isDisplayed()) {
            home.getToggle().click();
        }

        JavascriptExecutor jse = (JavascriptExecutor) getDriver();
        jse.executeScript("arguments[0].scrollIntoView(true);", home.getTestStoreLink());
        Thread.sleep(2000);
        
        home.getTestStoreLink().click();

        ShopHomepage shop = new ShopHomepage();
        shop.getProdTwo().click();

        ShopProductPage product = new ShopProductPage();
        Select option = new Select(product.getSizeOption());
        option.selectByVisibleText("XL");
        product.getQuantIncrease().click();
        product.getAddToCartBtn().click();
        Thread.sleep(2000);

        ShopContentPanel panel = new ShopContentPanel();
        panel.getCheckoutBtn().click();
        Thread.sleep(2000);

        ShoppingCart cart = new ShoppingCart();
        cart.getHavePromo().click();
        cart.getPromoTextbox().sendKeys("20OFF");
        cart.getPromoAddBtn().click();
        cart.getProceedCheckoutBtn().click();

        OrderFormPersInfo info = new OrderFormPersInfo();
        info.getGenderMr().click();
        info.getFirstNameField().sendKeys("Qui test First Nme");
        info.getLastnameField().sendKeys("Qui test Last Nme");
        info.getEmailField().sendKeys("quitest1@gmail.com");
        info.getTermsConditionsCheckbox().click();
        info.getContinueBtn().click();

        OrderFormDelivery delivery = new OrderFormDelivery();
        delivery.getAddressField().sendKeys("Opal Tower");
        delivery.getCityField().sendKeys("Nha Trang");
        Select state = new Select(delivery.getStateDropdown());
        state.selectByVisibleText("Arizona");
        delivery.getPostcodeField().sendKeys("44444");
        delivery.getContinueBtn().click();

        OrderFormShippingMethod shipping = new OrderFormShippingMethod();
        shipping.getDeliveryMsgTextbox().sendKeys("working hour delivery");
        shipping.getContinueBtn().click();;

        OrderFormPayment payment = new OrderFormPayment();
        payment.getPayByWireRadioBtn().click();
        payment.getTermsConditionsCheckbox().click();
        payment.getOrderBtn().click();

    }

}
