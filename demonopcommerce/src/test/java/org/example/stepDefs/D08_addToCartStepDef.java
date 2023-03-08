package org.example.stepDefs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pages.P05_shoppingCart;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import java.time.Duration;

import static org.example.stepDefs.Hooks.driver;


public class D08_addToCartStepDef {
    P05_shoppingCart shoppingCart = new P05_shoppingCart();
    SoftAssert softAssert = new SoftAssert();
    String productTitle1 = "";
    String productTitle2 = "";
    String productPrice1 = "";
    String productPrice2 = "";

    @Given("user go to one of categories page")
    public void selectCategory(){
        shoppingCart.booksCategory().click();
    }


    @When("user click on 'ADD TO CART' button of the first product")
    public void addToCart(){
        shoppingCart.addToCartBtn().get(0).click();
        productTitle1 = shoppingCart.productTitle().get(0).getText();
        productPrice1 = shoppingCart.productPrice().get(0).getText();



    }

    public String getProductTitle1(){
        return productTitle1;
    }

    public String getProductPrice1(){
        return productPrice1;
    }

    @And("user click on 'ADD TO CART' button of the second product")
    public void addToCart2(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.invisibilityOf(shoppingCart.successBar()));
        shoppingCart.addToCartBtn().get(1).click();
        productTitle2 = shoppingCart.productTitle().get(1).getText();
        productPrice2 = shoppingCart.productPrice().get(1).getText();
    }

    public String getProductTitle2(){
        return productTitle2;
    }

    public String getProductPrice2(){
        return productPrice2;
    }

    @And("user click on 'ADD TO CART' button of the second product again")
    public void addToCart3(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.invisibilityOf(shoppingCart.successBar()));
        shoppingCart.addToCartBtn().get(1).click();
    }

    @And("user navigate to shopping cart")
    public void goToShoppingCart(){
        shoppingCart.shoppingCartIcon().click();
    }

    @Then("products added to the shopping cart")
    public void succAddToCart(){
        softAssert.assertEquals(shoppingCart.productNameInCart().get(0).getText(),getProductTitle1());
        softAssert.assertEquals(shoppingCart.productPriceInCart().get(0).getText(),getProductPrice1());
        String productQuantity1 = shoppingCart.productQuantityInCart().get(0).getAttribute("value");
        softAssert.assertEquals(productQuantity1,"1");
        softAssert.assertEquals(shoppingCart.productNameInCart().get(1).getText(),getProductTitle2());
        softAssert.assertEquals(shoppingCart.productPriceInCart().get(1).getText(),getProductPrice2());
        String productQuantity2 = shoppingCart.productQuantityInCart().get(1).getAttribute("value");
        softAssert.assertEquals(productQuantity2,"2");
        softAssert.assertAll();

    }

    @And("the subTotal is correct")
    public void correctSubTotal(){
        int productPrice1 = Integer.parseInt(getProductPrice1().replaceAll("[^0-9]", ""));
        int productPrice2 = Integer.parseInt(getProductPrice2().replaceAll("[^0-9]", ""));
        String subTotalStr = shoppingCart.subTotal().getText();
        int subTotal = Integer.parseInt(subTotalStr.replaceAll("[^0-9]", ""));
        softAssert.assertEquals(productPrice1+(productPrice2*2),subTotal);
        softAssert.assertAll();
    }
}
