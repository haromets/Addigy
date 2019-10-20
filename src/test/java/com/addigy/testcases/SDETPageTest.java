package com.addigy.testcases;

import com.addigy.base.TestBase;
import com.addigy.pages.CareersPage;
import com.addigy.pages.MainPage;
import com.addigy.pages.SDETPage;
import com.addigy.util.TestUtil;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


public class SDETPageTest extends TestBase {

    SDETPage sdetPage;
    MainPage mainPage;
    CareersPage careersPage;

    String sheetName = "pavel";

    public SDETPageTest() {
        super();
    }

    @BeforeMethod
    public void setUp(){
        initialization();
        mainPage = new MainPage();
        careersPage = mainPage.getCareersPage();
        sdetPage = careersPage.getSDETPage();
    }

    @Test
    public void SDETPageTitleTest() {
        String title = sdetPage.validateSDETPagePageTitle();
        Assert.assertEquals(title, "BambooHR");
    }

    @DataProvider
    public Object[][] getAddigyTestData(){
        Object data [][] = TestUtil.getTestData(sheetName);
        return data;
    }

    @Test(dataProvider = "getAddigyTestData")
    public void fillFieldsTest(String firstname, String lastname, String email, String phone,
                               String address, String city, String state, String zip, String pathF, String dateAvailable,
                               String salary, String website, String linkedin, String education,
                               String college){

        sdetPage.fillFields(firstname, lastname, email, phone, address, city, state, zip, pathF, dateAvailable, salary,
                website, linkedin, education, college);
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
