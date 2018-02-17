package com.testuj.selenium.configuration;

import org.awaitility.Awaitility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertEquals;

public class Waits {

    public static void implicitlyWait(int numberOfSeconds) {
        Driver.getInstance().manage().timeouts().implicitlyWait(numberOfSeconds, TimeUnit.SECONDS);
    }

    public static void waitForElementToBeVisible(WebElement element) {
        WebDriverWait webDriverWait = new WebDriverWait(Driver.getInstance(), 10);
        webDriverWait.until(ExpectedConditions.visibilityOf(element));
    }

    public static void fluentWaitForVisiblityOfElement(WebElement element) {
        Awaitility.with().await()
                .pollInterval(1, TimeUnit.SECONDS)
                .atMost(15, TimeUnit.SECONDS)
                .ignoreException(NullPointerException.class)
                .ignoreException(NoSuchElementException.class)
                .until(() -> assertEquals(true, element.isDisplayed()));
    }

}
