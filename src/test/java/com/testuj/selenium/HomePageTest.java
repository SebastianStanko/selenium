package com.testuj.selenium;

import com.testuj.selenium.pages.HomePage;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class HomePageTest extends BaseTest {

    private HomePage homePage;

    @Test
    public void asUserIShouldSeeLogoImage() {

        //given
        homePage = new HomePage();

        //when
        boolean actualResult = homePage.isLogoImageDisplayed();

        //then
        assertEquals(true, actualResult);
    }

}
