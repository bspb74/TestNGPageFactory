package com.testng.qa.pages;

import com.testng.qa.base.TestBase;

public class BasePage extends TestBase {

    public void navigateBack() {
        driver.navigate().back();
    }
}
