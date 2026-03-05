package com.automationexercise.tests.contactUs;

import com.automationexercise.helpers.DataRandomizer;
import com.automationexercise.pages.ContactUsPage;
import com.automationexercise.pages.HomePage;
import com.automationexercise.tests.BaseTest;
import org.testng.annotations.Test;

public class ContactUsTests extends BaseTest {

    @Test(description = "Test Case 6: Contact Us Form")
    public void shouldSubmitContactUsFormSuccessfully() {

        new HomePage(driver)
                .openHomePage()
                .assertHomePageIsSuccessfullyLoaded();

        mainMenu
                .clickContactUsButton()
                .assertGetInTouchTextIsVisible()
                .setEmail(DataRandomizer.getRandomEmail())
                .setName(DataRandomizer.getRandomFirstName())
                .setSubject(DataRandomizer.getRandomSubject())
                .setMessage(DataRandomizer.getRandomMessage())
                .uploadFile()
                .clickSubmitButton()
                .clickAcceptButtonInAlert();

        new ContactUsPage(driver)
                .assertMessageAboutSuccessDownloadIsPresent()
                .clickHomeButton();

        new HomePage(driver)
                .assertHomePageIsSuccessfullyLoaded();
    }
}