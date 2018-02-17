package com.testuj.selenium;

import com.testuj.selenium.pages.HomePage;
import org.junit.Test;
import org.openqa.selenium.support.ui.Select;

import static org.junit.Assert.assertEquals;

public class ContactUsPage extends BaseTest {

    private HomePage homePage;

    @Test
    public void asCustomerIShallSendContactMessage() {

        //given
        homePage = new HomePage();
        homePage.btnContactUs.click();
        com.testuj.selenium.pages.ContactUsPage contactUsPage = new com.testuj.selenium.pages.ContactUsPage();
        Select selectSubject = new Select(contactUsPage.ddSubject);
        selectSubject.selectByIndex(1);
        contactUsPage.tfEmail.sendKeys("test@email.com");
        contactUsPage.tfOrderRef.sendKeys("Order reference");
        contactUsPage.tfMessage.sendKeys("Message");

        //when
        contactUsPage.btnSend.click();

        //then
        assertEquals("Your message has been successfully sent to our team.", contactUsPage.txtSuccess.getText());
    }

}
