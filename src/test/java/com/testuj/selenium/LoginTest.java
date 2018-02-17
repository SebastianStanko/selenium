package com.testuj.selenium;

import com.testuj.selenium.pages.HomePage;
import com.testuj.selenium.pages.LogInPage;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class LoginTest extends BaseTest {

    private HomePage homePage;

    @Test
    public void asNotRegisteredCustomerIShouldntLogin() {
        //given
        homePage = new HomePage();
        String email = "test@email.com";
        String password = "Password123";
        homePage.clickOnSignInBtn()
                .typeIntoEmailTf(email)
                .typeIntoPasswordTf(password)

                //when
                .clickOnSignInBtn();
        LogInPage logInPage = new LogInPage();

        //then
        assertEquals(true, logInPage.isErrorTextDisplayed());
    }

}
