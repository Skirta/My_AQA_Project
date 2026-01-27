package com.automationexercise.pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ContactUsPage extends BasePage {

    public ContactUsPage(WebDriver driver) {
        super(driver);
    }

    private final String pathToFile = System.getProperty("user.dir") + "/src/test/resources/files/invoice.txt";

    //Locators
    private final By getInTouchTextLocator = By.xpath("//h2[text()='Get In Touch']");
    private final By inputNameLocator = By.xpath("//input[@data-qa='name']");
    private final By inputEmailLocator = By.xpath("//input[@data-qa='email']");
    private final By inputSubjectLocator = By.xpath("//input[@data-qa='subject']");
    private final By inputMessageLocator = By.xpath("//textarea[@data-qa='message']");
    private final By chooseFileButtonLocator = By.xpath("//input[@name='upload_file']");
    private final By submitButtonLocator = By.xpath("//input[@data-qa='submit-button']");
    private final By successDownloadTextLocator = By.xpath("//div[@class='status alert alert-success' and text()='Success! Your details have been submitted successfully.']");
    private final By homeButtonLocator = By.xpath("//a[@class='btn btn-success']");

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

    public ContactUsPage uploadFile(){
        type(chooseFileButtonLocator, pathToFile);
        return this;
    }

    public ContactUsPage clickSubmitButton() {
        click(submitButtonLocator);
        return this;
    }

    public ContactUsPage assertMessageAboutSuccessDownloadIsPresent() {
        waitUntilVisibilityOfElementLocated(successDownloadTextLocator);
        return this;
    }

    public HomePage clickHomeButton() {
        click(homeButtonLocator);
        return new HomePage(driver);
    }
}