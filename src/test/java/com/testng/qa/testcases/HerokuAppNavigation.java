package com.testng.qa.testcases;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

import com.testng.qa.pages.PagesInterface;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class HerokuAppNavigation implements PagesInterface {

    Logger log = LogManager.getLogger(HerokuAppNavigation.class.getSimpleName());

    public void createFindBySyntax() {
        List<String> elems = cp.getListOfStrings();
        List<String> weNames = new ArrayList<>();
        elems.forEach(s -> {
            System.out.println("\n\t@FindBy(xpath=\"//li/a[contains(text(),'" + s + "')]\")");
            String weName = s.replaceAll("/", "")
                    .replaceAll("(user and pass: admin)", "").replaceAll("\\s","")
                    .replaceAll("&", "");
            weName = weName.substring(0,1).toLowerCase() + weName.substring(1);
            System.out.println("\tWebElement " + weName  + ";");
            weNames.add(weName);
        });

        weNames.forEach(n -> {
            String methodName = n.substring(0,1).toUpperCase() + n.substring(1);
            System.out.println("\n\tpublic void click" + methodName + "(){\n\t\t" + n + ".click();\n\t}");
        });

        AtomicInteger i = new AtomicInteger(2);
        weNames.forEach(n -> {
            String methodName = n.substring(0,1).toUpperCase() + n.substring(1);
            System.out.println("\n\t@Test(priority=" + i.getAndIncrement() + ", description=\"Test Navigation for: " + n + "\")");
            System.out.println("\tpublic void test" + methodName +"() {");
            System.out.println("\t\thaNav.test" + methodName + "Page();\n\t}");
        });

        weNames.forEach(n -> {
            String methodName = n.substring(0,1).toUpperCase() + n.substring(1);
            System.out.println("\n\tpublic void test" + methodName +"Page() {");
            System.out.println("\t\tcp.click" + methodName + "();");
            System.out.println("\t\tbp.navigateBack();\n\t}");
        });
    }

    public void testABTestingPage() {
        cp.clickABTesting();
        bp.navigateBack();
    }

    public void testAddRemoveElementsPage() {
        cp.clickAddRemoveElements();
        bp.navigateBack();
    }

    public void testBasicAuthPage() {
        cp.clickBasicAuth();
        bp.navigateBack();
    }

    public void testBrokenImagesPage() {
        cp.clickBrokenImages();
        bp.navigateBack();
    }

    public void testChallengingDOMPage() {
        cp.clickChallengingDOM();
        bp.navigateBack();
    }

    public void testCheckboxesPage() {
        cp.clickCheckboxes();
        bp.navigateBack();
    }

    public void testContextMenuPage() {
        cp.clickContextMenu();
        bp.navigateBack();
    }

    public void testDigestAuthenticationPage() {
        cp.clickDigestAuthentication();
        bp.navigateBack();
    }

    public void testDisappearingElementsPage() {
        cp.clickDisappearingElements();
        bp.navigateBack();
    }

    public void testDragandDropPage() {
        cp.clickDragandDrop();
        bp.navigateBack();
    }

    public void testDropdownPage() {
        cp.clickDropdown();
        bp.navigateBack();
    }

    public void testDynamicContentPage() {
        cp.clickDynamicContent();
        bp.navigateBack();
    }

    public void testDynamicControlsPage() {
        cp.clickDynamicControls();
        bp.navigateBack();
    }

    public void testDynamicLoadingPage() {
        cp.clickDynamicLoading();
        bp.navigateBack();
    }

    public void testEntryAdPage() {
        cp.clickEntryAd();
        bp.navigateBack();
    }

    public void testExitIntentPage() {
        cp.clickExitIntent();
        bp.navigateBack();
    }

    public void testFileDownloadPage() {
        cp.clickFileDownload();
        bp.navigateBack();
    }

    public void testFileUploadPage() {
        cp.clickFileUpload();
        bp.navigateBack();
    }

    public void testFloatingMenuPage() {
        cp.clickFloatingMenu();
        bp.navigateBack();
    }

    public void testForgotPasswordPage() {
        cp.clickForgotPassword();
        bp.navigateBack();
    }

    public void testFormAuthenticationPage() {
        cp.clickFormAuthentication();
        bp.navigateBack();
    }

    public void testFramesPage() {
        cp.clickFrames();
        bp.navigateBack();
    }

    public void testGeolocationPage() {
        cp.clickGeolocation();
        bp.navigateBack();
    }

    public void testHorizontalSliderPage() {
        cp.clickHorizontalSlider();
        bp.navigateBack();
    }

    public void testHoversPage() {
        cp.clickHovers();
        bp.navigateBack();
    }

    public void testInfiniteScrollPage() {
        cp.clickInfiniteScroll();
        bp.navigateBack();
    }

    public void testInputsPage() {
        cp.clickInputs();
        bp.navigateBack();
    }

    public void testJQueryUIMenusPage() {
        cp.clickJQueryUIMenus();
        bp.navigateBack();
    }

    public void testJavaScriptAlertsPage() {
        cp.clickJavaScriptAlerts();
        bp.navigateBack();
    }

    public void testJavaScriptonloadeventerrorPage() {
        cp.clickJavaScriptonloadeventerror();
        bp.navigateBack();
    }

    public void testKeyPressesPage() {
        cp.clickKeyPresses();
        bp.navigateBack();
    }

    public void testLargeDeepDOMPage() {
        cp.clickLargeDeepDOM();
        bp.navigateBack();
    }

    public void testMultipleWindowsPage() {
        cp.clickMultipleWindows();
        bp.navigateBack();
    }

    public void testNestedFramesPage() {
        cp.clickNestedFrames();
        bp.navigateBack();
    }

    public void testNotificationMessagesPage() {
        cp.clickNotificationMessages();
        bp.navigateBack();
    }

    public void testRedirectLinkPage() {
        cp.clickRedirectLink();
        bp.navigateBack();
    }

    public void testSecureFileDownloadPage() {
        cp.clickSecureFileDownload();
        bp.navigateBack();
    }

    public void testShadowDOMPage() {
        cp.clickShadowDOM();
        bp.navigateBack();
    }

    public void testShiftingContentPage() {
        cp.clickShiftingContent();
        bp.navigateBack();
    }

    public void testSlowResourcesPage() {
        cp.clickSlowResources();
        bp.navigateBack();
    }

    public void testSortableDataTablesPage() {
        cp.clickSortableDataTables();
        bp.navigateBack();
    }

    public void testStatusCodesPage() {
        cp.clickStatusCodes();
        bp.navigateBack();
    }

    public void testTyposPage() {
        cp.clickTypos();
        bp.navigateBack();
    }

    public void testWYSIWYGEditorPage() {
        cp.clickWYSIWYGEditor();
        bp.navigateBack();
    }

}
