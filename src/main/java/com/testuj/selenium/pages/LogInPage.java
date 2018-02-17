package com.testuj.selenium.pages;

import com.testuj.selenium.configuration.Driver;
import com.testuj.selenium.configuration.Waits;
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

    public LogInPage typeIntoEmailTf(String email) {
        tfEmail.sendKeys(email);
        return this;
    }

    public LogInPage typeIntoPasswordTf(String password) {
        tfPassword.sendKeys(password);
        return this;
    }

    //Return shall initialize new page always
    public HomePage clickOnSignInBtn() {
        btnSignIn.click();
        return new HomePage();
    }

    public boolean isErrorTextDisplayed() {
        Waits.fluentWaitForVisiblityOfElement(txtError);
        return txtError.isDisplayed();
    }
}
