/*
 * MIT License
 *
 * Copyright (c) 2018 Elias Nogueira
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */

package com.eliasnogueira.page.swager;

import com.eliasnogueira.driver.DriverManager;
import com.eliasnogueira.page.AbstractPageObject;
import io.qameta.allure.Step;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;

import org.openqa.selenium.support.ui.WebDriverWait;


public class ProductPage extends AbstractPageObject {
    
    @FindBy(id = "menu_button_container")
    private WebElement menu;

    @FindBy(css = "#header_container > div.primary_header > div.header_label > div")
    private WebElement title;

    @FindBy(id = "react-burger-menu-btn")
    private WebElement btnMenu;

    @FindBy(css=".bm-menu-wrap > .bm-menu")
    private WebElement menuWrapper;

    @FindBy(id="logout_sidebar_link")
    private WebElement btnLogOut;

    @FindBy(css = "div.inventory_container>div>div")
    private WebElement listItem;
    
    @FindBy(how = How.CSS, using = "div.inventory_item")
    private List<WebElement> item;


    @Step
    public void openMenu() {
        this.btnMenu.click();

        // WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(3));
        // wait.until(ExpectedConditions.stalenessOf(DriverManager.getDriver().findElement(By.cssSelector(".bm-menu-wrap > .bm-menu"))));
        // wait.until(ExpectedConditions.stalenessOf(menuWrapper));
    }

    @Step
    public void openMenu(String menu) {
        this.btnMenu.click();

        // WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(3));
        // wait.until(ExpectedConditions.stalenessOf(DriverManager.getDriver().findElement(By.cssSelector(".bm-menu-wrap > .bm-menu"))));

    }

    @Step
    public int getListItem() {
        // return listItem.findElements(By.cssSelector("div>div")).size();
        return item.size();
        // return DriverManager.getDriver().findElements(By.cssSelector("inventory_list")).size();
    }


    @Step
    public String getPageTile() {

        return title.getText();

    }

    @Step
    public void logOut() {
        
        WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(2));
        // wait.until(ExpectedConditions.stalenessOf(menuWrapper));
        wait.until(ExpectedConditions.presenceOfElementLocated((By.cssSelector(".bm-menu-wrap > .bm-menu"))));

        wait.until(ExpectedConditions.elementToBeClickable((By.id("logout_sidebar_link"))));

        btnLogOut.click();
    }
}