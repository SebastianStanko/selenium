package com.testuj.selenium;

import com.testuj.selenium.configuration.Driver;
import org.junit.After;
import org.junit.Before;

public class BaseTest {

    @Before
    public void setUp() {
        Driver.getInstance();
    }

    @After
    public void cleanUp() {
        Driver.closeDriver();
    }

}
