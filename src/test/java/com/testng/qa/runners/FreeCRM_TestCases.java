package com.testng.qa.runners;

import com.testng.qa.browsers.WebDriverManager;
import com.testng.qa.testcases.TestCaseInterface;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.testng.qa.utility.ExcelReader;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.testng.qa.base.TestBase;

import java.io.File;
import java.util.Iterator;
import java.util.Map;

public class FreeCRM_TestCases extends TestBase implements TestCaseInterface {

    public Logger log = LogManager.getLogger(FreeCRM_TestCases.class.getSimpleName());

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

    @Test(priority=2, description="Test Navigation for: aBTesting")
    public void testABTesting() {
        haNav.testABTestingPage();
    }

    @Test(priority=3, description="Test Navigation for: addRemoveElements")
    public void testAddRemoveElements() {
        haNav.testAddRemoveElementsPage();
    }

    @Test(priority=4, description="Test Navigation for: basicAuth")
    public void testBasicAuth() {
        haNav.testBasicAuthPage();
    }

    @Test(priority=5, description="Test Navigation for: brokenImages")
    public void testBrokenImages() {
        haNav.testBrokenImagesPage();
    }

    @Test(priority=6, description="Test Navigation for: challengingDOM")
    public void testChallengingDOM() {
        haNav.testChallengingDOMPage();
    }

    @Test(priority=7, description="Test Navigation for: checkboxes")
    public void testCheckboxes() {
        haNav.testCheckboxesPage();
    }

    @Test(priority=8, description="Test Navigation for: contextMenu")
    public void testContextMenu() {
        haNav.testContextMenuPage();
    }

    @Test(priority=9, description="Test Navigation for: digestAuthentication")
    public void testDigestAuthentication() {
        haNav.testDigestAuthenticationPage();
    }

    @Test(priority=10, description="Test Navigation for: disappearingElements")
    public void testDisappearingElements() {
        haNav.testDisappearingElementsPage();
    }

    @Test(priority=11, description="Test Navigation for: dragandDrop")
    public void testDragandDrop() {
        haNav.testDragandDropPage();
    }

    @Test(priority=12, description="Test Navigation for: dropdown")
    public void testDropdown() {
        haNav.testDropdownPage();
    }

    @Test(priority=13, description="Test Navigation for: dynamicContent")
    public void testDynamicContent() {
        haNav.testDynamicContentPage();
    }

    @Test(priority=14, description="Test Navigation for: dynamicControls")
    public void testDynamicControls() {
        haNav.testDynamicControlsPage();
    }

    @Test(priority=15, description="Test Navigation for: dynamicLoading")
    public void testDynamicLoading() {
        haNav.testDynamicLoadingPage();
    }

    @Test(priority=16, description="Test Navigation for: entryAd")
    public void testEntryAd() {
        haNav.testEntryAdPage();
    }

    @Test(priority=17, description="Test Navigation for: exitIntent")
    public void testExitIntent() {
        haNav.testExitIntentPage();
    }

    @Test(priority=18, description="Test Navigation for: fileDownload")
    public void testFileDownload() {
        haNav.testFileDownloadPage();
    }

    @Test(priority=19, description="Test Navigation for: fileUpload")
    public void testFileUpload() {
        haNav.testFileUploadPage();
    }

    @Test(priority=20, description="Test Navigation for: floatingMenu")
    public void testFloatingMenu() {
        haNav.testFloatingMenuPage();
    }

    @Test(priority=21, description="Test Navigation for: forgotPassword")
    public void testForgotPassword() {
        haNav.testForgotPasswordPage();
    }

    @Test(priority=22, description="Test Navigation for: formAuthentication")
    public void testFormAuthentication() {
        haNav.testFormAuthenticationPage();
    }

    @Test(priority=23, description="Test Navigation for: frames")
    public void testFrames() {
        haNav.testFramesPage();
    }

    @Test(priority=24, description="Test Navigation for: geolocation")
    public void testGeolocation() {
        haNav.testGeolocationPage();
    }

    @Test(priority=25, description="Test Navigation for: horizontalSlider")
    public void testHorizontalSlider() {
        haNav.testHorizontalSliderPage();
    }

    @Test(priority=26, description="Test Navigation for: hovers")
    public void testHovers() {
        haNav.testHoversPage();
    }

    @Test(priority=27, description="Test Navigation for: infiniteScroll")
    public void testInfiniteScroll() {
        haNav.testInfiniteScrollPage();
    }

    @Test(priority=28, description="Test Navigation for: inputs")
    public void testInputs() {
        haNav.testInputsPage();
    }

    @Test(priority=29, description="Test Navigation for: jQueryUIMenus")
    public void testJQueryUIMenus() {
        haNav.testJQueryUIMenusPage();
    }

    @Test(priority=30, description="Test Navigation for: javaScriptAlerts")
    public void testJavaScriptAlerts() {
        haNav.testJavaScriptAlertsPage();
    }

    @Test(priority=31, description="Test Navigation for: javaScriptonloadeventerror")
    public void testJavaScriptonloadeventerror() {
        haNav.testJavaScriptonloadeventerrorPage();
    }

    @Test(priority=32, description="Test Navigation for: keyPresses")
    public void testKeyPresses() {
        haNav.testKeyPressesPage();
    }

    @Test(priority=33, description="Test Navigation for: largeDeepDOM")
    public void testLargeDeepDOM() {
        haNav.testLargeDeepDOMPage();
    }

    @Test(priority=34, description="Test Navigation for: multipleWindows")
    public void testMultipleWindows() {
        haNav.testMultipleWindowsPage();
    }

    @Test(priority=35, description="Test Navigation for: nestedFrames")
    public void testNestedFrames() {
        haNav.testNestedFramesPage();
    }

    @Test(priority=36, description="Test Navigation for: notificationMessages")
    public void testNotificationMessages() {
        haNav.testNotificationMessagesPage();
    }

    @Test(priority=37, description="Test Navigation for: redirectLink")
    public void testRedirectLink() {
        haNav.testRedirectLinkPage();
    }

    @Test(priority=38, description="Test Navigation for: secureFileDownload")
    public void testSecureFileDownload() {
        haNav.testSecureFileDownloadPage();
    }

    @Test(priority=39, description="Test Navigation for: shadowDOM")
    public void testShadowDOM() {
        haNav.testShadowDOMPage();
    }

    @Test(priority=40, description="Test Navigation for: shiftingContent")
    public void testShiftingContent() {
        haNav.testShiftingContentPage();
    }

    @Test(priority=41, description="Test Navigation for: slowResources")
    public void testSlowResources() {
        haNav.testSlowResourcesPage();
    }

    @Test(priority=42, description="Test Navigation for: sortableDataTables")
    public void testSortableDataTables() {
        haNav.testSortableDataTablesPage();
    }

    @Test(priority=43, description="Test Navigation for: statusCodes")
    public void testStatusCodes() {
        haNav.testStatusCodesPage();
    }

    @Test(priority=44, description="Test Navigation for: typos")
    public void testTypos() {
        haNav.testTyposPage();
    }

    @Test(priority=45, description="Test Navigation for: wYSIWYGEditor")
    public void testWYSIWYGEditor() {
        haNav.testWYSIWYGEditorPage();
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
        initialization(prop.getProperty("url"));
    }

    @AfterClass
    private void browserQuit() {
        WebDriverManager.quitBrowser();
    }
}
