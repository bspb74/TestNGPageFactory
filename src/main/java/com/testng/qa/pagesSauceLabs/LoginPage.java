package com.testng.qa.pagesSauceLabs;

import com.testng.qa.base.TestBase;
import org.testng.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class LoginPage extends TestBase {

    public LoginPage () {
        PageFactory.initElements(driver,this);
    }

    @FindBy(id="user-name")
    private WebElement username;

    @FindBy(id="password")
    private WebElement password;

    @FindBy(id="login-button")
    private WebElement loginBtn;

    public ProductsPage loginToSauceLabs(String uname, String pwd) {
        username.sendKeys(uname);
        password.sendKeys(pwd);
        loginBtn.click();
        return new ProductsPage();
    }
    public void entersUsername(String uname) {
        username.sendKeys(uname);
    }
    public void entersPassword(String pwd) {
        password.sendKeys(pwd);
    }
    public void clicksLogin() {
        loginBtn.click();
    }

    public void verifyPageTitle(String title) {
        Assert.assertEquals(driver.getTitle(), title);
    }

}
