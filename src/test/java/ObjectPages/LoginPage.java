package ObjectPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage {
    //Define the locators for the Login page
    //App logo image

    By AppLogoImageLocator = By.cssSelector("img[class*='login-website-logo']");

    //List of label texts
    By ListOfLabelTextsLocators= By.cssSelector("label[class*='nput-label']");

    //"USERNAME" input field
    By UserNameInputLocator = By.id("userNameInput");

    //"PASSWORD" input field

    By PasswordInputLocator = By.id("passwordInput");
    //"Login" button

    By LoginButtonLocator = By.className("login-button");

    //Error message text
    By ErrorMessageTextLocator = By.className("error-message");



    //________________________________________________________________________________

    WebDriver driver;

    public LoginPage(WebDriver driver){
        this.driver = driver;
    }

    //Define the methods for performing actions on the elements
    //Find the App logo image

    public WebElement AppLogoImage(){
        return driver.findElement(AppLogoImageLocator);
    }

    //Get the text content of the label at a specific index

    public String GetLabelSpecificIndex(int index){
        return driver.findElements(ListOfLabelTextsLocators).get(index).getText();
    }

    //Enter a text in the "USERNAME" input field

    public void EnterUsername(String name){
        driver.findElement(UserNameInputLocator).sendKeys(name);
    }

    //Enter a text in the "PASSWORD" input field

    public void EnterPassword(String password){
        driver.findElement(PasswordInputLocator).sendKeys(password);
    }

    //Click the "Login" button

    public void ClickLoginBtn(){
        driver.findElement(LoginButtonLocator).click();
    }

    //Enter with the given credentials and click the "Login" button

    public void EnterCredentialsAndClick(String name,String password){
        EnterUsername(name);
        EnterPassword(password);
        ClickLoginBtn();
    }
    //Wait and get the text content of the error message
    public String GetErrorMessage(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(ErrorMessageTextLocator));
        return driver.findElement(ErrorMessageTextLocator).getText();
    }






}
