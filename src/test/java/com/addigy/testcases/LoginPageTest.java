package com.addigy.testcases;

import com.addigy.base.TestBase;
import com.addigy.pages.BusinessDashboardPage;
import com.addigy.pages.LoginPage;
import com.addigy.pages.MainPage;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginPageTest extends TestBase {

    MainPage mainPage;
    LoginPage loginPage;
    BusinessDashboardPage businessDashboardPage;

    public LoginPageTest() {
        super();
    }

    @BeforeMethod
    public void setUp() {
        initialization();
        mainPage = new MainPage();
        loginPage = mainPage.getLoginPage();
    }

    @Test
    public void loginPageTitleTest() {
        String title = loginPage.validateLoginPageTitle();
        Assert.assertEquals(title, "Login | Addigy");
    }

    @Test
    public void addigyLogoTest() {
        boolean flag = loginPage.validateAddigyImage();
        Assert.assertTrue(flag);
    }

    @Test
    public void loginTest() {
        businessDashboardPage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
