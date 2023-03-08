package org.example.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

import static org.example.stepDefs.Hooks.driver;

public class P05_shoppingCart {
    public WebElement booksCategory(){
        return driver.findElement(By.xpath("(//ul[@class=\"top-menu notmobile\"]/li/a)[5]"));
    }

    public List<WebElement> productTitle(){
        return driver.findElements(By.xpath("//h2[@class=\"product-title\"]/a"));
    }

    public List<WebElement> productPrice(){
        return driver.findElements(By.cssSelector("span[class=\"price actual-price\"]"));
    }

    public List<WebElement> productNameInCart(){
        return driver.findElements(By.xpath("//td[@class=\"product\"]/a"));
    }


    public List<WebElement> productPriceInCart(){
        return driver.findElements(By.xpath("//td[@class=\"unit-price\"]/span"));
    }

    public List<WebElement> productQuantityInCart(){
        return driver.findElements(By.className("qty-input"));
    }

    public List<WebElement> addToCartBtn(){
        return driver.findElements(By.className("product-box-add-to-cart-button"));
    }

    public WebElement shoppingCartIcon(){
        return driver.findElement(By.xpath("//p[@class=\"content\"]/a"));
    }

    public WebElement successBar(){
        return driver.findElement(By.cssSelector("div[class=\"bar-notification success\"]"));
    }

    public WebElement subTotal(){
        return driver.findElement(By.xpath("(//span[@class=\"value-summary\"])[1]"));
    }
}
