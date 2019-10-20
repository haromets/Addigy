package com.addigy.pages;

import com.addigy.base.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class CareersPage extends TestBase {

    @FindBy(css = "a[href='//addigy.bamboohr.com/jobs/view.php?id=18']")
    WebElement sdet;

    public CareersPage(){
        PageFactory.initElements(driver, this);
    }

    public String validateCareersPagePageTitle(){
     //   wait.until(ExpectedConditions.titleContains("Careers | Cloud platform for Apple Device Management | Apple MDM | Addigy"));
        return driver.getTitle();
    }

    public SDETPage getSDETPage(){
        sdet.click();
        return new SDETPage();
    }


}
