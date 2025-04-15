package com.testng.qa.browsers;

import com.testng.qa.base.TestBase;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import io.github.bonigarcia.wdm.WebDriverManager;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class ChromeDriverManager extends TestBase implements BrowserDriver {

    static Logger log = LogManager.getLogger(ChromeDriverManager.class.getSimpleName());

    @Override
    public WebDriver createDriver() {

        ChromeOptions opts = new ChromeOptions();
        opts.addArguments("--remote-allow-origins=*");
        opts.addArguments("--incognito");
        opts.addArguments("--no-sandbox");
        opts.setPageLoadStrategy(PageLoadStrategy.NORMAL);
        boolean headless = prop.getProperty("headless").equalsIgnoreCase("true");
        log.warn("Headless from Properties: " + headless);
        if (!headless) {
            headless = (System.getProperty("headless") != null);
        }
        if (headless) {
            opts.addArguments("--headless");
        }
        WebDriverManager.chromedriver().clearDriverCache()
                .cachePath(System.getProperty("user.dir") + "/src/main/resources/drivers")
                .avoidOutputTree().setup();
        return new ChromeDriver(opts);
    }
}
