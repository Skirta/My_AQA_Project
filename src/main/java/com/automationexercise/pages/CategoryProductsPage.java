package com.automationexercise.pages;

import com.automationexercise.helpers.SecretManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static org.assertj.core.api.Assertions.assertThat;

public class CategoryProductsPage extends BasePage {
    public CategoryProductsPage(WebDriver driver) {
        super(driver);
    }

    //Locators;
    private final By nameOfCategoryLocator = By.xpath("//div[@class='features_items']/h2");
    private final By menCategoryLocator = By.xpath("//div[@class='left-sidebar']//a[@href='#Men']");
    private final By jeansLinkInMenCategoryLocator = By.xpath("//div[@id='Men']//a[contains(text(), 'Jeans')]");

    //Methods
    public CategoryProductsPage assertCategoryProductsPageIsSuccessfullyLoaded() {
        waitUntilUrlContains(SecretManager.get("BASE_URL") + "category_products");
        return this;
    }

    public CategoryProductsPage clickOnMenCategory() {
        click(menCategoryLocator);
        return this;
    }

    public CategoryProductsPage clickOnJeansInMenCategory() {
        click(jeansLinkInMenCategoryLocator);
        return this;
    }

    public CategoryProductsPage verifyProductsTitleTextIs(String titleText) {
        String actualNameOfCategory = waitUntilVisibilityOfElementLocated(nameOfCategoryLocator).getText().replaceAll("\\s+", " ").trim();
        assertThat(actualNameOfCategory)
                .as("Category text verification")
                .isEqualTo(titleText);
        return this;
    }
}