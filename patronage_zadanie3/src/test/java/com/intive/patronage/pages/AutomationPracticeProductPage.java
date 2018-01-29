package com.intive.patronage.pages;

import com.intive.patronage.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class AutomationPracticeProductPage extends DriverFactory {



    @FindBy(how = How.NAME, using = "Submit")
    private WebElement addButton;


    public AutomationPracticeProductPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void AddToCart(){
        addButton.click();

    }


}
