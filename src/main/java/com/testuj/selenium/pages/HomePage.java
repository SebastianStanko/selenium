package com.testuj.selenium.pages;

import com.testuj.selenium.configuration.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

    @FindBy(css = "img[class='logo img-responsive']")
    private WebElement imgLogo;

    @FindBy(className = "login")
    private WebElement btnSignIn;

    @FindBy(css = "#contact-link > a")
    private WebElement btnContactUs;

    public HomePage() {
        PageFactory.initElements(Driver.getInstance(), this);
    }

    public boolean isLogoImageDisplayed() {
        return imgLogo.isDisplayed();
    }

    public LogInPage clickOnSignInBtn() {
        btnSignIn.click();
        return new LogInPage();
    }

    public ContactUsPage clickOnContactUsBtn() {
        btnContactUs.click();
        return new ContactUsPage();
    }

}
