package com.addigy.pages;

import com.addigy.base.TestBase;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

import java.awt.event.KeyEvent;
import java.security.Key;

public class SDETPage extends TestBase {

    @FindBy(css = "button[class='btn btnLarge btnAction js-jobs-action noCaps']")
    WebElement Apply;

    @FindBy(css = "#firstName")
    WebElement firstName;

    @FindBy(css = "#lastName")
    WebElement lastName;

    @FindBy(css = "#email")
    WebElement email;

    @FindBy(css = "#phone")
    WebElement phone;

    @FindBy(css = "#address")
    WebElement address;

    @FindBy(css = "#city")
    WebElement city;

    @FindBy(css = "#zip")
    WebElement zip;

    @FindBy(css = "#salary")
    WebElement salary;

    @FindBy(css = "#website")
    WebElement website;

    @FindBy(css = "#linkedin")
    WebElement linkedIn;

    @FindBy(css = "#college")
    WebElement college;

    @FindBy (css =".chzn-single.chosen-default")
    WebElement stateOfUSA;

    @FindBy (css = ".ignore")
    WebElement stateIL;

    @FindBy (xpath = "//*[@class='fab-FormSection fieldsetIndent-outside']//*[@class='ba-Select__toggle']")
    WebElement HighestEd;

    @FindBy (xpath = "//*[@class='ResAts ResAts--view js-focus-visible']//*[@class='Balloon " +
            "js-balloon Balloon--Dropdown']//*[@class='ba-Select__searchInput focus-visible']")
    WebElement masterOfScience;

    @FindBy (css = ".ui-datepicker-trigger.btn.btnIcon")
    WebElement dateAvailable;

    @FindBy (xpath = "//*[@id='ui-datepicker-div']/table/tbody/tr[5]/td[3]/a")
    WebElement dateAvailableCl;

    @FindBy (className = "uploadInput")
    WebElement uploadFile;


    public SDETPage(){
        PageFactory.initElements(driver, this);

    }

    public String validateSDETPagePageTitle(){
        return driver.getTitle();
    }


    public void fillFields(String firstn, String lastn, String em, String ph,
                           String add, String cit, String stat, String zi, String pathFile, String dateAv, String salar,
                           String webs, String linkn, String education,
                           String coll){
        Apply.click();

        firstName.sendKeys(firstn);
        lastName.sendKeys(lastn);
        email.sendKeys(em);
        phone.sendKeys(ph);
        address.sendKeys(add);
        city.sendKeys(cit);
        stateOfUSA.click();
        stateIL.sendKeys(stat, Keys.ENTER);
        zip.sendKeys(zi);
        uploadFile.sendKeys(pathFile);
        dateAvailable.click();
        dateAvailableCl.click();
        salary.sendKeys(salar);
        website.sendKeys(webs);
        linkedIn.sendKeys(linkn);
        HighestEd.click();
        masterOfScience.sendKeys(education, Keys.ENTER);
        college.sendKeys(coll);

    }
}
