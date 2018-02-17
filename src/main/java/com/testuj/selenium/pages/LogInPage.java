package com.testuj.selenium.pages;

import com.testuj.selenium.configuration.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LogInPage {

    @FindBy(id = "email")
    public WebElement tfEmail;

    @FindBy(id = "passwd")
    public WebElement tfPassword;

    @FindBy(id = "SubmitLogin")
    public WebElement btnSignIn;

    @FindBy(css = "ol > li")
    public WebElement txtError;

    public LogInPage() {
        PageFactory.initElements(Driver.getInstance(), this);
    }
}
