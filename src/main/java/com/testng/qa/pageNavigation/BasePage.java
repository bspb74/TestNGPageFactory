package com.testng.qa.pageNavigation;

import com.testng.qa.base.TestBase;

public class BasePage extends TestBase {

    public void navigateBack() {
        driver.navigate().back();
    }

    public void waitTimer(int wt) {
        try {
            Thread.sleep(wt * 1000L);
        } catch (InterruptedException e) {
            e.getMessage();
        }
    }
}
