package com.addigy.pages;

import com.addigy.base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage extends TestBase {

    //Page Factory:
    @FindBy(css = "#username")
    WebElement userName;

    @FindBy(css = "#password")
    WebElement password;

    @FindBy(css = "#addigySigninButton")
    WebElement loginBtn;

    @FindBy(css = "#loginLogo")
    WebElement addigyLogo;

    //Initializing the Page Objects:
    public  LoginPage(){
        PageFactory.initElements(driver, this);
    }

    //Actions:
    public String validateLoginPageTitle(){
        return driver.getTitle();
    }

    public boolean validateAddigyImage(){
    wait.until(ExpectedConditions.visibilityOf(addigyLogo));
        return addigyLogo.isDisplayed();
    }

    public BusinessDashboardPage login(String un, String pwd){
        userName.sendKeys(un);
        password.sendKeys(pwd);
        loginBtn.click();
        return new BusinessDashboardPage();
    }


}
