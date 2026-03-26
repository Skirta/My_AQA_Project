package com.automationexercise.pages;

import com.automationexercise.helpers.SecretManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PaymentPage extends BasePage {

    public PaymentPage(WebDriver driver) {
        super(driver);
    }

    //Locators

    private final By paimentInformationLocator = By.xpath("//*[@class='payment-information']");
    private final By inputNameOnCardLocator = By.xpath("//*[@data-qa='name-on-card']");
    private final By inputCardNumberLocator = By.xpath("//*[@data-qa='card-number']");
    private final By inputCardCvcLocator = By.xpath("//*[@data-qa='cvc']");
    private final By inputExpirationMonthLocator = By.xpath("//*[@data-qa='expiry-month']");
    private final By inputExpirationYearLocator = By.xpath("//*[@data-qa='expiry-year']");

    //Methods

    public PaymentPage assertPaymentPageSuccessfullyLoaded() {
        waitUntilUrlToBe(SecretManager.get("BASE_URL") + "payment");
        waitUntilVisibilityOfElementLocated(paimentInformationLocator);
        return this;
    }

    public PaymentPage inputNameOnCard(String name) {
        type(inputNameOnCardLocator, name);
        return this;
    }

    public PaymentPage inputCardNumber(String name) {
        type(inputCardNumberLocator, name);
        return this;
    }

    public PaymentPage inputCardCvc(String name) {
        type(inputCardCvcLocator, name);
        return this;
    }

    public PaymentPage inputExpirationMonth(String name) {
        type(inputExpirationMonthLocator, name);
        return this;
    }

    public PaymentPage inputExpirationYear(String name) {
        type(inputExpirationYearLocator, name);
        return this;
    }

}
