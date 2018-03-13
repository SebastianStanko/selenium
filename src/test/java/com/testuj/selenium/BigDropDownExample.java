package com.testuj.selenium;

import com.testuj.selenium.configuration.Driver;
import org.junit.After;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static org.junit.Assert.assertEquals;

public class BigDropDownExample {

    @Test
    public void bigDropDownWithoutSelectTab() {

        //given
        Driver.getInstance("https://www.otomoto.pl/osobowe");
        WebElement carBrand = Driver.getInstance().findElement(By.id("select2-param571-container"));
        carBrand.click();
        //css li[id*='ferrari'] id attribute contains word ferrari
        WebElement ferrariOption = Driver.getInstance().findElement(By.cssSelector("li[id*='ferrari']"));

        //when
        //Selenium doesn't have to scroll to element
        ferrariOption.click();

        //then
        assertEquals("Ferrari", carBrand.getText());
    }

    @After
    public void cleanUp() {
        Driver.closeDriver();
    }

}
