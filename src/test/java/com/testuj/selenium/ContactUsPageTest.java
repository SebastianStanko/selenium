package com.testuj.selenium;

import com.testuj.selenium.pages.ContactUsPage;
import com.testuj.selenium.pages.HomePage;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ContactUsPageTest extends BaseTest {

    private HomePage homePage;

    @Test
    public void asCustomerIShallSendContactMessage() {

        //given
        homePage = new HomePage();
        homePage.clickOnContactUsBtn();
        ContactUsPage contactUsPage = new ContactUsPage();
        contactUsPage.selectSubjectElementByIndex(1);
        contactUsPage.typeIntoEmailTf("test@email.com");
        contactUsPage.typeIntoOrderRefTf("Order reference");
        contactUsPage.typeIntoMessageTf("Message");

        //when
        contactUsPage.clickOnSendBtn();

        //then
        assertEquals("Your message has been successfully sent to our team.", contactUsPage.getSuccessAlertText());
    }

}
