package com.testuj.selenium;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.assertEquals;

public class BaseTest {

    private WebDriver webDriver;

    @Before
    public void setUp() {
        webDriver = Driver.setUpDriver();
    }

    @Test
    public void asUserIShouldSeeLogoImage() {

        //given
        WebElement element = webDriver.findElement(By.cssSelector("img[class='logo img-responsive']"));

        //when
        boolean actualResult = element.isDisplayed();

        //then
        assertEquals(true, actualResult);
    }

    @After
    public void cleanUp() {
        webDriver.close();
    }

}
