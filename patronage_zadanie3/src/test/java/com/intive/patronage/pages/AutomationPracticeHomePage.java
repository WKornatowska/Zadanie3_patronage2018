package com.intive.patronage.pages;

import com.intive.patronage.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;


public class AutomationPracticeHomePage extends DriverFactory {

    WebDriver driver;
    AutomationPracticeAuthenticationPage authenticationPage;
    AutomationPracticeProductPage productPage;
    AutomationPracticeShoppingCartSummary shoppingCartSummary;

    @FindBy(how = How.LINK_TEXT, using = "Sign out")
    public  WebElement signOut;
    @FindBy(how = How.ID, using = "Login")
    public WebElement signIn;

    public AutomationPracticeHomePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);

    }
    public AutomationPracticeShoppingCartSummary getShoppingCartSummary() {
        driver.findElement(By.linkText("Sign in")).click();
        return shoppingCartSummary = new AutomationPracticeShoppingCartSummary(driver);
    }

    public AutomationPracticeProductPage getProductPage() {
        driver.findElement(By.className("product-container")).click();
        return productPage = new AutomationPracticeProductPage(driver);
    }

    public AutomationPracticeAuthenticationPage getAuthenticationPage() {
        driver.findElement(By.className("login")).click();
        return authenticationPage = new AutomationPracticeAuthenticationPage(driver);

    }

    public void SignOut() {
        signOut.click();
    }


}
