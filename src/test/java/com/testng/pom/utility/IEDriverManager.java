package com.testng.pom.utility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class IEDriverManager implements BrowserDriver {

    @Override
    public WebDriver createDriver() {
        return new InternetExplorerDriver();
    }
}
