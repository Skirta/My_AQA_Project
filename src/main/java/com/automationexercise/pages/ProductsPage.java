package com.automationexercise.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductsPage extends BasePage {

    public ProductsPage(WebDriver driver) {
        super(driver);
    }

    //Locators
    private final By allProductsTextLocator = By.xpath("//h2[text()='All Products']");
    private final By productContainerLocator = By.xpath("//div[@class='single-products']");
    private final By viewButtonsLocator = By.xpath("//div[@class='single-products']");

    //Methods
    public ProductsPage assertProductsPageIsSuccessfullyLoaded() {
        waitUntilVisibilityOfElementLocated(allProductsTextLocator);
        return this;
    }

    public ProductsPage assertProductsMoreThan(int numberOfProducts) {
        waitUntilNumberOfElementsToBeMoreThan(productContainerLocator, numberOfProducts);
        return this;
    }


}
