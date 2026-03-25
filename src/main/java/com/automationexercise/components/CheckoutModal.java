package com.automationexercise.components;

import com.automationexercise.pages.BasePage;
import com.automationexercise.pages.LoginPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutModal extends BasePage {

    public CheckoutModal(WebDriver driver) {
        super(driver);
    }

    //Locators
    private final By modalDialogLocator = By.xpath("//div[@class='modal show']");
    private final By registerLoginButton = By.xpath("//div[@class='modal show']//a");

    //Methods
    public CheckoutModal assertCheckoutModalIsSuccessfullyLoaded() {
        waitUntilVisibilityOfElementLocated(modalDialogLocator);
        return this;
    }

    public LoginPage clickRegisterLoginButton() {
        click(registerLoginButton);
        return new LoginPage(driver);
    }
}
