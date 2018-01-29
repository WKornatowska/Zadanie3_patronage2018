package com.intive.patronage.pages;

import com.intive.patronage.DriverFactory;
import cucumber.runtime.io.Helpers;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AutomationPracticeShoppingCartSummary extends DriverFactory {
    WebDriver driver;
    AutomationPracticeAddressPage addressPage;

    @FindBy(how= How.ID, using="order")
    private WebElement order;
    @FindBy(how=How.LINK_TEXT, using = "Proceed to checkout")
    public WebElement proceed_to_checkout;

    public AutomationPracticeShoppingCartSummary(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }
    public AutomationPracticeAddressPage getAddressPage(){
        proceed_to_checkout.click();
        return addressPage =new AutomationPracticeAddressPage(driver);
    }
    public void VerifyIfShoppingCartSummaryisDisplayed() throws InterruptedException{
        assert(order.isDisplayed());
    }


}
