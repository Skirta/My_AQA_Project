package com.automationexercise.pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage{

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    //Locators
    private final By inputNewUserNameLocator = By.xpath("//input[@data-qa='signup-name']");
    private final By inputNewUserEmailLocator = By.xpath("//input[@data-qa='signup-email']");
    private final By signupButtonLocator = By.xpath("//button[@data-qa='signup-button']");
    private final By newUserSignupTextLocator = By.xpath("//h2[text()='New User Signup!']");
    private final By loginToYourAccountTextLocator = By.xpath("//h2[text()='Login to your account']");

    //Mothods
    public LoginPage setName(String name) {
        type(inputNewUserNameLocator, name);
        return this;
    }

    public LoginPage setEmail(String email) {
        type(inputNewUserEmailLocator, email);
        return this;
    }

    public LoginPage assertNewUserSignupTextsVisible() {
        waitUntilVisibilityOfElementLocated(newUserSignupTextLocator);
        return this;
    }

    public LoginPage assertLoginToYourAccountTextIsVisible() {
        waitUntilVisibilityOfElementLocated(loginToYourAccountTextLocator);
        return this;
    }

    public CreateAccountPage clickSignupButton() {
        click(signupButtonLocator);
        return new CreateAccountPage(driver);
    }


}