package TestScenarios;

import ObjectPages.LoginPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;


public class LoginPageTest {

    public WebDriver driver;


    LoginPage LPage;

    @BeforeMethod
    public void SetUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://qajobbyapp.ccbp.tech/login");
        LPage = new LoginPage(driver);


    }

    @AfterMethod
    public void TearDown(){
        driver.quit();
    }


    //Test the Login Page UI

    @Test(priority = 1)
    public void LoginPageUITest(){
        //Navigate to the URL https://qajobbyapp.ccbp.tech/login
        //Verify if the App logo is displayed - use Assertions,
        //If the App logo is not displayed, print "App logo is not displayed"
        Assert.assertTrue(LPage.AppLogoImage().isDisplayed(),"App logo is not displayed");

        //Verify the Username label text - use Assertions,
        //Expected text: USERNAME
        //If the Label text does not match the expected text, print "Username label text does not match"

        Assert.assertEquals(LPage.GetLabelSpecificIndex(0),"USERNAME","Username label text does not match");

        //Verify the Password label text - use Assertions,
        //Expected text: PASSWORD
        //If the Label text does not match the expected text, print "Password label text does not match"

        Assert.assertEquals(LPage.GetLabelSpecificIndex(1),"PASSWORD","Password label text does not match");
    }

    //Test the submission with empty input fields

    @Test(priority = 2)
    public void SubmissionWithEmptyInput(){

        //Navigate to the URL https://qajobbyapp.ccbp.tech/login
        //Click the "Login" button.
        //Wait and verify the error message - use Assertions,
        //Expected text: *Username or password is invalid
        //If the error message does not match the expected text, print "Error text with empty input fields does not match"
        //Close the browser window.

        LPage.ClickLoginBtn();
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("error-message")));

        Assert.assertEquals(LPage.GetErrorMessage(),"*Username or password is invalid","Error text with empty input fields does not match");

    }

    //Test the submission with empty Username field

    @Test(priority = 3)
    public void SubmissionWithEmptyUsername(){
        //Navigate to the URL https://qajobbyapp.ccbp.tech/login
        //Login to the application, only with the Password rahul@2021.
        //Wait and verify the error message - use Assertions,
        //Expected text: *Username or password is invalid
        //If the error message does not match the expected text, print "Error text with empty input field do not match"
        //Close the browser window.

        LPage.EnterPassword("rahul@2021");
        LPage.ClickLoginBtn();
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("error-message")));

        Assert.assertEquals(LPage.GetErrorMessage(),"*Username or password is invalid","Error text with empty input field do not match");


    }

    //Test the submission with empty Password field
    @Test(priority = 4)
    public void SubmissionWithEmptyPassword(){

        //Navigate to the URL https://qajobbyapp.ccbp.tech/login
        //Login to the application, only with the Username rahul.
        //Wait and verify the error message - use Assertions,
        //Expected text: *Username or password is invalid
        //If the error message does not match the expected text, print "Error text with empty input field do not match"
        //Close the browser window.

        LPage.EnterUsername("rahul");
        LPage.ClickLoginBtn();
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("error-message")));

        Assert.assertEquals(LPage.GetErrorMessage(),"*Username or password is invalid","Error text with empty input field do not match");

    }

    //Test the submission with invalid Password
    @Test(priority = 5)
    public void SubmissionWithInvalidPassword(){
        //Navigate to the URL https://qajobbyapp.ccbp.tech/login
        //Login to the application, with the Username rahul and Password rahul.
        //Wait and verify the error message - use Assertions,
        //Expected text: *username and password didn't match
        //If the error message does not match the expected text, print "Error text with invalid password do not match"
        //Close the browser window.

        LPage.EnterUsername("rahul");
        LPage.EnterPassword("rahul");
        LPage.ClickLoginBtn();
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("error-message")));

        Assert.assertEquals(LPage.GetErrorMessage(),"*username and password didn't match","Error text with invalid password do not match");


    }

    //Test the successful login
    @Test(priority = 6)
    public void SuccessfulLogin(){
        //Navigate to the URL https://qajobbyapp.ccbp.tech/login
        //Login to the application, with the Username rahul and Password rahul@2021.
        //Wait and verify the navigation to the home page - use Assertions
        //Expected URL: https://qajobbyapp.ccbp.tech/
        //If the current URL does not match the expected URL, print "URLs do not match"
        //Close the browser window.
        LPage.EnterUsername("rahul");
        LPage.EnterPassword("rahul@2021");
        LPage.ClickLoginBtn();
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
        wait.until(ExpectedConditions.urlToBe("https://qajobbyapp.ccbp.tech/"));
        Assert.assertEquals(driver.getCurrentUrl(),"https://qajobbyapp.ccbp.tech/","URLs do not match");


    }










}
