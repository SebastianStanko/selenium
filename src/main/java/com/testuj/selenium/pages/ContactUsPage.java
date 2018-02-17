package com.testuj.selenium.pages;

import com.testuj.selenium.configuration.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class ContactUsPage {

    @FindBy(id = "id_contact")
    private WebElement ddSubject;

    @FindBy(id = "email")
    private WebElement tfEmail;

    @FindBy(id = "id_order")
    private WebElement tfOrderRef;

    @FindBy(id = "message")
    private WebElement tfMessage;

    @FindBy(id = "submitMessage")
    private WebElement btnSend;

    @FindBy(css = ".alert.alert-success")
    private WebElement txtSuccess;

    public ContactUsPage() {
        PageFactory.initElements(Driver.getInstance(), this);
    }

    public void selectSubjectElementByIndex(int index) {
        Select selectSubject = new Select(ddSubject);
        selectSubject.selectByIndex(1);
    }

    public void typeIntoEmailTf(String email) {
        tfEmail.sendKeys(email);
    }

    public void typeIntoOrderRefTf(String password) {
        tfOrderRef.sendKeys(password);
    }

    public void typeIntoMessageTf(String password) {
        tfMessage.sendKeys(password);
    }

    public void clickOnSendBtn() {
        btnSend.click();
    }

    public String getSuccessAlertText() {
        return txtSuccess.getText();
    }
}
