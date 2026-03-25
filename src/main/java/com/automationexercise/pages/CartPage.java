package com.automationexercise.pages;

import com.automationexercise.components.CheckoutModal;
import com.automationexercise.helpers.SecretManager;
import com.automationexercise.models.ProductModel;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class CartPage extends BasePage {

    private final List<ProductModel> productsList;

    public CartPage(WebDriver driver, List<ProductModel> productsList) {
        super(driver);
        this.productsList = productsList;
    }

    public CartPage(WebDriver driver) {
        super(driver);
        this.productsList = new ArrayList<>();
    }

    //Locators
    private final By shoppingCartTextLocator = By.xpath("//li[text()='Shopping Cart']");
    private final By relativeProductNameLocator = By.xpath("./td[@class='cart_description']//a");
    private final By relativeProductPriceLocator = By.xpath("./td[@class='cart_price']/p");
    private final By relativeProductQuantityLocator = By.xpath("./td[@class='cart_quantity']/button");
    private final By relativeProductTotalPriceLocator = By.xpath("./td[@class='cart_total']/p");
    private final By productsLocator = By.xpath("//tr[contains(@id,'product-')]");
    private final By quantityLocator = By.xpath("//td[@class='cart_quantity']/button");
    private final By proceedToCheckoutButtonLocator = By.xpath("//a[contains(text(), 'Proceed To Checkout')]");


    //Methods
    public CartPage assertCartPageIsSuccessfullyLoaded() {
        waitUntilVisibilityOfElementLocated(shoppingCartTextLocator);
        waitUntilUrlToBe(SecretManager.get("BASE_URL") + "view_cart");
        waitUntilVisibilityOfElementLocated(productsLocator);
        return this;
    }

    public CartPage assertAllProductAddedToCart() {
        removeAds();
        for (int i = 0; i < productsList.size(); i++) {
            ProductModel expectedResult = productsList.get(i);
            By productRowLocator = By.xpath("//tr[@id='product-" + expectedResult.getId() + "']");
            WebElement productRow = waitUntilVisibilityOfElementLocated(productRowLocator);
            String actualName = productRow.findElement(relativeProductNameLocator).getText();
            String actualPrice = productRow.findElement(relativeProductPriceLocator).getText();
            String actualQuantity = productRow.findElement(relativeProductQuantityLocator).getText();
            String actualTotalPrice = productRow.findElement(relativeProductTotalPriceLocator).getText();
            assertThat(actualName)
                    .as("Name verification")
                    .isEqualTo(expectedResult.getName());
            assertThat(actualPrice)
                    .as("Price verification")
                    .isEqualTo(expectedResult.getPrice());
            assertThat(actualQuantity)
                    .as("Quantity verification")
                    .isEqualTo("1");
            assertThat(actualTotalPrice)
                    .as("Total Price verification")
                    .isEqualTo(expectedResult.getPrice());
        }
        return this;
    }

    public CartPage assertCorrectQuantity(String quantity) {
        String actualQuantity = waitUntilVisibilityOfElementLocated(quantityLocator).getText();
        assertThat(actualQuantity)
                .as("Quantity verification")
                .isEqualTo(quantity);
        return this;
    }

    public CheckoutModal clickProceedToCheckoutAsGuest() {
        click(proceedToCheckoutButtonLocator);
        return new CheckoutModal(driver);
    }
}