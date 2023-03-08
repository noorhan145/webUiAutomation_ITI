package org.example.stepDefs;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pages.P03_homePage;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class D03_currenciesStepDef {
    P03_homePage home = new P03_homePage();

    @When("user select Euro currency from the dropdown list")
    public void chooseEuro(){
        Select Euro = new Select(home.currency());
        Euro.selectByVisibleText("Euro");
    }

    @Then("user show products with Euro Symbol displayed in Home page")
    public void verifyProductsWithEuroSymbol(){
        int productSize = home.productPrice().size();
        System.out.println("size is "+productSize);
        for (int i=0;i<productSize;i++){
            String price = home.productPrice().get(i).getText();
            Assert.assertTrue(price.contains("€"));
            System.out.println(price);
        }
    }

}
