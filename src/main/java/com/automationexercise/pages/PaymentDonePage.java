package com.automationexercise.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PaymentDonePage extends BasePage{
    public PaymentDonePage(WebDriver driver){
        super(driver);
    }

    //Locators
    private final By orderPlacedTextLocator = By.xpath("//h2/b[text()='Order Placed!']");


    //Methods

    public PaymentDonePage assertPaymentDonePageSuccessfullyLoaded() {
        waitUntilUrlContains("https://www.automationexercise.com/payment_done");
        waitUntilVisibilityOfElementLocated(orderPlacedTextLocator);
        return this;
    }

}
