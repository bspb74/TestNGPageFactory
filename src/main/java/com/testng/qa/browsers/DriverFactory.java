package com.testng.qa.browsers;

public class DriverFactory {

    public static BrowserDriver getFactoryDriver(String browserType) {

        switch (browserType.toLowerCase()) {
            case "chrome":
                return new ChromeDriverManager();
            case "firefox":
                return new FireFoxDriverManager();
            case "ie":
                return new IEDriverManager();
            case "edge":
                return new EdgeDriverManager();
            default:
                throw new IllegalArgumentException("Invalid Browser: " + browserType);
        }


    }
}
