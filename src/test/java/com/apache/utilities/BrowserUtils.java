package com.apache.utilities;

import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class BrowserUtils {

    /*
This method will accept int (in seconds) and execute Thread.sleep
for given duration
*/
    public static void sleep(int second) {
        second *= 1000;
        try {
            Thread.sleep(second);
        } catch (Exception e) {

        }
    }

    /*
    This method accepts 3 arguments.
    Arg1: webdriver
    Arg2: expectedInUrl : for verify if the url contains given String.
        - If condition matches, will break loop.
    Arg3: expectedInTitle to be compared against actualTitle
     */
    public static void switchWindowAndVerify(String expectedInUrl, String expectedInTitle) {
        Set<String> allWindowHandles = Driver.getDriver().getWindowHandles();

        for (String each : allWindowHandles) {
            Driver.getDriver().switchTo().window(each);

            System.out.println("CurrentUrl: " + Driver.getDriver().getCurrentUrl());

            if (Driver.getDriver().getCurrentUrl().contains(expectedInUrl)) {
                break;
            }
        }

        String actualTitle = Driver.getDriver().getTitle();

        Assert.assertTrue(actualTitle.contains(expectedInTitle));

        /*
TC #2: Create utility method
1. Create a new class called BrowserUtils
2. Create a method to make Task1 logic re-usable
3. When method is called, it should switch window and verify title.
Method info:
• Name: switchWindowAndVerify
• Return type: void
• Arg1: WebDriver
• Arg2: String expectedInUrl
• Arg3: String expectedTitle
 */
    }

    /*
    This method accepts a String "expectedTitle" and Asserts if it is true
    */
    public static void verifyTitle(String expectedTitle) {

        Assert.assertEquals(Driver.getDriver().getTitle(), expectedTitle);

    }

    /*
    Creating a utility method for ExplicitWait, so we don't want to repeat the lines
     */
    public static void waitForInvisibilityOf(WebElement webElement) {
        Driver.getDriver().manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 10);
        wait.until(ExpectedConditions.invisibilityOf(webElement));
        //wait.until(ExpectedConditions."What you want"(webElement));

    }

    /**
     * This method will verify if the current url
     * contains expected value
     *
     * @param expectedUrl
     */
    public static void verifyURLContains(String expectedUrl) {
        Assert.assertTrue(Driver.getDriver().getCurrentUrl().contains(expectedUrl));
    }

    /**
     * This method will accept a dropdown as a WebElement adn return
     * all the options as List<String>
     *
     * @param dropdownElements this will be used for Select class
     * @return List<String> actualOptionsAsString
     */
    public static List<String> dropdownOptionsAsString(WebElement dropdownElements) {

        Select select = new Select(dropdownElements);

        List<WebElement> actualOptionsAsWebElement = select.getOptions();

        List<String> actualOptionsAsString = new ArrayList<>();

        for (WebElement each : actualOptionsAsWebElement) {
            actualOptionsAsString.add(each.getText());
        }
        return actualOptionsAsString;
    }

    /**
     * This method will accept a group rado button as a List Of WebElement
     * It will loop through the list and click to the radio button with provided attribute value
     * @param radioButtons list
     * @param expectedAttributeValue string
     */
    public static void clickRadioButton(List<WebElement> radioButtons, String expectedAttributeValue) {

        for (WebElement each : radioButtons) {
            if (each.getAttribute("value").equals(expectedAttributeValue))
                each.click();

        }
    }

}