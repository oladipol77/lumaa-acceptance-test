package com.adlads.luma.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePagePO {
    @FindBy(linkText = "Create an Account")
    public static WebElement CreateAccountlink;

    @FindBy(linkText = "Sign In")
    public static WebElement SignInlink;

    //Explicit Wait Declaration
    //private WebDriverWait wait; // Declaring wait variable


    public HomePagePO(WebDriver driver){
       // wait = new WebDriverWait(driver, 5); // Declaring wait time duration
        PageFactory.initElements(driver, this);
    }


        public void clickCreateAccountlink () {
       // wait.until(ExpectedConditions.elementToBeClickable(CreateAccountlink));//Method wait action

            CreateAccountlink.click();

        }

        public void clickSignInlink () {
       // wait.until(ExpectedConditions.elementToBeClickable(SignInlink)); //Method wait action

            SignInlink.click();

        }


    }









