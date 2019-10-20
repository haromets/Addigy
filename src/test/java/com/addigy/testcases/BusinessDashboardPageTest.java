package com.addigy.testcases;

import com.addigy.base.TestBase;
import com.addigy.pages.BusinessDashboardPage;
import com.addigy.pages.LoginPage;
import com.addigy.pages.MainPage;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class BusinessDashboardPageTest extends TestBase {

    MainPage mainPage;
    BusinessDashboardPage businessDashboardPage = new BusinessDashboardPage();
    LoginPage loginPage;

    public BusinessDashboardPageTest(){
        super();
    }

    @BeforeMethod
    public void setUp(){
        initialization();
        mainPage = new MainPage();
        loginPage = mainPage.getLoginPage();
        businessDashboardPage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
    }

    @Test
    public void BusinessDashboardPageTitle(){
        String title = businessDashboardPage.validateBusnDashbPageTitle();
        Assert.assertEquals(title, "Addigy - Dashboard");
    }

    @Test
    public void verifyCorrectUserNameTest(){
        Assert.assertEquals(businessDashboardPage.verifyCorrectUserName(), "Pavel");
    }

    @Test
    public void verifyNumberActiveDevicesAllPoliciesTest(){
        Assert.assertTrue(businessDashboardPage.verifyNumberActiveDevicesAllPolicies("1"));
    }

    @Test
    public void verifyNumberActiveDevicesUniversityTest(){
        Assert.assertTrue(businessDashboardPage.verifyNumberActiveDevicesUniversity("0"));
    }

    @Test
    public void verifyMinimizeWindowsTest(){
        Assert.assertTrue(businessDashboardPage.verifyMinimizeWindows());
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
