package com.bridgelabz.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddToCart {
     WebDriver driver;
    @FindBy(id = "ctl00_phBody_WishList_lvWishList_ctrl0_btnaddtocart")
    WebElement cartButton;

    @FindBy(xpath = "/html/body/form/nav/div/div/div[2]/ul/li[1]")
    WebElement cartIcon;

    @FindBy(id = "BookCart_lvCart_imgPayment")
    WebElement placeOrderButton;

    public AddToCart(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }
    public void AddToCartAndPlaceOrderlist() throws InterruptedException {
        cartButton.click();
        Thread.sleep(5000);
        cartIcon.click();
        Thread.sleep(5000);
        driver.switchTo().frame(0);
        Thread.sleep(1000);
        placeOrderButton.click();
        Thread.sleep(1000);
    }

}
