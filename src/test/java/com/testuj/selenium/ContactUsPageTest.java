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
        ContactUsPage contactUsPage = homePage.clickOnContactUsBtn()
                .selectSubjectElementByIndex(1)
                .typeIntoEmailTf("test@email.com")
                .typeIntoOrderRefTf("Order reference")
                .typeIntoMessageTf("Message")

                //when
                .clickOnSendBtn();

        //then
        assertEquals("Your message has been successfully sent to our team.", contactUsPage.getSuccessAlertText());
    }

}
