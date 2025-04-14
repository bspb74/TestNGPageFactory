package com.testng.qa.base;

import com.testng.qa.utility.ExtentManager;
import com.testng.qa.utility.TestUtil;
import com.testng.qa.browsers.WebDriverManager;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class TestBase {

    private static Logger log = LogManager.getLogger(TestBase.class.getSimpleName());

    public static WebDriver driver;
    public static Properties prop;

    private static boolean constructorExecuted = false;

    public TestBase(){
        if (!constructorExecuted) {
            try {
                prop = new Properties();
                FileInputStream fis = new FileInputStream(getPropertyFileString());
                prop.load(fis);
                log.warn("Loading Properites: " + getPropertyFileString());
                constructorExecuted = true;
            } catch (IOException e) {
                log.error("Properites not loaded: " + e.getMessage());
            }
        }
    }

    public static void initialization(String url){
        String browserName = prop.getProperty("browser");
        WebDriverManager.getInstance(browserName);
        driver = WebDriverManager.getDriver();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(TestUtil.PAGE_LOAD_TIMEOUT));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(TestUtil.IMPLICIT_WAIT));
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.get(prop.getProperty(url));
        log.info("URL: " + prop.getProperty(url));
    }

    private String getPropertyFileString() {
        String[] dirs = new String[] {"src", "main", "java", "com", "testng", "qa", "config", "config.properties"};
        StringBuilder sb = new StringBuilder();
        sb.append(System.getProperty("user.dir"));
        sb.append(File.separator);
        sb.append(String.join(File.separator, dirs));
        log.info("File: " + sb);
        return sb.toString();
    }

    @BeforeSuite
    public void initializeExtentManager() {
        ExtentManager.setExtent();
    }

    @AfterSuite
    public void teardownExtentManager() {
        ExtentManager.endReport();
    }
}
