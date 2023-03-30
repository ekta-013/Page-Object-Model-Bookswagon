package com.bridgelabz.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddToWishList {
     WebDriver driver;
     @FindBy(xpath = "/html/body/form/div[10]/div/div/div/div[1]/div[2]/div[7]/input")
     WebElement wishlistButton;

    @FindBy(id = "ctl00_lblWishlistCount")
    WebElement chkWishlist;

    public AddToWishList(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }
    public void AddAndCheckwishlist() throws InterruptedException {
        wishlistButton.click();
        Thread.sleep(5000);
        chkWishlist.click();
        Thread.sleep(5000);
    }
}
