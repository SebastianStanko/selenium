package com.testuj.selenium.configuration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class Driver {

    private static WebDriver driver;
    public static String NODE = "http://192.168.4.126:4444/wd/hub";

    public static WebDriver getInstance(String... urlToNavigate) {
        if(driver == null) {
            driver = urlToNavigate.length == 0 ? setUpDriver() : setUpDriver(urlToNavigate[0]);
        }
        return driver;
    }

    public static void closeDriver() {
        driver.manage().getCookies().clear();
        driver.close();
        driver.quit();
        driver = null;
    }

    private static WebDriver setUpDriver(String... urlToNavigate) {
//        DesiredCapabilities capabilities = DesiredCapabilities.chrome();

        ClassLoader classLoader = Driver.class.getClassLoader();
        File driverPath = new File(classLoader.getResource("chromedriver.exe").getFile());
        System.setProperty("webdriver.chrome.driver", String.valueOf(driverPath));
        driver = new ChromeDriver();

        /*try {
            driver = new RemoteWebDriver(new URL(NODE), capabilities);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }*/
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        String url = urlToNavigate.length == 0 ? "http://automationpractice.com" : urlToNavigate[0];
        driver.navigate().to(url);
        return driver;
    }

}
