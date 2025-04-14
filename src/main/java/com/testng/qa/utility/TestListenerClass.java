package com.testng.qa.utility;

import java.io.IOException;
import java.util.Arrays;

import com.testng.qa.base.TestBase;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class TestListenerClass extends ExtentManager implements ITestListener {

    private static Logger log = LogManager.getLogger(TestListenerClass.class.getSimpleName());

    public static void testStepScreenshot(String stepName) {
        String ssPath = ScreenShot.takeScreenShot(stepName);
        log.info("Adding screenshot: " + ssPath);
        try {
            test.addScreenCaptureFromPath(ssPath, MarkupHelper.createLabel(stepName, ExtentColor.GREEN).getMarkup());
        } catch (Exception e) {
            log.error("Cannot add Screenshot: " + Arrays.toString(e.getStackTrace()));
        }
    }
    public void onTestStart(ITestResult result) {
        test = extent.createTest(result.getName());
    }

    public void onTestSuccess(ITestResult result) {
        if (result.getStatus() == ITestResult.SUCCESS) {
            test.log(Status.PASS, "Pass Test case is: " + result.getName());
            log.info("Test Passed: " + result.getName());
        }
    }
    public void onTestFailure(ITestResult result) {
        if (result.getStatus() == ITestResult.FAILURE) {
            log.error("Failed: " + result.getName());
            test.log(Status.FAIL, MarkupHelper.createLabel(result.getName() + " - Test Case Failed", ExtentColor.RED));
            test.log(Status.FAIL,
                    MarkupHelper.createLabel(result.getThrowable() + " - Test Case Failed", ExtentColor.RED));

            String pathString = ScreenShot.takeScreenShot(result.getName());
            try {
                test.addScreenCaptureFromPath(pathString);
            } catch (Exception e) {
                // TODO Auto-generated catch block
                log.error(e.getMessage());
            }
        }
    }

    public void onTestSkipped(ITestResult result) {
        if (result.getStatus() == ITestResult.SKIP) {
            test.log(Status.SKIP, "Skipped Test case is: " + result.getName());
        }
    }
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
        // TODO Auto-generated method stub
    }
    public void onStart(ITestContext context) {
        // TODO Auto-generated method stub

    }
    public void onFinish(ITestContext context) {
        // TODO Auto-generated method stub
    }
}
