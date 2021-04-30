package com.pages;

import com.qa.factory.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

    private WebDriver driver;

    //By Locators
    private By emailId = By.cssSelector("input#txtUsername");
    private By password = By.cssSelector("input#txtPassword");
    private By signInButton = By.cssSelector("input#btnLogin");
    private By forgotPwdLink = By.linkText("Forgot your password?");
    private By errorMsg = By.cssSelector("span#spanMessage");

    //constructor of the page class
    public  LoginPage(WebDriver driver){
        this.driver = driver;
    }

    // page actions : features of the page the form of methods:
    public String getLoginPageTitle(){
        return driver.getTitle();
    }

    public boolean isForgotPasswordLinkExist(){
        return driver.findElement(forgotPwdLink).isDisplayed();
    }

    public void enterUserName(String username){
        driver.findElement(emailId).sendKeys(username);
    }

    public void enterPassword(String pwd){
        driver.findElement(password).sendKeys(pwd);
    }

    public void clickSignInnBtn(){
        driver.findElement(signInButton).click();
    }

    public String retrieveMessage(){
        String errorTxt = driver.findElement(errorMsg).getText();
        System.out.println(errorTxt);
        return errorTxt;
    }

    public AccountsPage doLogin(String uname , String pwd){
        driver.findElement(emailId).sendKeys(uname);
        driver.findElement(password).sendKeys(pwd);
        driver.findElement(signInButton).click();
        return new AccountsPage(driver);
    }
}
