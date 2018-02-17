package com.testuj.selenium.pages;

import com.testuj.selenium.configuration.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

    @FindBy(css = "img[class='logo img-responsive']")
    public WebElement imgLogo;

    @FindBy(className = "login")
    public WebElement btnSignIn;

    @FindBy(css = "#contact-link > a")
    public WebElement btnContactUs;

    public HomePage() {
        PageFactory.initElements(Driver.getInstance(), this);
    }

}
