package com.addigy.testcases;

import com.addigy.base.TestBase;
import com.addigy.pages.CareersPage;
import com.addigy.pages.MainPage;
import com.addigy.pages.SDETPage;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CareersPageTest extends TestBase {

    CareersPage careersPage;
    SDETPage sdetPage;
    MainPage mainPage;


    public CareersPageTest() {
        super();
    }

    @BeforeMethod
    public void setUp(){
        initialization();
        mainPage = new MainPage();
        careersPage = mainPage.getCareersPage();
    }

    @Test
    public void careersPageTitleTest() {
        String title = careersPage.validateCareersPagePageTitle();
        Assert.assertEquals(title, "Careers | Cloud platform for Apple Device Management | Apple MDM | Addigy");
    }

    @Test
    public void getSDETPageTest(){
        sdetPage = careersPage.getSDETPage();
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
