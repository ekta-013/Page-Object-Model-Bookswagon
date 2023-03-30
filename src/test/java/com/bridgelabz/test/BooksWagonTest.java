package com.bridgelabz.test;

import com.bridgelabz.baseclass.Baseclass;
import com.bridgelabz.baseclass.TestNgListener;
import com.bridgelabz.page.*;
import com.bridgelabz.utility.DataProvider;
import io.qameta.allure.Epic;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Step;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(TestNgListener.class)
public class BooksWagonTest extends Baseclass {
    RegistrationPage register;
    LoginPage login;
    SearchBooksPage search;

    LogOutPage out;

    AddToWishList Add;

    AddToCart cart;

    AddAddress address;
    @BeforeMethod
    public void initialization () {
        setup();
        register =  new RegistrationPage(driver);
        login = new LoginPage(driver);
        search = new SearchBooksPage(driver);
        out = new LogOutPage(driver);
        Add = new AddToWishList(driver);
        cart = new AddToCart(driver);
        address = new AddAddress(driver);
    }
    @Test(priority = 0)
    @Epic("BooksWagon Regression")
    @Severity(value = SeverityLevel.CRITICAL)
    @Step("Redirect to sign up screen")
    public void redirectOnSignup() throws InterruptedException {
        log.debug("signup");
        register.redirectToSignUpPage();
        Thread.sleep(1000);
        log.info("Redireccted onto the Signup page");
    }

    @Test(priority = 1)
    @Severity(value = SeverityLevel.CRITICAL)
    @Step("Registration field")
    public void insertDataInField () throws InterruptedException {
        log.debug("enter data");
        Thread.sleep(1000);
        register.enterDataInField();
        log.info("Data has been added to fields successfully");
    }
    @Test(priority = 2, dataProvider = "testLoginData", dataProviderClass = DataProvider.class)
    @Severity(value = SeverityLevel.CRITICAL)
    @Step("Sign in page")
    public void signInIntoBookswagon(String mobileNum, String pass) throws InterruptedException {
        log.debug("Sign in");
        Thread.sleep(1000);
        login.loginInToTheBW(mobileNum, pass);
        log.info("Sign in for the application has been done successfully");
    }
    @Test(priority = 3,dataProvider = "testLoginData", dataProviderClass = DataProvider.class)
    @Severity(value = SeverityLevel.CRITICAL)
    @Step("Search book")
    public void searchAndSelectBookFromSearchBar(String mobileNum, String pass) throws InterruptedException {
        log.debug("search and select");
        login.loginInToTheBW(mobileNum, pass);
        Thread.sleep(1000);
        search.SearchBookByUsingSearchBar();
        log.info("searched and selected the desired book");
    }
    @Test(priority = 4,dataProvider = "testLoginData", dataProviderClass = DataProvider.class)
    @Severity(value = SeverityLevel.CRITICAL)
    @Step("Add to wishlist")
    public void AddAndCheckBookIntoWIshlist(String mobileNum, String pass) throws InterruptedException {
        log.debug("Add book into wishlist");
        login.loginInToTheBW(mobileNum, pass);
        Thread.sleep(1000);
        search.SearchBookByUsingSearchBar();
        Thread.sleep(1000);
        Add.AddAndCheckwishlist();
        log.info("your selected book has been added to wishlist");
    }
    @Test(priority = 5,dataProvider = "testLoginData", dataProviderClass = DataProvider.class)
    @Severity(value = SeverityLevel.CRITICAL)
    @Step("Add to cart")
    public void AddToCartPlaceorder(String mobileNum, String pass) throws InterruptedException {
        log.debug("Add book into cart And Place order");
        login.loginInToTheBW(mobileNum, pass);
        Thread.sleep(1000);
        search.SearchBookByUsingSearchBar();
        Thread.sleep(1000);
        Add.AddAndCheckwishlist();
        Thread.sleep(1000);
        cart.AddToCartAndPlaceOrderlist();
        log.info("your book has been added to cart and clicked on place order");
    }
    @Test(priority = 6,dataProvider = "testLoginData", dataProviderClass = DataProvider.class)
    @Severity(value = SeverityLevel.CRITICAL)
    @Step("Add Address into field")
    public void AddAddressinfield(String mobileNum, String pass) throws InterruptedException {
        log.debug("Add Address in place order section");
        login.loginInToTheBW(mobileNum, pass);
        Thread.sleep(1000);
        search.SearchBookByUsingSearchBar();
        Thread.sleep(1000);
        Add.AddAndCheckwishlist();
        Thread.sleep(1000);
        cart.AddToCartAndPlaceOrderlist();
        Thread.sleep(1000);
        address.AddAddressIntoPage();
        Thread.sleep(1000);
        log.info("your address for checkout has been updated successfully");
    }
    @Test(priority = 7,dataProvider = "testLoginData", dataProviderClass = DataProvider.class)
    @Severity(value = SeverityLevel.CRITICAL)
    @Step("Log out from bookswagon")
    public void logoutoption(String mobileNum, String pass) throws InterruptedException {
        login.loginInToTheBW(mobileNum, pass);
        Thread.sleep(1000);
        out.logOutFromAccount();
        Thread.sleep(1000);
    }
    @AfterMethod
    public void tearDown() {
        closeBrowser();
    }
}
