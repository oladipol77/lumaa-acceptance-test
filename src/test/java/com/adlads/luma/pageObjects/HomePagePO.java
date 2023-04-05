package com.adlads.luma.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePagePO {
    @FindBy(linkText = "Create an Account")
    public static WebElement CreateAccountlink;

    @FindBy(linkText = "Sign In")
    public static WebElement SignInlink;


    public HomePagePO(WebDriver driver){
        PageFactory.initElements(driver, this);
    }


        public void clickCreateAccountlink () {

            CreateAccountlink.click();

        }

        public void clickSignInlink () {

            SignInlink.click();

        }


    }









