package com.bridgelabz.baseclass;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Reporter;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Baseclass {
    public static WebDriver driver;

    public static Logger log = Logger.getLogger(Baseclass.class.getName());
    public void setup() {
        PropertyConfigurator.configure("C:\\Users\\EKTA\\IdeaProjects\\PageObjectBooksWagon\\log4j.properties");
        BasicConfigurator.configure();
        ChromeOptions option = new ChromeOptions();
        option.addArguments("--remote-allow-origins=*");
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver(option);
        driver.manage().window().maximize();
        driver.get("https://www.bookswagon.com/login");
        log.info("Chrome browser has launched");
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        log.debug("Implicit time wait");
    }
    public void closeBrowser() {
        driver.quit();
        log.info("quit");
        Reporter.log("Browser session ended!!!", true);
    }
        public static void takeScreenshot(String testName) throws IOException {
            Date date = new Date();
            TakesScreenshot screenshot = ((TakesScreenshot) driver);
            File srcFile = screenshot.getScreenshotAs(OutputType.FILE);
            File destinationFile = new File("Screenshot/" + testName + date.getTime() + ".png");
            FileUtils.copyFile(srcFile, destinationFile);
    }
}
