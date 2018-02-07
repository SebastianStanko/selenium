package com.training.selenium.page;

import com.training.selenium.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.springframework.stereotype.Component;

@Component
public class HomePage {

  @FindBy(css = "a[title='Women']")
  public WebElement womenBtn;

  public HomePage() {
    PageFactory.initElements(Driver.getInstance(), this);
  }


}
