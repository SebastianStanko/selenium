package com.testuj.selenium;

import com.testuj.selenium.configuration.Driver;
import com.testuj.selenium.pages.ContactUsPage;
import com.testuj.selenium.pages.HomePage;
import com.testuj.selenium.pages.LogInPage;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class LoginTest {

    private HomePage homePage;

    @Before
    public void setUp() {
        Driver.getInstance();
    }

    @Test
    public void asNotRegisteredCustomerIShouldntLogin() {
        //given
        homePage = new HomePage();
        String email = "test@email.com";
        String password = "Password123";
        homePage.btnSignIn.click();
        LogInPage logInPage = new LogInPage();
        logInPage.tfEmail.sendKeys(email);
        logInPage.tfPassword.sendKeys(password);

        //when
        logInPage.btnSignIn.click();

        //then
        assertEquals(true, logInPage.txtError.isDisplayed());
    }

    @Test
    public void asCustomerIShallSendContactMessage() {

        //given
        homePage = new HomePage();
        homePage.btnContactUs.click();
        ContactUsPage contactUsPage = new ContactUsPage();
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

    @After
    public void cleanUp() {
        Driver.closeDriver();
    }

}
