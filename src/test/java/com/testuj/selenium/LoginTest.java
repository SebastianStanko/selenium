package com.testuj.selenium;

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

    private WebDriver webDriver;

    @Before
    public void setUp() {
        webDriver = Driver.setUpDriver();
    }

    @Test
    public void asNotRegisteredCustomerIShouldntLogin() {
        //given
        String email = "test@email.com";
        String password = "Password123";
        By firstBtnSignInSelector = By.className("login");
        String tfEmailSelector = "email";
        String tfPasswordSelector = "passwd";
        String secondBtnSignInSelector = "SubmitLogin";
        String txtErrorSelector = "ol > li";
        WebElement btnSignIn = webDriver.findElement(firstBtnSignInSelector);
        btnSignIn.click();
        WebElement tfEmail = webDriver.findElement(By.id(tfEmailSelector));
        WebElement tfPassword = webDriver.findElement(By.id(tfPasswordSelector));
        WebElement btnSignIn2 = webDriver.findElement(By.id(secondBtnSignInSelector));
        tfEmail.sendKeys(email);
        tfPassword.sendKeys(password);

        //when
        btnSignIn2.click();
        WebElement txtError = webDriver.findElement(By.cssSelector(txtErrorSelector));

        //then
        assertEquals(true, txtError.isDisplayed());
    }

    @Test
    public void asCustomerIShallSendContactMessage() {

        //given
        WebElement btnContactUs = webDriver.findElement(By.cssSelector("#contact-link > a"));
        btnContactUs.click();
        List<WebElement> option = webDriver.findElements(By.cssSelector("option"));
        WebElement ddSelect = webDriver.findElement(By.id("id_contact"));
        Select selectSubject = new Select(ddSelect);
        WebElement tfEmail = webDriver.findElement(By.id("email"));
        WebElement tfOrderRef = webDriver.findElement(By.id("id_order"));
        WebElement tfMessage = webDriver.findElement(By.id("message"));
        WebElement btnSend = webDriver.findElement(By.id("submitMessage"));

        selectSubject.selectByIndex(1);
        tfEmail.sendKeys("test@email.com");
        tfOrderRef.sendKeys("Order reference");
        tfMessage.sendKeys("Message");

        //when
        btnSend.click();
        WebElement txtSuccess = webDriver.findElement(By.cssSelector(".alert.alert-success"));

        //then
        assertEquals("Your message has been successfully sent to our team.", txtSuccess.getText());
    }

    @After
    public void cleanUp() {
        webDriver.close();
    }

}
