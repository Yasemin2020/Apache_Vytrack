package com.apache.pages;

import com.apache.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class VyTrackDashboardPage {
    public VyTrackDashboardPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }
    @FindBy(xpath = "//li[@id='user-menu']/a")
    public WebElement fullName;

    @FindBy(xpath = "//a[.='Logout']")
    public WebElement logOutLink;

    public void logOut(){
        fullName.click();
        logOutLink.click();
    }


}
