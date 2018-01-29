package com.intive.patronage.pages;

import com.intive.patronage.DriverFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class AutomationPracticeShippingPage extends DriverFactory {
    @FindBy(how = How.ID, using = "cgv")
    private WebElement acceptCheckBox;
    @FindBy(how = How.NAME, using = "proecessCarrier")
    private WebElement proceedToCheckout;
    @FindBy(how= How.ID, using = "order")
    public WebElement shipping;
    WebDriver driver;
    AutomationPracticePaymentPage PaymentPage;

    public AutomationPracticeShippingPage(WebDriver driver){
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public AutomationPracticePaymentPage getPaymentPage(){
        proceedToCheckout.click();
        return PaymentPage =new AutomationPracticePaymentPage(driver);
    }

    public void Agree(){
        acceptCheckBox.click();
    }
    public void VerifyIfShippingPageIsDisplayed(){
        assert(shipping.isDisplayed());
    }

}
