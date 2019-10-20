package com.addigy.pages;

import com.addigy.base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class MainPage extends TestBase {

    //Page Factory:
    @FindBy(css = "a[href='https://addigy.com/mdm/']")
    WebElement appleDevManag;

    @FindBy(css = "a[href='https://addigy.com/events/']")
    WebElement events;

    @FindBy(css = "a[href='https://addigy.com/blog/']")
    WebElement blog;

    @FindBy(css = "a[href='https://prod.addigy.com/login']")
    WebElement logIn;

    @FindBy(css = "a[href='http://52.70.162.188/plesk-site-preview/addigy.com/10.0.0.123/home/sign-up/']")
    WebElement startTrial;

    @FindBy(css = "#menu-item-602 > a")
    WebElement careers;

    //Initializing the Page Objects:
    public MainPage() {
        PageFactory.initElements(driver, this);
    }

    //Actions:
    public String validateMainPageTitle() {
        return driver.getTitle();
    }

    public AppleDevManagPage getAppleDevManagPage() {
        appleDevManag.click();
        return new AppleDevManagPage();
    }

    public EventsPage getEventsPage() {
        events.click();
        return new EventsPage();
    }

    public BlogPage getBlogPage() {
        blog.click();
        return new BlogPage();
    }

    public LoginPage getLoginPage() {
        logIn.click();
        return new LoginPage();
    }

    public CareersPage getCareersPage() {
        WebElement cookiesOk = driver.findElement(By.id("cn-accept-cookie"));
        cookiesOk.click();
        careers.click();
        return new CareersPage();
    }

}
