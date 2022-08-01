package com.apache.pages;

import com.apache.utilities.BrowserUtils;
import com.apache.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class VyTrackLoginPage {
    public VyTrackLoginPage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }
    @FindBy(id = "prependedInput")
    public WebElement loginUser;

    @FindBy(id = "prependedInput2")
    public WebElement loginPass;

    @FindBy(id = "_submit")
    public WebElement loginButton;

    public void login(String username, String password) throws InterruptedException {
        loginUser.sendKeys(username);
        loginPass.sendKeys(password);
        loginButton.click();


    }

}
