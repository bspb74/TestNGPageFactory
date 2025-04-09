package com.testng.pom.utility;

import org.openqa.selenium.WebDriver;

import java.time.Duration;

public class WebDriverManager {

    private static volatile WebDriverManager instance;
    private static ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    private WebDriverManager() {}

    private void initDriver(String browser) {
        driver.set(DriverFactory.getFactoryDriver(browser).createDriver());
    }

    public static WebDriverManager getInstance(String browser) { // not synchronized
        if (instance == null) {
            synchronized (WebDriverManager.class) {
                if (instance == null) {
                    instance = new WebDriverManager();
                }
            }
        }
        if (driver.get() == null) {
            instance.initDriver(browser);
        }
        return instance;
    }

    public static WebDriver getDriver() {
        driver.get().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get().manage().window().maximize();
        return driver.get();
    }

    public static void quitBrowser() {
        System.out.println("Closing Browser - Start");
        if (driver.get() != null) {
            System.out.println("Browser not Null -> Closing!");
            driver.get().quit();
            driver.remove();
        }
    }
}
