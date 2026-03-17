package com.automationexercise.components;

import com.automationexercise.pages.BasePage;
import com.automationexercise.pages.CartPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartModal extends BasePage {
    public CartModal(WebDriver driver){
        super(driver);
    }

    //Locators
    private final By modalDialogLocator = By.id("cartModal");
    private final By continueShoppingButtonLocator = By.xpath("//button[text()='Continue Shopping']");
    private final By viewCartButtonLocator = By.xpath("//div[@class='modal-body']//a[@href='/view_cart']");

    //Methods

    public CartModal assertAddedModalIsSuccessfullyLoaded() {
        waitUntilVisibilityOfElementLocated(modalDialogLocator);
        return this;
    }

    public void clickContinueShoppingButton() {
        waitUntilElementClickable(continueShoppingButtonLocator).click();
    }

    public CartPage clickViewCartButton() {
        waitUntilElementClickable(viewCartButtonLocator).click();
        return new CartPage(driver);
    }
}