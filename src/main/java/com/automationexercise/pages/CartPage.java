package com.automationexercise.pages;

import com.automationexercise.helpers.SecretManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartPage extends BasePage {

    public CartPage(WebDriver driver) {
        super(driver);
    }

    //Locators
    private final By shoppingCartTextLocator = By.xpath("//li[text()='Shopping Cart']");

    //Methods
    public CartPage assertCartPageIsSuccessfullyLoaded() {
        waitUntilVisibilityOfElementLocated(shoppingCartTextLocator);
        waitUntilUrlToBe(SecretManager.get("BASE_URL") + "view_cart");
        return this;
    }
}