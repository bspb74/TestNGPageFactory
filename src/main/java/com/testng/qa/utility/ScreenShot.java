package com.testng.qa.utility;

import com.testng.qa.browsers.WebDriverManager;
import org.openqa.selenium.WebDriver;
import java.text.SimpleDateFormat;
import org.openqa.selenium.TakesScreenshot;
import org.apache.commons.io.FileUtils;
import java.io.File;
import java.util.Date;
import org.openqa.selenium.OutputType;

public class ScreenShot {

    private static WebDriver driver = WebDriverManager.getDriver();

    public String takeScreenShot(WebDriver driver,String filename) {
        String dateName = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
        TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
        File source = takesScreenshot.getScreenshotAs(OutputType.FILE);
        String destination = System.getProperty("user.dir")+"\\ScreenShot\\"+filename+"_"+dateName+".png";
        File finalDestination= new File(destination);
        try {
            FileUtils.copyFile(source, finalDestination);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.getMessage();
        }
        return destination;
    }

    public static String getCurrentTime() {
        String currentDate = new SimpleDateFormat("yyyy-MM-dd-hhmmss").format(new Date());
        return currentDate;
    }
}
