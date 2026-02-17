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
    private final By relativeNameLocator = By.xpath(".//div[@class='productinfo text-center']//p");
    private final By relativePriceLocator = By.xpath(".//div[@class='productinfo text-center']//h2");
    private final By relativeViewButtonLocator = By.xpath(".//div[@class='choose']//a");
    private final By allProductsTextLocator = By.xpath("//h2[text()='All Products']");
    private final By productContainerLocator = By.xpath("//div[@class='col-sm-4']//div[@class='product-image-wrapper']");
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

    public ProductDetailsPage chooseRandomProductAndClickViewButton() {
        removeAds();
        List<WebElement> products = driver.findElements(productContainerLocator);
        int randomProductNumber = new Random().nextInt(products.size());
        WebElement randomProduct = products.get(randomProductNumber);
        String name = randomProduct.findElement(relativeNameLocator).getText();
        String price = randomProduct.findElement(relativePriceLocator).getText();
        ProductModel choosenProduct = ProductModel.builder()
                .name(name)
                .price(price)
                .build();
        WebElement viewButton = randomProduct.findElement(relativeViewButtonLocator);

        String url = viewButton.getAttribute("href");
        driver.get(url);
        return new ProductDetailsPage(driver, choosenProduct);
    }
}
