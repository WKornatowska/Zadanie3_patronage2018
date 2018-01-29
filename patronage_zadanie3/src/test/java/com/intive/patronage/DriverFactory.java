package com.intive.patronage;
import com.intive.patronage.pages.AutomationPracticeHomePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

import java.util.concurrent.TimeUnit;

public class DriverFactory {

    public WebDriver driver;
    AutomationPracticeHomePage homePage;

    public DriverFactory(WebDriver driver) {
        this.driver=driver;
        PageFactory.initElements(driver, this);

    }
    public void Setup(){
        System.setProperty("webdriver.chrome.driver", "C:\\selenium\\chromedriver\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }

    public AutomationPracticeHomePage getHomePage(){
        driver.get("http://automationpractice.com/");
        return homePage=new AutomationPracticeHomePage(driver);
    }

    public void destroyDriver(){
        if(driver!=null){
            driver.quit();
            driver=null;
        }
    }
}
