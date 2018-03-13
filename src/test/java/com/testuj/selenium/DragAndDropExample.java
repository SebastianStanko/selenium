package com.testuj.selenium;

import com.testuj.selenium.configuration.Driver;
import org.junit.After;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.interactions.Actions;

public class DragAndDropExample {

    @Test(expected = NoSuchElementException.class)
    public void dragAndDropExample() {

        //given
        Driver.getInstance("http://www.dhtmlgoodies.com/submitted-scripts/i-google-like-drag-drop/");
        Actions actions = new Actions(Driver.getInstance());

        //when
        actions.dragAndDrop(
                Driver.getInstance().findElement(By.cssSelector("#column-1 > #block-1 > .draghandle")),
                Driver.getInstance().findElement(By.cssSelector("#column-2")))
                .perform();

        //then
        //this element was moved so this selector no longer exists
        //in this case we get NoSuchElementException
        //to handle it correctly in test we need to add expectation for exception
        //if exception will not occur - test will fail
        Driver.getInstance().findElement(By.cssSelector("#column-1 > #block-1 > .draghandle"));
    }

    @After
    public void cleanUp() {
        Driver.closeDriver();
    }

}
