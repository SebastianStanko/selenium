package com.testuj.selenium.configuration;

import com.google.common.base.Function;
import org.awaitility.Awaitility;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

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

    public static WebElement fluentWaitForVisibilityOfElement(String selector) {
        Wait<WebDriver> wait = new FluentWait<>(Driver.getInstance())
                .withTimeout(30, TimeUnit.SECONDS)
                .pollingEvery(5, TimeUnit.SECONDS)
                .ignoring(NoSuchElementException.class);

        return wait.until(new Function<WebDriver, WebElement>() {
            public WebElement apply(WebDriver driver) {
                return driver.findElement(By.cssSelector(selector));
            }
        });
    }

    public static void awaitilityWaitForVisiblityOfElement(WebElement element) {
        Awaitility.with().await()
                .pollInterval(1, TimeUnit.SECONDS)
                .atMost(15, TimeUnit.SECONDS)
                .ignoreException(NullPointerException.class)
                .ignoreException(NoSuchElementException.class)
                .until(() -> assertEquals(true, element.isDisplayed()));
    }

}
