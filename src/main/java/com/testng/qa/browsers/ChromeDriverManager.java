package com.testng.qa.browsers;

import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import io.github.bonigarcia.wdm.WebDriverManager;

public class ChromeDriverManager implements BrowserDriver {

    @Override
    public WebDriver createDriver() {
        ChromeOptions opts = new ChromeOptions();
        opts.addArguments("--remote-allow-origins=*");
        opts.addArguments("--incognito");
        opts.addArguments("--no-sandbox");
        opts.setPageLoadStrategy(PageLoadStrategy.NORMAL);
        boolean headless = (System.getProperty("headless") != null);
        if (headless) {
            opts.addArguments("--headless");
        }
        WebDriverManager.chromedriver().clearDriverCache()
                .cachePath(System.getProperty("user.dir") + "/src/main/resources/drivers")
                .avoidOutputTree().setup();
        return new ChromeDriver(opts);
    }
}
