package ObjectPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class JobsPage {

    //Define the locators for the Header section
    //Profile image
    By ProfileImageLocator = By.cssSelector("img[class*='profile-img']");

    //Profile name
    By ProfileNameLocator = By.cssSelector("h1[class*='profile-name']");
    //Short bio text

    By ShortBioTextLocator = By.cssSelector("p[class*='short-bio']");
    //Search input field
    By SearchInputFieldLocator = By.cssSelector("div[class ^='desktop'] input.search-input");

    //Search button
    By SearchButtonLocator = By.cssSelector("div[class ^='desktop'] button.search-button");

    //List of all jobs displayed

    By ListOfAllJobsDisplayedLocator = By.className("link-item");
    //No jobs found image

    By NoJobImageLocator = By.cssSelector("img[class*='jobs-not-found-img']");

    //No jobs found heading

    By NoJobHeadingLocator = By.cssSelector("h1[class*='jobs-not-found-heading']");

    //No jobs found description
    By NoJobDescriptionLocator = By.cssSelector("p[class*='jobs-not-found-description']");

    By searchResultLocator = By.className("results-text");

    //----------------------------------------------------------------------------------------------
    WebDriver driver;

    WebDriverWait wait;

    public JobsPage(WebDriver driver){
        this.driver=driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    //Define the methods for performing actions on the elements
    //Find the Profile image

    public WebElement FindProfileImage(){
        return wait.until(ExpectedConditions.visibilityOfElementLocated(ProfileImageLocator));

    }

    //Get the text content of the Profile name
    public String GetTextProfileName(){
        return driver.findElement(ProfileNameLocator).getText();
    }

    //Get the text content of the Short bio text
    public String GetTextShortBio(){
        return driver.findElement(ShortBioTextLocator).getText();
    }
    //Enter a text in the Search input field
    public void EnterSearchInputField(String searchText){
        driver.findElement(SearchInputFieldLocator).sendKeys(searchText);
    }

    //Click the Search button
    public void ClickOnSearchButton(){
        driver.findElement(SearchButtonLocator).click();
    }

    //Search for a job with the specified text

    public void Search(String searchText){
        EnterSearchInputField(searchText);
        ClickOnSearchButton();
        wait.until(ExpectedConditions.visibilityOfElementLocated(searchResultLocator));
    }

    //Get the Count of all jobs displayed

    public int  GetCountOfAllJobsDisplayed(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(ListOfAllJobsDisplayedLocator));
         return driver.findElements(ListOfAllJobsDisplayedLocator).size();
    }

    //Find the No jobs found image
    public WebElement FindNoJobImage(){
        return wait.until(ExpectedConditions.visibilityOfElementLocated(NoJobImageLocator));
    }

    //Get the text content of the No jobs found heading

    public String GetTextNoJobHeading(){

        return driver.findElement(NoJobHeadingLocator).getText();
    }
    //Get the text content of the No jobs found description
    public String GetTextNoJobDescription(){

        return driver.findElement(NoJobDescriptionLocator).getText();
    }



}
