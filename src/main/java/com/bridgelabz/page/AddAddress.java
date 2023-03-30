package com.bridgelabz.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class AddAddress {
    WebDriver driver;
    @FindBy(name = "ctl00$cpBody$txtNewRecipientName")
    WebElement name;

    @FindBy(name = "ctl00$cpBody$txtNewAddress")
    WebElement address;
    @FindBy(xpath = "//*[@id=\"ctl00_cpBody_plnShippingAdd\"]/div[6]/div[1]")
    WebElement country;
    @FindBy(name = "ctl00$cpBody$ddlNewState")
    WebElement state;

    @FindBy(id = "ctl00_cpBody_ddlNewCities")
    WebElement city;

    @FindBy(id = "ctl00_cpBody_txtNewPincode")
    WebElement pincode;

    @FindBy(id = "ctl00_cpBody_txtNewMobile")
    WebElement num;
    @FindBy(name = "ctl00$cpBody$imgSaveNew")
    WebElement save;
    public AddAddress(WebDriver driver) {
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }

    public void AddAddressIntoPage() throws InterruptedException {
        name.sendKeys("Ekta Mohite");
        address.sendKeys("Flat no:- 405, Jesal Melody, Takka Road, Panvel");
        Thread.sleep(500);
        Select state1 = new Select(state);
        Thread.sleep(500);
        state1.selectByValue("Maharashtra");
        Thread.sleep(500);
        Select city1 = new Select(city);
        Thread.sleep(500);
        city1.selectByValue("Panvel");
        Thread.sleep(500);
        pincode.sendKeys("410206");
        Thread.sleep(500);
        num.sendKeys("9604731539");
        save.click();
        Thread.sleep(500);
    }
}
