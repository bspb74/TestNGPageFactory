package com.testng.qa.pagesHerokuApp;

import com.testng.qa.base.TestBase;
import com.testng.qa.pageNavigation.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;

public class ContentsPage extends TestBase {

    @FindBy(xpath="//li/a")
    List<WebElement> pages;

    @FindBy(xpath="//li/a[contains(text(),'A/B Testing')]")
    WebElement aBTesting;

    @FindBy(xpath="//li/a[contains(text(),'Add/Remove Elements')]")
    WebElement addRemoveElements;

    @FindBy(xpath="//li/a[contains(text(),'Basic Auth')]")
    WebElement basicAuth;

    @FindBy(xpath="//li/a[contains(text(),'Broken Images')]")
    WebElement brokenImages;

    @FindBy(xpath="//li/a[contains(text(),'Challenging DOM')]")
    WebElement challengingDOM;

    @FindBy(xpath="//li/a[contains(text(),'Checkboxes')]")
    WebElement checkboxes;

    @FindBy(xpath="//li/a[contains(text(),'Context Menu')]")
    WebElement contextMenu;

    @FindBy(xpath="//li/a[contains(text(),'Digest Authentication')]")
    WebElement digestAuthentication;

    @FindBy(xpath="//li/a[contains(text(),'Disappearing Elements')]")
    WebElement disappearingElements;

    @FindBy(xpath="//li/a[contains(text(),'Drag and Drop')]")
    WebElement dragandDrop;

    @FindBy(xpath="//li/a[contains(text(),'Dropdown')]")
    WebElement dropdown;

    @FindBy(xpath="//li/a[contains(text(),'Dynamic Content')]")
    WebElement dynamicContent;

    @FindBy(xpath="//li/a[contains(text(),'Dynamic Controls')]")
    WebElement dynamicControls;

    @FindBy(xpath="//li/a[contains(text(),'Dynamic Loading')]")
    WebElement dynamicLoading;

    @FindBy(xpath="//li/a[contains(text(),'Entry Ad')]")
    WebElement entryAd;

    @FindBy(xpath="//li/a[contains(text(),'Exit Intent')]")
    WebElement exitIntent;

    @FindBy(xpath="//li/a[contains(text(),'File Download')]")
    WebElement fileDownload;

    @FindBy(xpath="//li/a[contains(text(),'File Upload')]")
    WebElement fileUpload;

    @FindBy(xpath="//li/a[contains(text(),'Floating Menu')]")
    WebElement floatingMenu;

    @FindBy(xpath="//li/a[contains(text(),'Forgot Password')]")
    WebElement forgotPassword;

    @FindBy(xpath="//li/a[contains(text(),'Form Authentication')]")
    WebElement formAuthentication;

    @FindBy(xpath="//li/a[contains(text(),'Frames')]")
    WebElement frames;

    @FindBy(xpath="//li/a[contains(text(),'Geolocation')]")
    WebElement geolocation;

    @FindBy(xpath="//li/a[contains(text(),'Horizontal Slider')]")
    WebElement horizontalSlider;

    @FindBy(xpath="//li/a[contains(text(),'Hovers')]")
    WebElement hovers;

    @FindBy(xpath="//li/a[contains(text(),'Infinite Scroll')]")
    WebElement infiniteScroll;

    @FindBy(xpath="//li/a[contains(text(),'Inputs')]")
    WebElement inputs;

    @FindBy(xpath="//li/a[contains(text(),'JQuery UI Menus')]")
    WebElement jQueryUIMenus;

    @FindBy(xpath="//li/a[contains(text(),'JavaScript Alerts')]")
    WebElement javaScriptAlerts;

    @FindBy(xpath="//li/a[contains(text(),'JavaScript onload event error')]")
    WebElement javaScriptonloadeventerror;

    @FindBy(xpath="//li/a[contains(text(),'Key Presses')]")
    WebElement keyPresses;

    @FindBy(xpath="//li/a[contains(text(),'Large & Deep DOM')]")
    WebElement largeDeepDOM;

    @FindBy(xpath="//li/a[contains(text(),'Multiple Windows')]")
    WebElement multipleWindows;

    @FindBy(xpath="//li/a[contains(text(),'Nested Frames')]")
    WebElement nestedFrames;

    @FindBy(xpath="//li/a[contains(text(),'Notification Messages')]")
    WebElement notificationMessages;

