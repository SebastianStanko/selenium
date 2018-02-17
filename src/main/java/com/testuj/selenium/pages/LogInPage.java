package com.testuj.selenium.pages;

import com.testuj.selenium.configuration.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LogInPage {

    @FindBy(id = "email")
    private WebElement tfEmail;

    @FindBy(id = "passwd")
    private WebElement tfPassword;

    @FindBy(id = "SubmitLogin")
    private WebElement btnSignIn;

    @FindBy(css = "ol > li")
    private WebElement txtError;

    public LogInPage() {
        PageFactory.initElements(Driver.getInstance(), this);
    }

    public void typeIntoEmailTf(String email) {
        tfEmail.sendKeys(email);
    }

    public void typeIntoPasswordTf(String password) {
        tfPassword.sendKeys(password);
    }

    public void clickOnSignInBtn() {
        btnSignIn.click();
    }

    public boolean isErrorTextDisplayed() {
        return txtError.isDisplayed();
    }
}
