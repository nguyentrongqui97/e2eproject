package e2eproject.smoke;

import java.io.IOException;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import e2eproject.base.CommonFunctions;
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
public class CompleteOrderWithPromotionCode extends Hooks {

    public CompleteOrderWithPromotionCode() throws IOException {
        super();
    }

    @Test
    public void completeOrderWithPromotionCode() throws IOException, Exception {

        CommonFunctions function = new CommonFunctions();

        Homepage home = new Homepage();   
        if(!home.getSideBar().isDisplayed()) {
            home.getToggle().click();
        }

        function.scrollToElements(home.getTestStoreLink());
        function.clickElement(home.getTestStoreLink());

        ShopHomepage shop = new ShopHomepage();
        function.clickElement(shop.getProdTwo());

        ShopProductPage product = new ShopProductPage();
        function.selectVisibleTextInDropdown(product.getSizeOption(), "XL");
        function.clickElement(product.getQuantIncrease());
        function.clickElement(product.getAddToCartBtn());

        ShopContentPanel panel = new ShopContentPanel();
        function.clickElement(panel.getCheckoutBtn());

        ShoppingCart cart = new ShoppingCart();
        function.clickElement(cart.getHavePromo());
        function.typeValuesIntoTextBox(cart.getPromoTextbox(), "20OFF");

        function.clickElement(cart.getPromoAddBtn());
        function.clickElement(cart.getProceedCheckoutBtn());

        OrderFormPersInfo info = new OrderFormPersInfo(); 
        function.clickElement(info.getGenderMr());
        function.typeValuesIntoTextBox(info.getFirstNameField(), "Qui test First Nme");
        function.typeValuesIntoTextBox(info.getLastnameField(), "Qui test Last Nme");
        function.typeValuesIntoTextBox(info.getEmailField(), "quitest1@gmail.com");
        function.clickElement(info.getTermsConditionsCheckbox());
        function.clickElement(info.getContinueBtn());

        OrderFormDelivery delivery = new OrderFormDelivery();
        function.typeValuesIntoTextBox(delivery.getAddressField(), "Opal Tower");
        function.typeValuesIntoTextBox(delivery.getCityField(), "Nha Trang");
        function.selectVisibleTextInDropdown(delivery.getStateDropdown(),"Arizona");
        function.typeValuesIntoTextBox(delivery.getPostcodeField(), "44444");
        function.clickElement(delivery.getContinueBtn());

        OrderFormShippingMethod shipping = new OrderFormShippingMethod();
        function.typeValuesIntoTextBox(shipping.getDeliveryMsgTextbox(), "working hour delivery");
        function.clickElement(shipping.getContinueBtn());

        OrderFormPayment payment = new OrderFormPayment();
        function.clickElement(payment.getPayByWireRadioBtn());
        function.clickElement(payment.getTermsConditionsCheckbox());
        function.clickElement(payment.getOrderBtn());
    }

}
