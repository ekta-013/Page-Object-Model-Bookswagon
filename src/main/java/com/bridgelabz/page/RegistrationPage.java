package com.bridgelabz.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegistrationPage {
    WebDriver driver;


    @FindBy(linkText = "New to Bookswagon? Sign up")
    WebElement signUpLink;

    @FindBy(id = "ctl00_phBody_SignUp_txtName")
    WebElement fullName;

    @FindBy(id = "ctl00_phBody_SignUp_txtEmail")
    WebElement mobileNum;

    @FindBy(id = "ctl00_phBody_SignUp_btnContinue")
    WebElement continueButton;

    @FindBy (id = "ctl00_phBody_SignUp_txtOTP")
    WebElement otp;

    @FindBy (id = "ctl00_phBody_SignUp_txtPassword")
    WebElement password;

    @FindBy (id = "ctl00_phBody_SignUp_txtConfirmPwd")
    WebElement confirmPwd;

    public RegistrationPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    public String redirectToSignUpPage () throws InterruptedException {
        Thread.sleep(500);
        signUpLink.click();
        Thread.sleep(1000);
        String pageTitle = driver.getTitle();
        return pageTitle;

    }
    public void enterDataInField() throws InterruptedException {
        signUpLink.click();
        fullName.sendKeys("Ekta Mohite");
        mobileNum.sendKeys("9604731539");
        continueButton.click();
        Thread.sleep(500);
        otp.sendKeys("2554336");
        password.sendKeys("Forgot@1");
        confirmPwd.sendKeys("Forgot@1");
        Thread.sleep(1000);

    }

}
