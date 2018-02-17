package com.testuj.selenium.pages;

import com.testuj.selenium.configuration.Driver;
import com.testuj.selenium.configuration.Waits;
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
        Waits.implicitlyWait(2);
        PageFactory.initElements(Driver.getInstance(), this);
    }

    public ContactUsPage selectSubjectElementByIndex(int index) {
        Select selectSubject = new Select(ddSubject);
        selectSubject.selectByIndex(1);
        return this;
    }

    public ContactUsPage typeIntoEmailTf(String email) {
        tfEmail.sendKeys(email);
        return this;
    }

    public ContactUsPage typeIntoOrderRefTf(String password) {
        tfOrderRef.sendKeys(password);
        return this;
    }

    public ContactUsPage typeIntoMessageTf(String password) {
        tfMessage.sendKeys(password);
        return this;
    }

    public ContactUsPage clickOnSendBtn() {
        btnSend.click();
        return this;
    }

    public String getSuccessAlertText() {
        Waits.waitForElementToBeVisible(txtSuccess);
        return txtSuccess.getText();
    }
}
