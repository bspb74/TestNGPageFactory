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
import java.util.LinkedHashMap;
import java.util.Map;

public class SauceDemo_TestCases extends TestBase implements TestCaseInterface {

    public Logger log = LogManager.getLogger(SauceDemo_TestCases.class.getSimpleName());

    private static String file;
    private static String fName;
    private static String ssName;

    @Test(enabled = true, priority = 1, description = "Login to Sauce Labs")
    public void sauceLabsLogin() {
        sll.Test_sauceLabsLogin(prop.getProperty("username"), prop.getProperty("password"));
    }

    @Test(enabled = false, priority = 2, description = "Select Sorting", dependsOnMethods = {"sauceLabsLogin"})
    public void selectProductSorting() {
        sll.Test_selectSorting("za");
        sll.Test_selectSorting("hilo");
        sll.Test_selectSorting("lohi");
        sll.Test_selectSorting("az");
    }

    @Test(enabled = false, priority = 3, description = "Get First Item After Sort", dependsOnMethods = {"sauceLabsLogin"})
    public void getFristItemAfterSorting() {
        sll.Test_getItemByLocationAfterSorting("za", "first", "Test.allTheThings() T-Shirt (Red)");
        sll.Test_getItemByLocationAfterSorting("hilo", "first", "Sauce Labs Fleece Jacket");
        sll.Test_getItemByLocationAfterSorting("lohi", "first", "Sauce Labs Onesie");
        sll.Test_getItemByLocationAfterSorting("az", "first", "Sauce Labs Backpack");
    }
    @Test(enabled = false, priority = 4, description = "Get First Item After Sort", dependsOnMethods = {"getFristItemAfterSorting"})
    public void getLastItemAfterSorting() {
        sll.Test_getItemByLocationAfterSorting("za", "last", "Sauce Labs Backpack");
        sll.Test_getItemByLocationAfterSorting("hilo", "last", "Sauce Labs Onesie");
        sll.Test_getItemByLocationAfterSorting("lohi", "last", "Sauce Labs Fleece Jacket");
        sll.Test_getItemByLocationAfterSorting("az", "last", "Test.allTheThings() T-Shirt (Red)");
    }

    @Test(enabled = false, priority = 5, description = "Get Item Info By Name", dependsOnMethods = {"sauceLabsLogin"})
    public void getItemInfoByName() {
        sll.Test_getItemInfoByName("Sauce Labs Onesie");
    }

    @Test(enabled = false, priority = 6, description = "Get All Items",  dependsOnMethods = {"sauceLabsLogin"})
    public void getAllItems() {
        sll.Test_getAllItems();
    }

    @Test(enabled = true, priority = 7, description = "Add Items To Cart",  dependsOnMethods = {"sauceLabsLogin"})
    public void addItemsToCart() {
        Map<String,String> itemMap = new LinkedHashMap<>();
        itemMap.put("Sauce Labs Backpack", "add");
        itemMap.put("Sauce Labs Bike Light", "remove");
        itemMap.put("Sauce Labs Bolt T-Shirt", "add");
        itemMap.put("Sauce Labs Fleece Jacket", "add");
        itemMap.put("Sauce Labs Onesie", "remove");
        itemMap.put("Test.allTheThings() T-Shirt (Red)", "add");
        sll.Test_addProductsToCart(itemMap);
    }

    @Test(enabled = true, priority = 8, description = "Update Item Qty", dependsOnMethods = {"addItemsToCart"})
    public void validateCartItemCount() {
        sll.Test_verifyItemCountInCart("Sauce Labs Fleece Jacket");
    }

    @Test(enabled = true, priority = 9, description = "Test Individual Product Page By Name",
            dependsOnMethods = { "sauceLabsLogin" })
    public void testIndividualProductPageByName() {
        sll.Test_individualProductPageByName("Sauce Labs Bike Light");
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
        initialization("url2");
    }

    @AfterClass
    private void browserQuit() {
        WebDriverManager.quitBrowser();
    }
}
