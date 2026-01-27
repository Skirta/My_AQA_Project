package com.automationexercise.pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ContactUsPage extends BasePage {

    public ContactUsPage(WebDriver driver) {
        super(driver);
    }

    //Locators
    private final By getInTouchTextLocator = By.xpath("//h2[text()='Get In Touch']");
    private final By inputNameLocator = By.xpath("//input[@data-qa='name']");
    private final By inputEmailLocator = By.xpath("//input[@data-qa='email']");
    private final By inputSubjectLocator = By.xpath("//input[@data-qa='subject']");
    private final By inputMessageLocator = By.xpath("//textarea[@data-qa='message']");


    //Mehtods
    public ContactUsPage assertGetInTouchTextIsVisible() {
        waitUntilVisibilityOfElementLocated(getInTouchTextLocator);
        return this;
    }

    public ContactUsPage setName(String name) {
        type(inputNameLocator, name);
        return this;
    }

    public ContactUsPage setEmail(String email) {
        type(inputEmailLocator, email);
        return this;
    }

    public ContactUsPage setSubject(String subject) {
        type(inputSubjectLocator, subject);
        return this;
    }

    public ContactUsPage setMessage(String message) {
        type(inputMessageLocator, message);
        return this;
    }

}