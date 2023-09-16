package ObjectPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {

    //Define the locators for the Home page
    //Heading text
    By HomeHeadingTextLocator = By.cssSelector("h1[class*='home-heading']");

//Description text

    By HomeDescriptionTextLocator = By.cssSelector("p[class*='home-description']");
//"Find Jobs" button
    By FindJobsButtonLocator = By.cssSelector("button[class*='find-jobs-button']");

    //----------------------------------------------------------------------------
    WebDriver driver;

    public HomePage(WebDriver driver){
        this.driver = driver;
    }

    //Define the methods for performing actions on the elements
    //Get the text content of the Heading

    public String GetTextOfHeading(){
        return  driver.findElement(HomeHeadingTextLocator).getText();
    }

    //Get the text content of the Description
    public String GetTextDescription(){
        return driver.findElement(HomeDescriptionTextLocator).getText();
    }
    //Click the "Find Jobs" button

    public void ClickJobButton(){
        driver.findElement(FindJobsButtonLocator).click();
    }
}
