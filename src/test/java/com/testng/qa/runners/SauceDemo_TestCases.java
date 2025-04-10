package com.testng.qa.runners;

import com.testng.qa.base.TestBase;
import com.testng.qa.browsers.WebDriverManager;
import com.testng.qa.testcases.TestCaseInterface;
import com.testng.qa.utility.ExcelReader;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.File;
import java.util.Iterator;
import java.util.Map;

public class SauceDemo_TestCases extends TestBase implements TestCaseInterface {

    public Logger log = LogManager.getLogger(SauceDemo_TestCases.class.getSimpleName());

    private static String file;
    private static String fName;
    private static String ssName;

    @Test(alwaysRun = true, priority = 1, description = "first test", dataProvider = "testData")
    public void initialTest(Map mapData) {
        log.info("name: " + mapData.get("name").toString());
    }

    @Test(alwaysRun = false, enabled = false, priority = 1, description = "second test")
    public void secondTest() {
        haNav.createFindBySyntax();
    }


    @DataProvider(name = "testData")
    public Iterator<Object[]> getTestData() {
        return ExcelReader.readExcelData(file, ssName);
    }

    @BeforeClass
    private void testSetup() {
        fName = prop.getProperty("initialTestFname");
        ssName = prop.getProperty("initialTestSheetName");
        log.warn(System.getProperty("user.dir"));
        String[] dirs = new String[] {"src", "main", "java", "com", "testng", "qa", "data"};
        StringBuilder sb = new StringBuilder();
        sb.append(System.getProperty("user.dir"));
        sb.append(File.separator);
        sb.append(String.join(File.separator, dirs));
        sb.append(File.separator);
        sb.append(fName);
        file = sb.toString();
        log.info("File: " + sb);
        initialization(prop.getProperty("shoppingUrl"));
    }

    @AfterClass
    private void browserQuit() {
        WebDriverManager.quitBrowser();
    }
}
