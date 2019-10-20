package com.addigy.testcases;

import com.addigy.base.TestBase;
import com.addigy.pages.*;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class MainPageTest extends TestBase {
    MainPage mainPage;
    AppleDevManagPage appleDevManagPage;
    EventsPage eventsPage;
    LoginPage loginPage;
    BlogPage blogPage;
    CareersPage careersPage;

    public MainPageTest() {
        super();
    }

    @BeforeMethod
    public void setUp() {
        initialization();
        mainPage = new MainPage();
    }

    @Test
    public void mainPageTitleTest() {
        String title = mainPage.validateMainPageTitle();
        Assert.assertEquals(title, "Cloud platform for Apple Device Management | Apple MDM | Addigy");
    }

    @Test
    public void appleDevManagPageTest() {
        appleDevManagPage = mainPage.getAppleDevManagPage();
    }

    @Test
    public void eventsPageTest() {
        eventsPage = mainPage.getEventsPage();
    }

    @Test
    public void blogPageTest() {
        blogPage = mainPage.getBlogPage();
    }

    @Test
    public void loginPageTest() {
        loginPage = mainPage.getLoginPage();
    }

    @Test
    public void careersPageTest() {
        careersPage = mainPage.getCareersPage();

    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
