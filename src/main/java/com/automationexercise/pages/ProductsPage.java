package com.automationexercise.pages;

import com.automationexercise.models.ProductModel;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.Random;

public class ProductsPage extends BasePage {

    public ProductsPage(WebDriver driver) {
        super(driver);
    }

    //Locators
    private final By allProductsTextLocator = By.xpath("//h2[text()='All Products']");
    private final By productContainerLocator = By.xpath("//div[@class='single-products']");
    private final By viewButtonsLocator = By.xpath("//a[contains(@href, '/product_details/')]");

    //Methods
    public ProductsPage assertProductsPageIsSuccessfullyLoaded() {
        waitUntilVisibilityOfElementLocated(allProductsTextLocator);
        return this;
    }

    public ProductsPage assertProductsMoreThan(int numberOfProducts) {
        waitUntilNumberOfElementsToBeMoreThan(productContainerLocator, numberOfProducts);
        return this;
    }

    public ProductsPage clickRandomViewProductButton() {
        List<WebElement> products = driver.findElements(productContainerLocator);
        int randomProductNumber = new Random().nextInt(products.size()) + 1;
        click(viewButtonsLocator);
        return this;
    }


}
