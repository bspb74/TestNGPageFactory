package com.testng.qa.utility;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.testng.ITestContext;

import java.io.File;
import java.io.IOException;

public class ExtentManager {

    public static ExtentSparkReporter htmlReporter;
    public static ExtentReports extent;
    public static ExtentTest test;

    public static void setExtent() {
        htmlReporter= new ExtentSparkReporter(System
                .getProperty("user.dir")+"/test-output/ExtentReport/"+"MyReport_"+ScreenShot.getCurrentTime()+".html");
        try {
            htmlReporter.loadXMLConfig(System.getProperty("user.dir") + File.separator + "src" + File.separator +
                    "main" + File.separator + "resources" + File.separator + "extent-config.xml");
        } catch (IOException e) {
            e.getMessage();
        }

        extent = new ExtentReports();
        extent.attachReporter(htmlReporter);

        extent.setSystemInfo("HostName", "SPB-Dev");
        extent.setSystemInfo("ProjectName", "TestNG-POM");
        extent.setSystemInfo("Tester", "bspb74");
        extent.setSystemInfo("OS", "Win10");
        extent.setSystemInfo("Browser", "Chrome");
    }
    public static void endReport() {
        extent.flush();
    }

    public static String getName(ITestContext context) {
        int index = context.getAttribute("index") == null ? 0 : (int) context.getAttribute("index");
        String[] names = (String[]) context.getAttribute("names");

        if (names == null || index >= names.length) {
            return String.valueOf(index);
        }
        String name = names[index++];
        context.setAttribute("index", index);
        return name;
    }
}