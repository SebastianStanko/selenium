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

public class LoginTest extends BaseTest {

    private HomePage homePage;

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

}
