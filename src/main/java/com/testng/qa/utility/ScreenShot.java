package com.testng.qa.utility;

import com.testng.qa.base.TestBase;
import com.testng.qa.browsers.WebDriverManager;
import org.openqa.selenium.WebDriver;
import java.text.SimpleDateFormat;
import org.openqa.selenium.TakesScreenshot;
import org.apache.commons.io.FileUtils;
import java.io.File;
import java.util.Date;
import org.openqa.selenium.OutputType;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ScreenShot extends TestBase {

    private static Logger log = LogManager.getLogger(ScreenShot.class.getSimpleName());

    public static String takeScreenShot(String filename) {
        String dateName = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
        TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
        File source = takesScreenshot.getScreenshotAs(OutputType.FILE);
        String fname = filename + "_" + dateName + ".png";
        String destination = System.getProperty("user.dir")+ File.separator + "test-output" + File.separator +
                "ScreenShot" + File.separator + fname;
        String extentReportsSSPathFname = ".." + File.separator + "ScreenShot" + File.separator + fname;
        log.info("Screenshot Path: " + destination);
        log.info("Extent Report SS Path: " + extentReportsSSPathFname);
        File finalDestination= new File(destination);
        try {
            FileUtils.copyFile(source, finalDestination);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.getMessage();
        }
        return extentReportsSSPathFname;
    }

    public static String getCurrentTime() {
        String currentDate = new SimpleDateFormat("yyyy-MM-dd-hhmmss").format(new Date());
        return currentDate;
    }
}
