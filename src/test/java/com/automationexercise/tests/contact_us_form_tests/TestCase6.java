package com.automationexercise.tests.contact_us_form_tests;

import com.automationexercise.helpers.DataRandomizer;
import com.automationexercise.pages.ContactUsPage;
import com.automationexercise.pages.HomePage;
import com.automationexercise.tests.BaseTest;
import org.testng.annotations.Test;

public class TestCase6 extends BaseTest {

    @Test
    public void testCase6() {

        new HomePage(driver)
                .openHomePage()
                .clickConsentButton()
                .assertHomePageIsSuccessfullyLoaded();

        mainMenu
                .clickContactUsButton();

        new ContactUsPage(driver)
                .assertGetInTouchTextIsVisible()
                .setEmail(DataRandomizer.getRandomEmail())
                .setName(DataRandomizer.getRandomFirstName())
                .setSubject(DataRandomizer.getRandomSubject())
                .setMessage(DataRandomizer.getRandomMessage());

    }
}
