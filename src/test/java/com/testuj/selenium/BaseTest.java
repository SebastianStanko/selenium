package com.testuj.selenium;

import com.testuj.selenium.configuration.Driver;
import com.testuj.selenium.pages.HomePage;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static org.junit.Assert.assertEquals;

public class BaseTest {

    private HomePage homePage;

    @Before
    public void setUp() {
        Driver.getInstance();
    }

    @Test
    public void asUserIShouldSeeLogoImage() {

        //given
        homePage = new HomePage();

        //when
        boolean actualResult = homePage.imgLogo.isDisplayed();

        //then
        assertEquals(true, actualResult);
    }

    @After
    public void cleanUp() {
        Driver.closeDriver();
    }

}
