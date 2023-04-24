
package com.eliasnogueira.test;

import com.eliasnogueira.BaseWeb;
import com.eliasnogueira.data.dynamic.SwagLabData;
import com.eliasnogueira.page.swager.LoginPage;
import com.eliasnogueira.page.swager.ProductPage;

import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class SwagLabsTest extends BaseWeb {

    @Test(description = "Login account standard")
    public void loginAndCheckProduct() {
        var loginAccount = SwagLabData.loadLoginData(0);

        var loginPage = new LoginPage();
        loginPage.fillEmail(loginAccount.getEmail());
        loginPage.fillPassword(loginAccount.getPassword());
        loginPage.submitLogin();

        var productPage = new ProductPage();
        assertThat(productPage.getPageTile()).isEqualTo("Swag Labs");
        assertThat(productPage.getListItem()).isEqualTo(6);

        productPage.openMenu();
        productPage.logOut();
    }

    @Test(description = "Login account problem_user")
    public void loginAndCheckProductWithProblemUser() {
        var loginAccount = SwagLabData.loadLoginData(2);

        var loginPage = new LoginPage();
        loginPage.fillEmail(loginAccount.getEmail());
        loginPage.fillPassword(loginAccount.getPassword());
        loginPage.submitLogin();

        var productPage = new ProductPage();
        assertThat(productPage.getPageTile()).isEqualTo("Swag Labs");
        assertThat(productPage.getListItem()).isEqualTo(6);

        productPage.openMenu();
        productPage.logOut();
    }


    @Test(description = "Login account performance_glitch_user")
    public void loginAndCheckProductWithPerformance_glitch_user() {
        var loginAccount = SwagLabData.loadLoginData(3);

        var loginPage = new LoginPage();
        loginPage.fillEmail(loginAccount.getEmail());
        loginPage.fillPassword(loginAccount.getPassword());
        loginPage.submitLogin();

        var productPage = new ProductPage();
        assertThat(productPage.getPageTile()).isEqualTo("Swag Labs");
        assertThat(productPage.getListItem()).isEqualTo(6);

        productPage.openMenu();
        productPage.logOut();
    }
}
