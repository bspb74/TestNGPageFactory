package com.testng.qa.browsers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class FireFoxDriverManager implements BrowserDriver {

    @Override
    public WebDriver createDriver() {
        FirefoxOptions options = new FirefoxOptions();
        options.setHeadless(System.getProperty("headless") != null);
        options.addArguments("-private");
        io.github.bonigarcia.wdm.WebDriverManager.firefoxdriver()
                .cachePath(System.getProperty("user.dir") + "/src/main/resources/drivers")
                .avoidOutputTree().setup();
        return new FirefoxDriver(options);
    }
}
