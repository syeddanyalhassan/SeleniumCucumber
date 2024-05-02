package Util;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class WebDriverManager {
    private static WebDriver driver;

    @Before
    public static WebDriver getDriver() {
        if (driver == null) {
/*
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--headless"); // Enable headless mode
            options.addArguments("--disable-gpu");
            System.setProperty("webdriver.chrome.driver", "./chromedriver/chromedriver.exe"); // Set path to chromedriver
            driver = new ChromeDriver(options);
*/
            System.setProperty("webdriver.chrome.driver", "./chromedriver/chromedriver.exe"); // Set path to chromedriver
            driver = new ChromeDriver();

        }
        return driver;

    }

    public static void quitDriver() {
        if (driver != null) {
                driver.close();

        }

    }

}