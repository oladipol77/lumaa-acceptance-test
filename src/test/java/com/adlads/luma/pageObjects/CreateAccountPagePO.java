package com.adlads.luma.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateAccountPagePO {

    @FindBy(id = "firstname")
    public static WebElement FirstNameField;
    @FindBy(id = "lastname")
    public static WebElement LastNameField;
    @FindBy(name = "email")
    public static WebElement EmailField;
    @FindBy(id= "password")
    public static WebElement PassWordField;
    @FindBy(id = "password-confirmation")
    public static WebElement ConfirmPasswordField;
    @FindBy(xpath = "//*[@id=\"form-validate\"]/div/div[1]/button/span")
    public static WebElement CreateAccountButton;


    public CreateAccountPagePO (WebDriver driver){
        PageFactory.initElements(driver,this);

    }

    public void enterFirstName(String FirstName){
      FirstNameField.sendKeys(FirstName);

    }

    public void enterLastName(String LastName){
        LastNameField.sendKeys(LastName);

    }


    public void enterEmail(String Email){
        EmailField.sendKeys(Email);

    }

    public void enterPassword(String Password){
        PassWordField.sendKeys(Password);

    }

    public void enterConfirmPassword(String ConfirmPassword){
        ConfirmPasswordField.sendKeys(ConfirmPassword);

    }

    public void clickCreateAccountButton(){
        CreateAccountButton.click();

    }






}
