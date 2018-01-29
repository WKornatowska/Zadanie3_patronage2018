package com.intive.patronage.pages;

import com.intive.patronage.DriverFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class AutomationPracticePaymentPage extends DriverFactory{

    WebDriver driver;
    AutomationPracticeOrderConfirmationPage orderConfirmationPage;
    @FindBy(how= How.ID, using = "order")
    public WebElement paymentPage;
    @FindBy(how = How.CLASS_NAME, using = "cheque")
    WebElement pay;
    @FindBy(how=How.LINK_TEXT, using = "I confirm my order")
    WebElement confirmation;

    public AutomationPracticePaymentPage(WebDriver driver){
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public AutomationPracticeOrderConfirmationPage getOrderConfirmationPage() {
        confirmation.click();
        return orderConfirmationPage = new AutomationPracticeOrderConfirmationPage(driver);
    }

   public void Payment(){
        pay.click();
   }
    public void VerifyIfPaymentPageIsDisplayed(){
        assert(paymentPage.isDisplayed());
    }


}
