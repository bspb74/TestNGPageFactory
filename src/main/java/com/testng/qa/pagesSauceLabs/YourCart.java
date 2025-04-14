package com.testng.qa.pagesSauceLabs;

import com.testng.qa.base.TestBase;
import com.testng.qa.pageNavigation.BasePage;
import com.testng.qa.utility.TestListenerClass;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;


public class YourCart extends TestBase {

    BasePage bp = new BasePage();

    Logger log = LogManager.getLogger(YourCart.class.getSimpleName());

    @FindBy(xpath = "//span[@class=\"title\"]")
    WebElement title;

    @FindBy(name="continue-shopping")
    WebElement continueShoppingBtn;

    @FindBy(name="checkout")
    WebElement checkout;

    @FindBy(xpath = "//div[contains(@class,\"inventory_item_name\")]")
    List<WebElement> itemNames;

    @FindBy(xpath = "//div[contains(@class,\"inventory_item_price\")]")
    List<WebElement> itemPrices;

    @FindBy(xpath = "//div[@class=\"cart_quantity\"]")
    List<WebElement> itemQuantities;

    @FindBy(xpath = "//*[contains(@class,\"cart_button\")]")
    List<WebElement> itemRemoveBtns;

    @FindBy(xpath = "//*[@class=\"cart_item\"]//a")
    List<WebElement> itemLinks;

    public YourCart() {
        PageFactory.initElements(driver, this);
    }

    public Map<String,Object> listShoppingCartItems() {
        AtomicInteger idx = new AtomicInteger();
        Map<String,Object> shoppingCartItems = new LinkedHashMap<>();
        itemNames.forEach(i -> {
            log.info("Shopping Cart Item #" + idx.get() + " => " + i.getText());
            shoppingCartItems.put(i.getText(), idx.getAndIncrement());
        });
        return shoppingCartItems;
    }

    public void removeShoppingCartItems(List<String> items) {
        for (String item:items) {
            Map<String,Object> cartItems = listShoppingCartItems();
            AtomicInteger cartItemIdx = new AtomicInteger();
            cartItems.forEach((k,v) -> {
                if (item.equalsIgnoreCase(k)) {
                    removeShoppingCartItem(cartItemIdx.get());
                }
                cartItemIdx.getAndIncrement();
                TestListenerClass.testStepScreenshot("removing_item_" + item);
            });
            bp.waitTimer(2);
        }
    }

    private void removeShoppingCartItem(int idx) {
        itemRemoveBtns.get(idx).click();
    }

    public boolean checkItemCount(String itemName, int count) {
        List<String> itemNameList = new ArrayList<>();
        itemNames.forEach(i -> itemNameList.add(i.getText()));
        int itemIdx = itemNameList.indexOf(itemName);
        log.info("Item Idx: " + itemIdx + " for => " + itemName);
        String currentQtyForItem = itemQuantities.get(itemIdx).getText();
        log.info("Item Qty: " + currentQtyForItem);
        return String.valueOf(count).equalsIgnoreCase(currentQtyForItem);
    }

    public void returnToProductsPage() {
        continueShoppingBtn.click();
    }

}
