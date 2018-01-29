package com.intive.patronage.pages;

import com.intive.patronage.DriverFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class AutomationPracticeOrderConfirmationPage extends DriverFactory {
    WebDriver driver;

    @FindBy(how = How.CLASS_NAME, using = "alert alert-success")
    WebElement confirmation;

    public AutomationPracticeOrderConfirmationPage(WebDriver driver){
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void VerifyIfConfirmationMessageIsDisplayed(){
        assert(confirmation.isDisplayed());
    }
}
