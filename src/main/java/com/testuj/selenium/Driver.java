package com.testuj.selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;

public class Driver {

    public static WebDriver setUpDriver() {
        ClassLoader classLoader = Driver.class.getClassLoader();
        File driverPath = new File(classLoader.getResource("chromedriver.exe").getFile());
        System.setProperty("webdriver.chrome.driver", String.valueOf(driverPath));

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.navigate().to("http://automationpractice.com");
        return driver;
    }

}
