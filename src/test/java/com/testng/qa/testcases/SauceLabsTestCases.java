package com.testng.qa.testcases;

import com.testng.qa.pagesSauceLabs.SauceLabsPages;
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
        Assert.assertEquals(sortMap.get(sortTxt), selectedItem);
        BASE_PAGE.waitTimer(1);
    }

    public void Test_getItemByLocationAfterSorting(String sortTxt, String itemLocation, String itemName) {
        PRODUCTS_PAGE.selectSorting(sortTxt);
        String prodName = PRODUCTS_PAGE.getFirstOrLastItemName(itemLocation);
        log.info(itemLocation.toUpperCase() + " => " + prodName);
        Assert.assertEquals(itemName, prodName);
        BASE_PAGE.waitTimer(1);
    }

    public void Test_getItemInfoByName(String name) {
        Map<String,Object> itemMap = PRODUCTS_PAGE.getItemInfo(name, false);
        for (Map.Entry m:itemMap.entrySet()) {
            log.info("Item from Map: " + m.getKey().toString());
        }
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
    }

    public void Test_addProductsToCart(Map<String,String> items) {
        AtomicInteger addedIdx = new AtomicInteger();
        items.forEach((k,v) -> {
            PRODUCTS_PAGE.addRemoveItemFromShoppingCart(k, v);
            BASE_PAGE.waitTimer(1);
            if ("add".equalsIgnoreCase(v)) {
                addedIdx.getAndIncrement();
            }
        });
        int cartCount = PRODUCTS_PAGE.getCartCount();
        log.info("Cart Count: " + cartCount);
        Assert.assertEquals(addedIdx.get(), cartCount);
        BASE_PAGE.waitTimer(5);
        PRODUCTS_PAGE.clickShoppingCartBtn();
        YOUR_CART.listShoppingCartItems();
        List<String> removeItemsList = new ArrayList<>(Arrays.asList("Sauce Labs Bolt T-Shirt",
                "Test.allTheThings() T-Shirt (Red)"));
        YOUR_CART.removeShoppingCartItems(removeItemsList);
        BASE_PAGE.waitTimer(10);
    }

    public void Test_verifyItemCountInCart(String itemName) {
        YOUR_CART.checkItemCount(itemName);
        BASE_PAGE.waitTimer(10);
        YOUR_CART.returnToProductsPage();
    }

    public void Test_individualProductPageByName(String itemName) {
        PRODUCTS_PAGE.navigateToItemPageByName(itemName);
        String productItemName = PRODUCT_PAGE.getItemName();
        Assert.assertEquals(itemName, productItemName);
        String itemAction = PRODUCT_PAGE.getItemButtonAction();
        if ("Add to cart".equalsIgnoreCase(itemAction)) {
            PRODUCT_PAGE.removeItem();
        } else {
            PRODUCT_PAGE.addItem();
        }
        BASE_PAGE.waitTimer(1);
        PRODUCTS_PAGE.clickShoppingCartBtn();
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
        PRODUCTS_PAGE.signOut();
        BASE_PAGE.waitTimer(1);
    }

}
