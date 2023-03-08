package org.example.stepDefs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pages.P03_homePage;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

public class D04_searchStepDef {
    P03_homePage home = new P03_homePage();
    SoftAssert softAssert2 = new SoftAssert();

    @When("user enter in search field product name {string}")
    public void enterProductName(String proName){
        home.searchField().sendKeys(proName);
    }

    @And("user click on search button")
    public void pressSearchButton(){
        home.searchBtn().click();
    }

    @Then("products with {string} search keyword are shown")
    public void verifyProductTitleWithProName(String proName){
        Select pageSize = new Select(home.productsPageSize());
        pageSize.selectByValue("18");
        softAssert2.assertTrue(home.currentUrl().contains("https://demo.nopcommerce.com/search?q="));
        int size = home.productTitle().size();
        for (int i=0;i<size;i++){
            SoftAssert softAssert = new SoftAssert();
            String productTitle = home.productTitle().get(i).getText().toLowerCase();
            System.out.println("title  "+productTitle);
            System.out.println("proName   "+proName);
            softAssert.assertTrue(productTitle.contains(proName));
            softAssert.assertAll();

        }
    }

    @When("user enter in search field product sku {string}")
    public void userEnterInSearchFieldProductSku(String proSku) {
        home.searchField().sendKeys(proSku);
    }

    @Then("products with {string} sku are shown")
    public void verifyProductTitleWithSku(String proSku){
        home.productTitle().get(0).click();
        String productTitle = home.productSku().getText();
        Assert.assertTrue(productTitle.contains(proSku));
    }

}
