package com.testuj.selenium.pages;

import com.testuj.selenium.configuration.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactUsPage {

    @FindBy(id = "id_contact")
    public WebElement ddSubject;

    @FindBy(id = "email")
    public WebElement tfEmail;

    @FindBy(id = "id_order")
    public WebElement tfOrderRef;

    @FindBy(id = "message")
    public WebElement tfMessage;

    @FindBy(id = "submitMessage")
    public WebElement btnSend;

    @FindBy(css = ".alert.alert-success")
    public WebElement txtSuccess;

    public ContactUsPage() {
        PageFactory.initElements(Driver.getInstance(), this);
    }
}
