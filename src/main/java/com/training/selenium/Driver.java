package com.training.selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;

public class Driver {

  private static WebDriver driver;
  private static final String APP_URL = "http://automationpractice.com";

  public static WebDriver getInstance() {
    if (driver == null) {
      driver = setUpDriver();
    }
    return driver;
  }

  private static WebDriver setUpDriver() {
    ClassLoader classLoader = Driver.class.getClassLoader();
    File driverPath = new File(classLoader.getResource("chromedriver.exe").getFile());
    System.setProperty("webdriver.chrome.driver", String.valueOf(driverPath));

    WebDriver chromeDriver = new ChromeDriver();
    chromeDriver.manage().window().maximize();
    chromeDriver.navigate().to(APP_URL);
    return chromeDriver;
  }

  public static void closeDriver() {
    driver.manage().getCookies().clear();
    driver.close();
    driver.quit();
    driver = null;
  }

}
