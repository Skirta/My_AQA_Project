package com.automationexercise.pages;

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
    private final By payAndConfirmOrderButtonLocator = By.xpath("//*[@data-qa='pay-button']");
    private final By successMessageLocator = By.xpath("//div[@class='alert-success alert']");

    //Methods

    public PaymentPage assertPaymentPageSuccessfullyLoaded() {
        waitUntilUrlToBe("https://www.automationexercise.com/payment");
        waitUntilVisibilityOfElementLocated(paimentInformationLocator);
        return this;
    }

    public PaymentPage inputNameOnCard(String nameOnCard) {
        type(inputNameOnCardLocator, nameOnCard);
        return this;
    }

    public PaymentPage inputCardNumber(String cardNumber) {
        type(inputCardNumberLocator, cardNumber);
        return this;
    }

    public PaymentPage inputCardCvc(String cardCvc) {
        type(inputCardCvcLocator, cardCvc);
        return this;
    }

    public PaymentPage inputExpirationMonth(String expirationMonth) {
        type(inputExpirationMonthLocator, expirationMonth);
        return this;
    }

    public PaymentPage inputExpirationYear(String expirationYear) {
        type(inputExpirationYearLocator, expirationYear);
        return this;
    }

    public PaymentDonePage clickPayAndConfirmOrderButton(){
        click(payAndConfirmOrderButtonLocator);
        return new PaymentDonePage(driver);
    }
}
