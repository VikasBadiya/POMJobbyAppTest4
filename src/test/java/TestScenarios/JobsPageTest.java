package TestScenarios;

import ObjectPages.HomePage;
import ObjectPages.JobsPage;
import ObjectPages.LoginPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.time.Duration;

public class JobsPageTest {

    public WebDriver driver;


    LoginPage LPage;
    HomePage HPage;

    JobsPage JPage;

    @BeforeMethod
    public void SetUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://qajobbyapp.ccbp.tech/login");
        LPage = new LoginPage(driver);
        HPage = new HomePage(driver);
        JPage = new JobsPage(driver);

        //Navigate to the URL https://qajobbyapp.ccbp.tech/login
        //Login to the application, with the Username rahul and Password rahul@2021.
        //Wait until the web driver navigates to the home page
        //Home Page URL: https://qajobbyapp.ccbp.tech/
        //Click the "Find Jobs" button.

        LPage.EnterCredentialsAndClick("rahul","rahul@2021");
        LPage.ClickLoginBtn();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.urlToBe("https://qajobbyapp.ccbp.tech/"));
        HPage.ClickJobButton();

    }

    @AfterMethod
    public void TearDown(){
        driver.quit();
    }


//Test the search functionality of the Jobs Page using various inputs from the given dataset.
//
// Dataset
//
//Search Text	Expected Number of Jobs
//Devops Engineer	9
//Backend Engineer	11
//Frontend Engineer	13
//Fullstack Developer	6
//Data Scientist	11
//ML Engineer	10

    @DataProvider(name = "dataSet")
    public Object[][] dataSetMethod() {
        return new Object[][]{
                {"Devops Engineer",9},
                {"Backend Engineer",11},
                {"Frontend Engineer",13},
                {"Fullstack Developer",6},
                {"Data Scientist",11},
                {"ML Engineer",10},
        };
    }

    //Test the Profile Container UI

    @Test(priority = 14 )
    public void ProfileContainerUI(){
        //Verify if the Profile image is displayed - use Assertions,
        //If the Profile image is not displayed, print "Profile image is not displayed"

        Assert.assertTrue(JPage.FindProfileImage().isDisplayed(),"Profile image is not displayed");

        //Verify the Profile name text - use Assertions,
        //Expected text: Rahul Attluri
        //If the Profile name does not match the expected text, print "Profile name does not match"

        Assert.assertEquals(JPage.GetTextProfileName(),"Rahul Attluri","Profile name does not match");

        //Verify the Short bio text - use Assertions,
        //Expected text: Lead Software Developer and AI-ML expert
        //If the Short bio text does not match the expected text, print "Bio does not match"
        Assert.assertEquals(JPage.GetTextShortBio(),"Lead Software Developer and AI-ML expert","Bio does not match");
        //Close the browser window.

    }

    //Test the Successful Search
    @Test(priority = 15 , dataProvider = "dataSet")
    public void SuccessfulSearch(String searchText, int expectedCount){
        //Search for the job with the search text.
        JPage.Search(searchText);

        //Verify the Jobs count - use Assertions,
        //
        //If the Jobs count does not match the expected count, print "Jobs count does not match"

        Assert.assertEquals(JPage.GetCountOfAllJobsDisplayed(),expectedCount,"Jobs count does not match");

    }

    //Test the Unsuccessful Search

    @Test(priority = 16)
    public void UnsuccessfulSearch(){
        //Search for the job with the text Netflix.
        JPage.Search("Netflix");
        //Verify if the No Jobs Found image is displayed - use Assertions,
        //If the No Jobs Found image is not displayed, print "Jobs not found image is not displayed"
        Assert.assertTrue(JPage.FindNoJobImage().isDisplayed(),"Jobs not found image is not displayed" );

        //Verify the No Jobs Found heading text - use Assertions,
        //Expected text: No Jobs Found
        //If the No Jobs Found heading does not match the expected text, print "Jobs not found heading does not match"

        Assert.assertEquals(JPage.GetTextNoJobHeading(),"No Jobs Found","Jobs not found heading does not match");

        //Verify the No Jobs Found description text - use Assertions,
        //Expected text: We could not find any jobs. Try other filters.
        //If the No Jobs Found description does not match the expected text, print "Jobs not found description does not match"
        Assert.assertEquals(JPage.GetTextNoJobDescription(),"We could not find any jobs. Try other filters.","Jobs not found description does not match");
        //Close the browser window.

    }
}
