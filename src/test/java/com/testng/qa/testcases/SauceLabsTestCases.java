package com.testng.qa.testcases;

import com.testng.qa.pagesSauceLabs.SauceLabsPages;
import com.testng.qa.utility.ScreenShot;
import com.testng.qa.utility.TestListenerClass;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;

import java.util.*;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

public class SauceLabsTestCases implements SauceLabsPages {

    Logger log = LogManager.getLogger(SauceLabsTestCases.class.getSimpleName());

    public void Test_sauceLabsLogin(String uname, String pwd) {
        LOGIN_PAGE.loginToSauceLabs(uname, pwd);
    }

    public void Test_selectSorting(String sortTxt) {
        Map<String,String> sortMap = new HashMap<>();
        sortMap.put("az", "Name (A to Z)");
        sortMap.put("za", "Name (Z to A)");
        sortMap.put("hilo", "Price (high to low)");
        sortMap.put("lohi", "Price (low to high)");
        PRODUCTS_PAGE.selectSorting(sortTxt);
        String selectedItem = PRODUCTS_PAGE.getSelectedItem();
        TestListenerClass.testStepScreenshot("selectSorting_" + sortTxt);
        Assert.assertEquals(sortMap.get(sortTxt), selectedItem);
        BASE_PAGE.waitTimer(1);
    }

    public void Test_getItemByLocationAfterSorting(String sortTxt, String itemLocation, String itemName) {
        PRODUCTS_PAGE.selectSorting(sortTxt);
        String prodName = PRODUCTS_PAGE.getFirstOrLastItemName(itemLocation);
        log.info(itemLocation.toUpperCase() + " => " + prodName);
        TestListenerClass.testStepScreenshot("getItemByLocation_" + sortTxt + "-" + itemLocation);
        Assert.assertEquals(itemName, prodName);
        BASE_PAGE.waitTimer(1);
    }

    public void Test_getItemInfoByName(String name) {
        Map<String,Object> itemMap = PRODUCTS_PAGE.getItemInfo(name, false);
        for (Map.Entry m:itemMap.entrySet()) {
            log.info("Item from Map: " + m.getKey().toString());
        }
        TestListenerClass.testStepScreenshot("getItemInfo_" + name.replaceAll("\\s","-"));
    }

    public void Test_getAllItems() {
        List<Map<String,Object>> itemsList = PRODUCTS_PAGE.getItemMap();
        Set<String> keys = itemsList.get(0).keySet();
        log.warn("Number of map items: " + keys.size());
        itemsList.forEach(m -> {
            log.warn("#=====================================================");
            for(String s:keys) {
                log.info("Key: " + s + " => " + m.get(s).toString());
            }
        });
        TestListenerClass.testStepScreenshot("getAllItems");
    }

    public void Test_addProductsToCart(Map<String,String> items) {
        AtomicInteger addedIdx = new AtomicInteger();
        items.forEach((k,v) -> {
            PRODUCTS_PAGE.addRemoveItemFromShoppingCart(k, v);
            BASE_PAGE.waitTimer(1);
            if ("add".equalsIgnoreCase(v)) {
                addedIdx.getAndIncrement();
                TestListenerClass.testStepScreenshot("addItem_" + k);
            }
        });
        TestListenerClass.testStepScreenshot("productsPageAfterAddition");
        int cartCount = PRODUCTS_PAGE.getCartCount();
        log.info("Cart Count: " + cartCount);
        Assert.assertEquals(addedIdx.get(), cartCount);
        BASE_PAGE.waitTimer(5);
        PRODUCTS_PAGE.clickShoppingCartBtn();
        TestListenerClass.testStepScreenshot("shoppingCart");
        YOUR_CART.listShoppingCartItems();
        List<String> removeItemsList = new ArrayList<>(Arrays.asList("Sauce Labs Bolt T-Shirt",
                "Test.allTheThings() T-Shirt (Red)"));
        YOUR_CART.removeShoppingCartItems(removeItemsList);
        TestListenerClass.testStepScreenshot("shoppingCartAfterRemoval");
        BASE_PAGE.waitTimer(1);
    }

    public void Test_verifyItemCountInCart(String itemName, int count) {
        TestListenerClass.testStepScreenshot("gettingShoppingCartCount_" +
                itemName.replaceAll("\\s", "-"));
        boolean countVerified = YOUR_CART.checkItemCount(itemName, count);
        Assert.assertTrue(countVerified, "Count should be => " + count);
        BASE_PAGE.waitTimer(1);
        YOUR_CART.returnToProductsPage();
    }

    public void Test_individualProductPageByName(String itemName) {
        if (!BASE_PAGE.getPageTite().equalsIgnoreCase("Products")) {
            BASE_PAGE.navigateToAllItems();
        }
        PRODUCTS_PAGE.navigateToItemPageByName(itemName);
        TestListenerClass.testStepScreenshot("itemPage" + itemName);
        String productItemName = PRODUCT_PAGE.getItemName();
        Assert.assertEquals(itemName, productItemName);
        String itemAction = PRODUCT_PAGE.getItemButtonAction();
        if ("Add to cart".equalsIgnoreCase(itemAction)) {
            PRODUCT_PAGE.removeItem();
        } else {
            PRODUCT_PAGE.addItem();
        }
        TestListenerClass.testStepScreenshot("addOrRemoveItem_" + itemName);
        BASE_PAGE.waitTimer(1);
        PRODUCTS_PAGE.clickShoppingCartBtn();
        TestListenerClass.testStepScreenshot("shoppingCartForItem_" + itemName);
        Map<String,Object> cartItemsMap = YOUR_CART.listShoppingCartItems();
        AtomicBoolean itemInCart = new AtomicBoolean();
        cartItemsMap.forEach((k,v) -> {
            if (itemName.equalsIgnoreCase(k)) {
                itemInCart.set(true);
            }
        });
        if (itemInCart.get()) {
            log.info("Item \"" + itemName + "\" found in cart!");
        }
        Assert.assertTrue(itemInCart.get());
        BASE_PAGE.waitTimer(1);
        YOUR_CART.returnToProductsPage();
        BASE_PAGE.signOut();
        BASE_PAGE.waitTimer(1);
    }

}
