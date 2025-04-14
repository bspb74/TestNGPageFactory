package com.testng.qa.pageNavigation;

import com.testng.qa.base.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BasePage extends TestBase {

    @FindBy(xpath="//span[@class=\"title\"]")
    WebElement pageTitle;

    @FindBy(id = "react-burger-menu-btn")
    WebElement appMenuBtn;

    @FindBy(xpath = "//a[contains(text(),\"All Items\")]")
    WebElement allItemsLink;

    @FindBy(xpath = "//a[contains(text(),\"About\")]")
    WebElement aboutLink;

    @FindBy(xpath = "//a[contains(text(),\"Logout\")]")
    WebElement logoutLink;

    @FindBy(xpath = "//a[contains(text(),\"Reset App State\")]")
    WebElement resetAppStateLink;

    @FindBy(id="react-burger-cross-btn")
    WebElement closeMenu;

    @FindBy(xpath = "//a[contains(@class,'shopping_cart_link')]")
    WebElement cartLink;

    public BasePage() {
        PageFactory.initElements(driver, this);
    }

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

    public String getPageTite() {
        return pageTitle.getText();
    }

    public void navigateToAllItems() {
        appMenuBtn.click();
        allItemsLink.click();
        closeMenu.click();
    }

    public void signOut() {
        appMenuBtn.click();
        logoutLink.click();
    }
}
