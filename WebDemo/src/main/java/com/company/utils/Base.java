package com.company.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * To support multiple browser
 */
public class Base implements ILogger {
    public WebDriver driver;

    public WebDriver launchBrowser(String browserName) {
        switch (browserName.toLowerCase()) {
            case "chrome":
                System.setProperty("webdriver.chrome.driver", "chromedriver");
                driver = new ChromeDriver();
                driver.manage().window().maximize();
            case "firefox":
            case "safari":
            default:
                LOG.error("Browser instance not found");

        }
        return driver;
    }
}
