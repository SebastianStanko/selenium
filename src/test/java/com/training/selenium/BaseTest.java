package com.training.selenium;

import com.training.selenium.page.HomePage;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
public class BaseTest {

  private WebDriver instance;

  @Autowired
  private HomePage homePage;

  @Before
  public void setUp() {
    instance = Driver.getInstance();
  }

  @Test
  public void test() {
    homePage.womenBtn.click();
  }

  @After
  public void disposeDriver() {
    Driver.closeDriver();
  }

}
