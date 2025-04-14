package com.testng.qa.utility;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Retry implements IRetryAnalyzer {

    static Logger log = LogManager.getLogger(Retry.class.getSimpleName());

    private static final int maxRetry = 2;
    private int count = 0;

    @Override
    public boolean retry(final ITestResult itr) {
        if (!itr.isSuccess()) {
            if (this.count < maxRetry) {
                log.info("Retrying Test: " + itr.getName() + " with status " + getRsltStatusName(itr.getStatus()) +
                        " for the " + (this.count++ + 1) + " time(s).");
                return true;
            }
        }
        return false;
    }

    public String getRsltStatusName(final int status) {
        String rsltName = null;
        if (status == 1) {
            rsltName = "SUCCESS";
        }
        if (status == 2) {
            rsltName = "FAILURE";
        }
        if (status == 3) {
            rsltName = "SKIPPED";
        }
        return rsltName;
    }
}