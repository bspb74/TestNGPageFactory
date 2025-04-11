package com.testng.qa.testcases;

import com.testng.qa.pageNavigation.BasePage;
import com.testng.qa.pagesSauceLabs.LoginPage;
import com.testng.qa.pagesSauceLabs.ProductsPage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class SauceLabsLogin {

    LoginPage lp = new LoginPage();
    ProductsPage pp = new ProductsPage();
    BasePage bp = new BasePage();

    Logger log = LogManager.getLogger(SauceLabsLogin.class.getSimpleName());

    public void Test_sauceLabsLogin(String uname, String pwd) {
        lp.loginToSauceLabs(uname, pwd);
    }

    public void Test_SelectSorting(String sortTxt) {
        pp.selectSorting(sortTxt);
        bp.waitTimer(2);
    }

}