    @FindBy(xpath="//li/a[contains(text(),'Redirect Link')]")
    WebElement redirectLink;

    @FindBy(xpath="//li/a[contains(text(),'Secure File Download')]")
    WebElement secureFileDownload;

    @FindBy(xpath="//li/a[contains(text(),'Shadow DOM')]")
    WebElement shadowDOM;

    @FindBy(xpath="//li/a[contains(text(),'Shifting Content')]")
    WebElement shiftingContent;

    @FindBy(xpath="//li/a[contains(text(),'Slow Resources')]")
    WebElement slowResources;

    @FindBy(xpath="//li/a[contains(text(),'Sortable Data Tables')]")
    WebElement sortableDataTables;

    @FindBy(xpath="//li/a[contains(text(),'Status Codes')]")
    WebElement statusCodes;

    @FindBy(xpath="//li/a[contains(text(),'Typos')]")
    WebElement typos;

    @FindBy(xpath="//li/a[contains(text(),'WYSIWYG Editor')]")
    WebElement wYSIWYGEditor;

    public ContentsPage() {
        PageFactory.initElements(driver, this);
    }

    public List<String> getListOfStrings(){
        List<String> elems = new ArrayList<>();
        pages.forEach(w -> {
            elems.add(w.getText());
        });
        return elems;
    }

    public void clickABTesting(){
        aBTesting.click();
    }

    public void clickAddRemoveElements(){
        addRemoveElements.click();
    }

    public void clickBasicAuth(){
        basicAuth.click();
    }

    public void clickBrokenImages(){
        brokenImages.click();
    }

    public void clickChallengingDOM(){
        challengingDOM.click();
    }

    public void clickCheckboxes(){
        checkboxes.click();
    }

    public void clickContextMenu(){
        contextMenu.click();
    }

    public void clickDigestAuthentication(){
        digestAuthentication.click();
    }

    public void clickDisappearingElements(){
        disappearingElements.click();
    }

    public void clickDragandDrop(){
        dragandDrop.click();
    }

    public void clickDropdown(){
        dropdown.click();
    }

    public void clickDynamicContent(){
        dynamicContent.click();
    }

    public void clickDynamicControls(){
        dynamicControls.click();
    }

    public void clickDynamicLoading(){
        dynamicLoading.click();
    }

    public void clickEntryAd(){
        entryAd.click();
    }

    public void clickExitIntent(){
        exitIntent.click();
    }

    public void clickFileDownload(){
        fileDownload.click();
    }

    public void clickFileUpload(){
        fileUpload.click();
    }

    public void clickFloatingMenu(){
        floatingMenu.click();
    }

    public void clickForgotPassword(){
        forgotPassword.click();
    }

    public void clickFormAuthentication(){
        formAuthentication.click();
    }

    public void clickFrames(){
        frames.click();
    }

    public void clickGeolocation(){
        geolocation.click();
    }

    public void clickHorizontalSlider(){
        horizontalSlider.click();
    }

    public void clickHovers(){
        hovers.click();
    }

    public void clickInfiniteScroll(){
        infiniteScroll.click();
    }

    public void clickInputs(){
        inputs.click();
    }

    public void clickJQueryUIMenus(){
        jQueryUIMenus.click();
    }

    public void clickJavaScriptAlerts(){
        javaScriptAlerts.click();
    }

    public void clickJavaScriptonloadeventerror(){
        javaScriptonloadeventerror.click();
    }

    public void clickKeyPresses(){
        keyPresses.click();
    }

    public void clickLargeDeepDOM(){
        largeDeepDOM.click();
    }

    public void clickMultipleWindows(){
        multipleWindows.click();
    }

    public void clickNestedFrames(){
        nestedFrames.click();
    }

    public void clickNotificationMessages(){
        notificationMessages.click();
    }

    public void clickRedirectLink(){
        redirectLink.click();
    }

    public void clickSecureFileDownload(){
        secureFileDownload.click();
    }

    public void clickShadowDOM(){
        shadowDOM.click();
    }

    public void clickShiftingContent(){
        shiftingContent.click();
    }

    public void clickSlowResources(){
        slowResources.click();
    }

    public void clickSortableDataTables(){
        sortableDataTables.click();
    }

    public void clickStatusCodes(){
        statusCodes.click();
    }

    public void clickTypos(){
        typos.click();
    }

    public void clickWYSIWYGEditor(){
        wYSIWYGEditor.click();
    }

}
