package com.automationexercise.pages;

import com.automationexercise.helpers.SecretManager;
import com.automationexercise.models.ProductModel;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.ArrayList;
import java.util.List;

public class CartPage extends BasePage {

    private final List<ProductModel> productsList;

    public CartPage (WebDriver driver, List<ProductModel> productsList){
        super(driver);
        this.productsList = productsList;
    }

    public CartPage(WebDriver driver){
        super(driver);
        this.productsList = new ArrayList<>();
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