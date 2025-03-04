package e2eproject.smoke;

import java.io.IOException;

import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
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
import e2eproject.resources.JsonReader;

@Listeners
public class CompleteOrderWithoutPromotionCode extends Hooks {

    public CompleteOrderWithoutPromotionCode() throws IOException {
        super();
    }

    @Test
    public void CompleteOrderWithoutPromotionCode() throws IOException, InterruptedException, ParseException {

        CommonFunctions function = new CommonFunctions();

        Homepage home = new Homepage();
        if (!home.getSideBar().isDisplayed()) {
            home.getToggle().click();
        }

        function.scrollToElements(home.getTestStoreLink());
        function.clickElement(home.getTestStoreLink());

        ShopHomepage shop = new ShopHomepage();
        function.waitForElementVisibilityWithTimeOut(shop.getProdTwo(), 5);
        function.clickElement(shop.getProdTwo());

        ShopProductPage product = new ShopProductPage();

        function.selectVisibleTextInDropdown(product.getSizeOption(), "XL");
        function.clickElement(product.getQuantIncrease());
        function.clickElement(product.getAddToCartBtn());

        ShopContentPanel panel = new ShopContentPanel();
        function.clickElement(panel.getCheckoutBtn());

        ShoppingCart cart = new ShoppingCart();
        function.clickElement(cart.getProceedCheckoutBtn());

        // Read data 
        JSONObject testData = JsonReader.readJson("src\\main\\java\\e2eproject\\testData\\TestData.json");
        JSONObject user = (JSONObject) testData.get("user");
        String firstName = (String) user.get("firstName");
        String lastName = (String) user.get("lastName");
        String email = (String) user.get("email");
        String address = (String) user.get("address");
        String addressCity = (String) user.get("addressCity");
        String state = (String) user.get("state");
        String postCode = (String) user.get("postCode");

        OrderFormPersInfo info = new OrderFormPersInfo();
        function.clickElement(info.getGenderMr());
        function.typeValuesIntoTextBox(info.getFirstNameField(), firstName);
        function.typeValuesIntoTextBox(info.getLastnameField(), lastName);

        function.typeValuesIntoTextBox(info.getEmailField(), email);
        function.clickElement(info.getTermsConditionsCheckbox());
        function.clickElement(info.getContinueBtn());

        OrderFormDelivery delivery = new OrderFormDelivery();
        function.typeValuesIntoTextBox(delivery.getAddressField(), address);
        function.typeValuesIntoTextBox(delivery.getCityField(), addressCity);
        function.selectVisibleTextInDropdown(delivery.getStateDropdown(), state);
        function.typeValuesIntoTextBox(delivery.getPostcodeField(), postCode);
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
