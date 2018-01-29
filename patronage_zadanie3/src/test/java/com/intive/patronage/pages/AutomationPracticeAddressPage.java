package com.intive.patronage.pages;

import com.intive.patronage.DriverFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class AutomationPracticeAddressPage extends DriverFactory {

    @FindBy(how= How.NAME, using = "processCarrier")
    public WebElement proceedToCheckout;

    @FindBy(how= How.ID, using = "order")
    public WebElement addressPage;

    WebDriver driver;
    AutomationPracticeShippingPage shippingPage;

    public AutomationPracticeAddressPage(WebDriver driver){
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public AutomationPracticeShippingPage getShippingPage() {
        proceedToCheckout.click();
        return shippingPage = new AutomationPracticeShippingPage(driver);
    }

    public void VerifyIfAddressPageIsDisplayed(){
    assert(addressPage.isDisplayed());
    }
}
