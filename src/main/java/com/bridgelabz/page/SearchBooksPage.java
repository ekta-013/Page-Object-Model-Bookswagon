package com.bridgelabz.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchBooksPage {
    WebDriver driver;

    @FindBy(id = "inputbar")
    WebElement searchBar;

    @FindBy(name = "btnTopSearch")
    WebElement searchButton;

    @FindBy(xpath = "/html/body/form/div[10]/div[1]/div[2]/div[2]/div[1]/div[2]/a/img")
    WebElement book;

    public SearchBooksPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }
    public void SearchBookByUsingSearchBar() throws InterruptedException {
        searchBar.sendKeys("Harry Potter and order of phoenix");
        Thread.sleep(500);
        searchButton.click();
        Thread.sleep(500);
        book.click();
        Thread.sleep(500);
    }
}
