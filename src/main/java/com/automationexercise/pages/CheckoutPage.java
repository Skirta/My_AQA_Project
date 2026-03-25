package com.automationexercise.pages;

import com.automationexercise.helpers.SecretManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutPage extends BasePage{

    public CheckoutPage(WebDriver driver) {
        super(driver);
    }

    //Locators
    private final By checkoutInfoLocator = By.xpath("//div[@data-qa='checkout-info']");
    private final By checkoutInfoLocator = By.xpath("//div[@data-qa='checkout-info']");
    private final By checkoutInfoLocator = By.xpath("//div[@data-qa='checkout-info']");
    private final By firstNameLastNameDeliveryAddressLocator = By.xpath("//*[@id='address_delivery']//li[@class='address_firstname address_lastname']");
    private final By companyNameDeliveryAddressLocator = By.xpath("//*[@id='address_delivery']//li[@class='address_address1 address_address2'][1]");
    private final By firstAddressDeliveryAddressLocator = By.xpath("//*[@id='address_delivery']//li[@class='address_address1 address_address2'][2]");
    private final By secondAddressDeliveryAddressLocator = By.xpath("//*[@id='address_delivery']//li[@class='address_address1 address_address2'][3]");
    private final By cityStatePostCodeDeliveryAddressLocator = By.xpath("//*[@id='address_delivery']//li[@class='address_city address_state_name address_postcode']");
    private final By countryDeliveryAddressLocator = By.xpath("//*[@id='address_delivery']//li[@class='address_country_name']");
    private final By phoneDeliveryAddressLocator = By.xpath("//*[@id='address_delivery']//li[@class='address_phone']");
    private final By firstNameLastNameBillingAddressLocator = By.xpath("//*[@id='address_invoice']//li[@class='address_firstname address_lastname']");
    private final By companyNameBillingAddressLocator = By.xpath("//*[@id='address_invoice']//li[@class='address_address1 address_address2'][1]");
    private final By firstAddressBillingAddressLocator = By.xpath("//*[@id='address_invoice']//li[@class='address_address1 address_address2'][2]");
    private final By secondAddressBillingAddressLocator = By.xpath("//*[@id='address_invoice']//li[@class='address_address1 address_address2'][3]");
    private final By cityStatePostCodeBillingAddressLocator = By.xpath("//*[@id='address_invoice']//li[@class='address_city address_state_name address_postcode']");
    private final By countryBillingAddressLocator = By.xpath("//*[@id='address_invoice']//li[@class='address_country_name']");
    private final By phoneBillingAddressLocator = By.xpath("//*[@id='address_invoice']//li[@class='address_phone']");

    //Methods

    public CheckoutPage assertCheckoutPageIsSuccessfullyLoaded(){
        waitUntilUrlToBe(SecretManager.get("BASE_URL") + "checkout");
        waitUntilVisibilityOfElementLocated(checkoutInfoLocator);
        return this;
    }

    public CheckoutPage assertAddressDetailsIsCorrect(){
    }
}
