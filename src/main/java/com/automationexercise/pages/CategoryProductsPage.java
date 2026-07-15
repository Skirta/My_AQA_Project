package com.automationexercise.pages;

import com.automationexercise.helpers.SecretManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CategoryProductsPage extends BasePage {
    public CategoryProductsPage(WebDriver driver) {
        super(driver);
    }

    //Locators
     private final By logoLocator = By.xpath("//img[contains(@src,'logo.png')]");

    //Methods
    public CategoryProductsPage assertCategoryProductsPageIsSuccessfullyLoaded() {
        waitUntilUrlContains(SecretManager.get("BASE_URL") + "category_products");
        return this;
    }
}