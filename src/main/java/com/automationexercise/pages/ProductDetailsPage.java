package com.automationexercise.pages;

import com.automationexercise.models.ProductModel;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static org.assertj.core.api.Assertions.assertThat;

public class ProductDetailsPage extends BasePage {
    private final ProductModel choosenProduct;

    public ProductDetailsPage(WebDriver driver, ProductModel choosenProduct) {
        super(driver);
        this.choosenProduct = choosenProduct;
    }

    //Locators
    private final By productNameLocator = By.xpath("//div[@class='product-details']//h2");
    private final By productPriceLocator = By.xpath("//div[@class='product-details']//span/span");


    //Methods
    public ProductDetailsPage assertThatProductDetailsPageIsSuccessfullyLoaded() {
        String currentUrl = driver.getCurrentUrl();

        if (currentUrl.contains("#google_vignette")) {
            // Отримуємо чистий URL без реклами
            String cleanUrl = currentUrl.split("#")[0];

            // Кажемо браузеру: "Забудь про рекламу, йди за цією адресою"
            // Це звичайний селенівський метод переходу
            driver.get(cleanUrl);
        }

        waitUntilUrlContains("https://www.automationexercise.com/product_details/");
        return this;
    }

    public ProductDetailsPage assertThatNameAndPriceOfRandomProductCorrespond() {
        String actualProductName = waitUntilVisibilityOfElementLocated(productNameLocator).getText();
        String actualProductPrice = waitUntilVisibilityOfElementLocated(productPriceLocator).getText();

        assertThat(actualProductName).isEqualTo(choosenProduct.getName());
        assertThat(actualProductPrice).isEqualTo(choosenProduct.getPrice());
        return this;
    }
}
