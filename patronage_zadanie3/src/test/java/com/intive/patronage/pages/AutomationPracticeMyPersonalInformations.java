package com.intive.patronage.pages;


import com.intive.patronage.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class AutomationPracticeMyPersonalInformations extends DriverFactory{

    WebDriver driver;

    @FindBy(how= How.ID, using="identity")
    private WebElement myPersonalInformationsWebPart;

    @FindBy(how=How.ID, using = "firstname")
    private WebElement firstNameField;

    @FindBy(how=How.ID, using = "lastname")
    private WebElement lastNameField;

    @FindBy(how = How.ID, using = "")
    private WebElement emailField;



    public AutomationPracticeMyPersonalInformations(WebDriver driver){
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void VerifyIfMyPersonalInformationsPageisDisplayed() throws  InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Your personal information")));
        //assert(myPersonalInformationsWebPart.isDisplayed());}
    }
    public void VerifyFirstNameField(String name)throws InterruptedException {
        boolean foundMatch=false;
        WebElement element=driver.findElement(By.xpath("//*[@id=\"firstname\"]"));
        String val=element.getAttribute("value");
        assert(val.contains(name));
    }
    public void VerifyLastNameField(String lname)throws InterruptedException {
        boolean foundMatch=false;
        WebElement element=driver.findElement(By.xpath("//*[@id=\"lastname\"]"));
        String val=element.getAttribute("value");
        assert(val.contains(lname));
    }
    public void VerifyEmailField(String email)throws InterruptedException {
        boolean foundMatch=false;
        WebElement element=driver.findElement(By.xpath("//*[@id=\"email\"]"));
        String val=element.getAttribute("value");
        assert(val.contains(email));
    }

}
