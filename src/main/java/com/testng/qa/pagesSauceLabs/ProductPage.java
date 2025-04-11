package com.testng.qa.pagesSauceLabs;

import com.testng.qa.base.TestBase;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductPage extends TestBase {

    Logger log = LogManager.getLogger(ProductPage.class.getSimpleName());

    @FindBy(xpath = "//button[contains(@class,\"inventory_details_back_button\")]")
    WebElement backToProductsPage;

    @FindBy(id = "remove")
    WebElement removeItemBtn;

    @FindBy(id = "add-to-cart")
    WebElement addItemBtn;

    @FindBy(xpath="//div[contains(@class,\"inventory_details_name\")]")
    WebElement itemName;

    @FindBy(xpath="//div[contains(@class,\"inventory-details-price\")]")
    WebElement itemPrice;

    @FindBy(xpath = "//div[@class=\"inventory_details_desc_container\"]/button")
    WebElement itemButton;

    public ProductPage () {
        PageFactory.initElements(driver, this);
    }

    public void removeItem() {
        removeItemBtn.click();
    }

    public void addItem() {
        addItemBtn.click();
    }

    public String getItemName() {
        return itemName.getText();
    }

    public String getItemPrice() {
        return itemPrice.getText();
    }

    public void returnToProductPage() {
        backToProductsPage.click();
    }

    public String getItemButtonAction() {
        return itemButton.getAttribute("id");
    }

}
