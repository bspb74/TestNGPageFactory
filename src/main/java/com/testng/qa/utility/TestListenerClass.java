package com.testng.qa.utility;

import java.io.IOException;

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
        log.info("Adding screenshot: " + stepName);
        try {
            test.addScreenCaptureFromPath(ScreenShot.takeScreenShot(stepName));
        } catch (Exception e) {
            log.error(("Cannot add Screenshot: " + e.getMessage()));
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
