package com.automationexercise.components;

import com.automationexercise.pages.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static org.assertj.core.api.Assertions.assertThat;

public class MainMenu extends BasePage {

    public MainMenu(WebDriver driver) {
        super(driver);
    }

    // Locators
    private final By homeButtonLocator = By.xpath("//a[contains(text(), 'Home')]");
    private final By productsButtonLocator = By.xpath("//a[@href='/products']");
    private final By cartButtonLocator = By.xpath("//a[@href='/view_cart' and contains(text(), 'Cart')]");
    private final By signupAndLoginButtonLocator = By.xpath("//a[@href='/login']");
    private final By testCasesButtonLocator = By.xpath("//a[@href='/test_cases']");
    private final By apiTestingButtonLocator = By.xpath("//a[@href='/api_list']");
    private final By contactUsButtonLocator = By.xpath("//a[@href='/contact_us']");
    private final By deleteButtonLocator = By.xpath("//a[@href='/delete_account']");
    private final By logoutButtonLocator = By.xpath("//a[@href='/logout']");
    private final By loggedInAsButtonLocator = By.xpath("//a[contains(text(), 'Logged in as')]");

    // Methods
    public HomePage clickHomeButton() {
        click(homeButtonLocator);
        return new HomePage(driver);
    }

    public ProductsPage clickProductsButton() {
        click(productsButtonLocator);
        return new ProductsPage(driver);
    }

    public CartPage clickCartButton() {
        click(cartButtonLocator);
        return new CartPage(driver);
    }

    public LoginPage clickSignupLoginButton() {
        click(signupAndLoginButtonLocator);
        return new LoginPage(driver);
    }

    public TestCasesPage clickTestCasesButton() {
        click(testCasesButtonLocator);
        return new TestCasesPage(driver);
    }

    public ApiTestingPage clickApiTestingButton() {
        click(apiTestingButtonLocator);
        return new ApiTestingPage(driver);
    }

    public ContactUsPage clickContactUsButton() {
        click(contactUsButtonLocator);
        return new ContactUsPage(driver);
    }

    public DeleteAccountPage clickDeleteAccountButton() {
        WebElement button = waitUntilElementClickable(deleteButtonLocator);
        removeAds(); // Обов'язково чистимо рекламу перед кліком

        // Використовуємо JS клік, щоб пробити рекламний шар
        ((org.openqa.selenium.JavascriptExecutor) driver).executeScript("arguments[0].click();", button);

        return new DeleteAccountPage(driver);
    }

    public LoginPage clickLogoutButton() {
        click(logoutButtonLocator);
        return new LoginPage(driver);
    }

    public MainMenu assertUserNameIsDisplayed(String expectedName) {
        String actualName = waitUntilVisibilityOfElementLocated(loggedInAsButtonLocator).getText();
        assertThat(actualName).isEqualTo(expectedName);
        return this;
    }

    public MainMenu assertUserNameIsNotDisplayed() {
        boolean isInvisible = waitUntilInvisibilityOfElementLocated(loggedInAsButtonLocator);
        assertThat(isInvisible).isTrue();
        return this;
    }
}