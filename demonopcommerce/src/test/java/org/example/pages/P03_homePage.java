package org.example.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

import static org.example.stepDefs.Hooks.driver;

public class P03_homePage {
    public WebElement currency(){
        return driver.findElement(By.id("customerCurrency"));
    }

    public List<WebElement> productPrice(){
        return driver.findElements(By.className("actual-price"));
    }

    public WebElement searchField(){
        return driver.findElement(By.id("small-searchterms"));
    }

    public WebElement searchBtn(){
        return driver.findElement(By.className("search-box-button"));
    }

    public WebElement productsPageSize(){
        return driver.findElement(By.id("products-pagesize"));
    }

    public List<WebElement> productTitle(){
        return driver.findElements(By.xpath("//h2[@class=\"product-title\"]/a"));
    }

    public WebElement productSku(){
        return driver.findElement(By.className("sku"));
    }

    public String currentUrl(){
        return driver.getCurrentUrl();
    }

    public List<WebElement> categories(){
        return driver.findElements(By.xpath("//ul[@class=\"top-menu notmobile\"]/li"));
    }

    public List<WebElement> subCategories(){
        return driver.findElements((By.xpath("//ul[@class=\"top-menu notmobile\"]//ul[@class=\"sublist first-level\"]/li/a")));    }

    public WebElement pageTitle(){
        return driver.findElement(By.className("page-title"));
    }
}
