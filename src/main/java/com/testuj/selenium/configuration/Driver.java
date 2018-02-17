package com.testuj.selenium.configuration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;

public class Driver {

    private static WebDriver driver;

    public static WebDriver getInstance() {
        if(driver == null) {
            driver = setUpDriver();
        }
        return driver;
    }

    public static void closeDriver() {
        driver.manage().getCookies().clear();
        driver.close();
        driver.quit();
        driver = null;
    }

    private static WebDriver setUpDriver() {
        ClassLoader classLoader = Driver.class.getClassLoader();
        File driverPath = new File(classLoader.getResource("chromedriver.exe").getFile());
        System.setProperty("webdriver.chrome.driver", String.valueOf(driverPath));

        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.navigate().to("http://automationpractice.com");
        return driver;
    }

}
