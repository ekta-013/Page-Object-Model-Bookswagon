package com.bridgelabz.page;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class LoginPage {
    WebDriver driver;

    @CacheLookup
    @FindBy(id = "ctl00_phBody_SignIn_txtEmail")
    WebElement mobileNum;

    @CacheLookup
    @FindBy(id = "ctl00_phBody_SignIn_txtPassword")
    WebElement password;

    @CacheLookup
    @FindBy(id = "ctl00_phBody_SignIn_btnLogin")
    WebElement SignInButton;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    } 
    public void loginInToTheBW(String num, String pass) throws InterruptedException {
        mobileNum.sendKeys(num);
        password.sendKeys(pass);
        SignInButton.click();
        Thread.sleep(500);
        redirectOnToTheHomePage();
    }

    public void redirectOnToTheHomePage() {
        String title = driver.getTitle();
        Assert.assertEquals("Online BookStore India, Buy Books Online, Buy Book Online India - Bookswagon.com",title);
    }
}
