package com.bridgelabz.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;

public class LogOutPage {
    WebDriver driver;
    public  LogOutPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }
    public void logOutFromAccount(){
        WebElement  arrow = driver.findElement(By.xpath("/html/body/form/header/div[1]/div/div[3]/ul/li[1]/a/span[2]/span"));
        Actions action = new Actions(driver);
        action.moveToElement(arrow);
        WebElement button = driver.findElement(By.xpath("/html/body/form/header/div[1]/div/div[3]/ul/li[1]/div/div/a"));
        action.moveToElement(button);
        action.click().build().perform();

    }
}
