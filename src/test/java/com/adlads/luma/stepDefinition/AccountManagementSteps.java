package com.adlads.luma.stepDefinition;

import com.adlads.luma.cucumber.Hooks;
import com.adlads.luma.pageObjects.CreateAccountPagePO;
import com.adlads.luma.pageObjects.HomePagePO;
import com.adlads.luma.pageObjects.SignInPagePO;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;


public class AccountManagementSteps {
    //WebDriver driver;
    WebDriver driver = Hooks.driver; //driver element in our hook class
    @Given("^user is on create an account page$")
    public void userIsOnCreateAnAccountPage() throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://magento2-demo.magebit.com/");
       // driver.findElement(By.linkText("Create an Account")).click();
        //Thread.sleep(5000);
       // driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        HomePagePO homePagePO = new HomePagePO(driver);
        homePagePO.clickCreateAccountlink();
            }
    @When("^user enters \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\"$")
    public void userEnters(String FirstName, String LastName, String Email, String Password, String ConfirmPassword) throws Throwable {
        CreateAccountPagePO createAccountPagePO = new CreateAccountPagePO(driver);
        createAccountPagePO.enterFirstName(FirstName);
        createAccountPagePO.enterLastName(LastName);
        createAccountPagePO.enterEmail(Email);
        createAccountPagePO.enterPassword(Password);
        createAccountPagePO.enterConfirmPassword(ConfirmPassword);
//      driver.findElement(By.id("firstname")).sendKeys(FirstName);
//      driver.findElement(By.id("lastname")).sendKeys(LastName);
//      driver.findElement(By.name("email")).sendKeys(Email);
//      driver.findElement(By.id("password")).sendKeys(Password);
//      driver.findElement(By.id("password-confirmation")).sendKeys(ConfirmPassword);
    }

    @And("^user clicks on create account button$")
    public void userClicksOnCreateAccountButton() {
        driver.findElement(By.xpath("//*[@id=\"form-validate\"]/div/div[1]/button/span")).click();
    }

    @Then("^my account page should be displayed$")
    public void myAccountPageShouldBeDisplayed() {
        String expectedResult = "My Account";
        String actualResult = driver.getTitle();
        Assert.assertEquals(expectedResult, actualResult);

    }


    @Then("^an error message should be displayed$")
    public void anErrorMessageShouldBeDisplayed() {
        String expectedResult = "Create New Customer Account";
        String actualResult = driver.getTitle();
        Assert.assertEquals(expectedResult,actualResult);
        System.out.println(driver.findElement(By.cssSelector("#maincontent > div.page.messages > div:nth-child(2) > div > div > div")).getText());


    }

    @Given("^user is on Sign in page$")
    public void userIsOnSignInPage() {

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://magento2-demo.magebit.com/");
       // driver.findElement(By.linkText("Sign In")).click();
        HomePagePO homePagePO = new HomePagePO(driver);
        homePagePO.clickSignInlink();


  }

       @When("^user enters \"([^\"]*)\" \"([^\"]*)\"$")
        public void userEnters(String Email, String Password) throws Throwable {
           SignInPagePO signInPagePO = new SignInPagePO(driver);
           signInPagePO.enterEmail(Email);
           signInPagePO.enterPassword(Password);

//        driver.findElement(By.id("email")).sendKeys(Email);
//        driver.findElement(By.id("pass")).sendKeys(Password);
    }

    @And("^user clicks on sign in link button$")
    public void userClicksOnSignInLinkButton() {
        SignInPagePO signInPagePO = new SignInPagePO(driver);
        signInPagePO.clickSignInButton();
     //driver.findElement(By.xpath("/*[@id=\"send2\"]/span")).click();
    // driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
    }

    @Then("^my account page is displayed$")
    public void myAccountPageIsDisplayed() {

        String expectedResult = "Magento 2 Commerce (Enterprise) Demo - Magebit";
        String actualResult = driver.getTitle();
        Assert.assertEquals(expectedResult,actualResult);
        System.out.println(driver.getTitle());
    }


}
