package com.automationexercise.pages;

import com.automationexercise.models.ProductModel;
import lombok.Builder;
import lombok.Data;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static org.assertj.core.api.Assertions.assertThat;

public class ProductsPage extends BasePage {

    // змінна для збереження останнього вибраного продукту
    private ProductModel lastSelectedProduct;

    public ProductModel getLastSelectedProduct() {
        return lastSelectedProduct;
    }

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
    private final By searchInputLocator = By.id("search_product");
    private final By searchButtonLocator = By.id("submit_search");
    private final By searchedProductTextLocator = By.xpath("//h2[@class='title text-center']");
    private final By relativeAddToCartButtonLocator = By.xpath(".//a[@class='btn btn-default add-to-cart']");


    //Methods
    public ProductsPage assertProductsPageIsSuccessfullyLoaded() {
        waitUntilVisibilityOfElementLocated(allProductsTextLocator);
        return this;
    }

    public ProductsPage assertProductsMoreThan(int numberOfProducts) {
        waitUntilNumberOfElementsToBeMoreThan(productContainerLocator, numberOfProducts);
        return this;
    }

    public List<String> getAllProductsNames() {
        removeAds();
        waitUntilVisibilityOfElementLocated(productContainerLocator);
        List<WebElement> productContainer = driver.findElements(productContainerLocator);
        List<String> productList = new ArrayList<>();
        for (WebElement container : productContainer) {
            String name = container.findElement(relativeNameLocator).getText();
            productList.add(name);
        }
        return productList;
    }

    public List<ProductModel> getAllProductsNamesAndPrices() {
        removeAds();
        waitUntilVisibilityOfElementLocated(productContainerLocator);
        List<WebElement> productContainer = driver.findElements(productContainerLocator);
        List<ProductModel> productList = new ArrayList<>();
        for (WebElement container : productContainer) {
            String name = container.findElement(relativeNameLocator).getText();
            String price = container.findElement(relativePriceLocator).getText();
            ProductModel names = ProductModel.builder()
                    .name(name)
                    .price(price)
                    .build();
            productList.add(names);
        }
        return productList;
    }

    public String getRandomProductName() {
        List<String> allProductsNames = getAllProductsNames();
        int randomProductNumber = new Random().nextInt(allProductsNames.size());
        return allProductsNames.get(randomProductNumber);
    }

    public ProductsPage inputRandomProductNameToSearchBox(String text) {
        type(searchInputLocator, text);
        return this;
    }

    public ProductsPage clickSearchButton() {
        click(searchButtonLocator);
        return this;
    }

    public ProductsPage assertSearchedProductsTextIsVisible() {
        waitUntilTextToBeInElement(searchedProductTextLocator, "SEARCHED PRODUCTS");
        return this;
    }

    public ProductsPage assertOnlyRelatedProductsAreVisible(String expectedName) {
        List<String> allProductsNames = getAllProductsNames();
        for (String actualProductName : allProductsNames) {
            assertThat(actualProductName)
                    .as("Search validation for: " + expectedName)
                    .contains(expectedName);
        }
        return this;
    }

    private RandomProduct getRandomProduct() {
        List<ProductModel> allProductsNamesAndPrices = getAllProductsNamesAndPrices();
        List<WebElement> productContainer = driver.findElements(productContainerLocator);
        int randomProductNumber = new Random().nextInt(allProductsNamesAndPrices.size());
        return RandomProduct.builder()
                .productModel(allProductsNamesAndPrices.get(randomProductNumber))
                .webElement(productContainer.get(randomProductNumber))
                .build();
    }

    public ProductsPage chooseRandomProductAndClickAddToCartButton() {
        RandomProduct randomProduct = getRandomProduct();
        this.lastSelectedProduct = randomProduct.productModel;
        new Actions(driver)
                .moveToElement(randomProduct.webElement)
                .perform();
        removeAds();
        waitUntilElementClickable(randomProduct.webElement.findElement(relativeAddToCartButtonLocator)).click();
        return this;
    }

    public ProductDetailsPage chooseRandomProductAndClickViewButton() {
        RandomProduct randomProduct = getRandomProduct();
        String url = randomProduct.webElement.findElement(relativeViewButtonLocator).getAttribute("href");
        driver.get(url);
        return new ProductDetailsPage(driver, randomProduct.productModel);
    }

    @Builder
    @Data
    private static class RandomProduct {
        private ProductModel productModel;
        private WebElement webElement;
    }
}
