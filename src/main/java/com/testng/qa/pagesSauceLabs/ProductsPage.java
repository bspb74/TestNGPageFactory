package com.testng.qa.pagesSauceLabs;

import com.testng.qa.base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.*;

public class ProductsPage extends TestBase {

    private static Logger log = LogManager.getLogger(ProductsPage.class.getSimpleName());

    @FindBy(xpath = "//span[@class=\"title\"]")
    WebElement title;

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

    @FindBy(xpath = "//a[contains(@class,'shopping_cart_link')]")
    WebElement cartLink;

    @FindBy(xpath = "//select[contains(@class,'product_sort_container')]")
    WebElement productSort;

    @FindBy(xpath = "//div[contains(@class,\"inventory_item_name\")]")
    List<WebElement> itemNames;

    @FindBy(xpath = "//span[contains(@class,\"active_option\")]")
    WebElement sortSelectedItem;

    @FindBy(xpath = "//div[contains(@class,\"inventory_item_price\")]")
    List<WebElement> itemPrices;

    @FindBy(xpath = "//div[contains(@class,\"inventory_item_label\")]//div[contains(@class,\"inventory_item_desc\")]")
    List<WebElement> itemDesriptions;

    @FindBy(xpath = "//button[contains(@class,\"btn_inventory\")]")
    List<WebElement> addToCartBtnList;

    @FindBy(xpath = "//span[contains(@class,\"shopping_cart_badge\")]")
    WebElement shoppingCartBadge;

    @FindBy(xpath = "//a[contains(@class,\"shopping_cart_link\")]")
    WebElement shoppingCartBtn;

    @FindBy(xpath = "//div[@class=\"inventory_item_label\"]/a")
    List<WebElement> itemLinks;

    public ProductsPage() {
        PageFactory.initElements(driver, this);
    }

    public void selectSorting(String option) {
        Select opts = new Select(productSort);
        opts.selectByValue(option);
    }

    public String getFirstOrLastItemName(String locator) {
        if ("first".equalsIgnoreCase(locator)) {
            return itemNames.get(0).getText();
        } else {
            return itemNames.get(itemNames.size() - 1).getText();
        }
    }

    public String getSelectedItem() {
        return sortSelectedItem.getText();
    }

    public Map<String, Object> getItemInfo(String itemName, boolean addToCart) {
        Map<String, Object> itemMap = new HashMap<>();
        String price;
        itemMap.put("name", itemName);
        int idx = getItemIdx(itemName);
        price = itemPrices.get(idx).getText();
        log.warn("Item: " + itemName + " => " + price);
        if (null != price) {
            itemMap.put("price", price);
        }
        if (addToCart) {
            addToCartBtnList.get(idx);
        }
        return itemMap;
    }

    public List<Map<String, Object>> getItemMap() {
        List<Map<String, Object>> itemListOfMaps = new ArrayList<>();
        Map<String, Object> itemMap;
        String name;
        String desc;
        String price;
        for (int i = 0; i < itemNames.size(); i++) {
            itemMap = new LinkedHashMap<>();
            name = itemNames.get(i).getText();
            desc = itemDesriptions.get(i).getText();
            price = itemPrices.get(i).getText();
            itemMap.put("name", name);
            itemMap.put("desc", desc);
            itemMap.put("price", price);
            itemMap.put("listIdx", i);
            itemListOfMaps.add(itemMap);
        }
        return itemListOfMaps;
    }

    public void addRemoveItemFromShoppingCart(String name, String addRemove) {
        int idx = getItemIdx(name);
        String itemButtonAction = addToCartBtnList.get(idx).getText();
        if (addRemove.equalsIgnoreCase("add")) {
            if ("Add to cart".equalsIgnoreCase(itemButtonAction)) {
                addToCartBtnList.get(idx).click();
            }
        } else if ("Remove".equalsIgnoreCase(itemButtonAction)) {
            addToCartBtnList.get(idx).click();
        }
    }

    private int getItemIdx(String name) {
        for (int i = 0; i < itemNames.size(); i++) {
            if (name.equalsIgnoreCase(itemNames.get(i).getText())) {
                return i;
            }
        }
        return 0;
    }

    public int getCartCount() {
        return Integer.parseInt(shoppingCartBadge.getText());
    }

    public void clickShoppingCartBtn() {
        shoppingCartBtn.click();
    }

    public void navigateToItemPageByName(String itemName) {
        int itemIdx = getItemIdx(itemName);
        itemLinks.get(itemIdx).click();
    }

    public void signOut() {
        appMenuBtn.click();
        logoutLink.click();
    }
}
