package ObjectPages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HeaderSection {

    //Define the locators for the Header section
    //App logo image
    By HeaderAppLogoImageLocator = By.cssSelector("div[class $= large-container] img.website-logo");
    //App logo link
    By AppLogoLinkLocator = By.cssSelector("div[class $= large-container]>a");
    //Navbar Home link
    By NavbarHomeLinkLocator = By.linkText("Home");
    //Navbar Jobs link
    By NavbarJobsLinkLocator = By.linkText("Jobs");
    //"Logout" button
    By LogOutLocator = By.className("logout-desktop-btn");

    //-------------------------------------------------------------------------------

    WebDriver driver;

    //Define the methods for performing actions on the elements
    //Find the App logo image
    public  HeaderSection(WebDriver driver){
        this.driver = driver;
    }
    public WebElement FindAppLogoImage(){
        return driver.findElement(HeaderAppLogoImageLocator);
    }
    //Click the App logo link

    public void ClickOnAppLogoLink(){
        driver.findElement(AppLogoLinkLocator).click();
    }
    //Click the Navbar Home link
    public void ClickOnNavbarHomeLink(){
        driver.findElement(NavbarHomeLinkLocator).click();
    }
    //Click the Navbar Jobs link
    public void ClickOnNavbarJobsLink(){
        driver.findElement(NavbarJobsLinkLocator).click();
    }
    //Click the "Logout" button

    public void ClickOnLogOut(){
        driver.findElement(LogOutLocator).click();
    }
    //Logout of the application, by accepting the alert

    public void AcceptingAlert(){
        ClickOnLogOut();
        Alert alert = driver.switchTo().alert();
        alert.accept();
    }


}
