package com.addigy.pages;

import com.addigy.base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class BusinessDashboardPage extends TestBase {

    @FindBy(css = ".hidden-xs.ng-binding")
    WebElement userNameLabel;

    @FindBy(css = "#dropdownMenuButton")
    WebElement dropDownMenuButton;

    @FindBy(css = "div[ng-controller='ActiveDevicesController as ctrl'] p.ng-binding")
    WebElement numberActiveDevices;

    @FindBy(css = "div[ng-controller='ActiveDevicesController as ctrl'] div.widget-stat-footer.text-left.ng-binding")
    WebElement percentOfActive;

    @FindBy(css = "a[href='javascript:;'][class='btn btn-sm btn-icon btn-circle btn-default']")
    List<WebElement> minimazeWindow;

    @FindBy(css = ".panel-body")
    List<WebElement> panelBody;

    @FindBy(xpath = "//a[contains(text(),'University')]")
    WebElement universityTab;

    @FindBy(xpath = "//*[@id='page1']/div[3]/div[3]/div/div/div/div[2]")
    WebElement markForWindows;

    public BusinessDashboardPage(){
        PageFactory.initElements(driver, this);
    }

    public String validateBusnDashbPageTitle(){
        wait.until(ExpectedConditions.titleContains("Addigy - Dashboard"));
        return driver.getTitle();
    }

    public String verifyCorrectUserName(){
        return userNameLabel.getText();
    }

    public boolean verifyNumberActiveDevicesAllPolicies(String countDevices){
        wait.until(ExpectedConditions.textToBePresentInElement(percentOfActive, "100% active"));
        return numberActiveDevices.getText().equals(countDevices);
    }

    public boolean verifyNumberActiveDevicesUniversity(String countDevices){
        dropDownMenuButton.click();
        universityTab.click();
        return numberActiveDevices.getText().equals(countDevices);
    }

    public boolean verifyMinimizeWindows(){
        boolean isTrue = false;
        System.out.println(minimazeWindow.size());
        System.out.println(panelBody.size());

        for(WebElement  el: minimazeWindow){
            try {
                Thread.sleep(600);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            el.click();
        }

        wait.until(ExpectedConditions.invisibilityOf(markForWindows));
        for(WebElement el: panelBody){
            if(!(el.isDisplayed())){
                isTrue = true;
            } else{
                isTrue = false;
                break;
            }
        }
        return isTrue;
    }












}
