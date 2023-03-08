package org.example.stepDefs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pages.P02_login;
import org.openqa.selenium.support.Color;
import org.testng.asserts.SoftAssert;

public class D02_loginStepDef {
    P02_login login = new P02_login();
    SoftAssert softAssert = new SoftAssert();

    @Given("user go to login page")
    public void navigateToLoginPage(){
        login.loginLink().click();
    }

    @When("user login with \"valid\" \"test@example.com\" and \"P@ssw0rd\"")
    public void enterValidEmailAndPassword(){
        login.email().sendKeys("test@example.com");
        login.password().sendKeys("P@ssw0rd");
    }

    @And("user press on login button")
    public void pressLogin(){
        login.loginBtn().click();
    }

    @Then("user login to the system successfully")
    public void succLogin(){
        Boolean myAccountIconDisplayed = login.myAccountIcon().isDisplayed();
        softAssert.assertTrue(myAccountIconDisplayed);
        softAssert.assertEquals(login.currentUrl(),"https://demo.nopcommerce.com/");
        softAssert.assertAll();
    }

    @When("user login with \"invalid\" \"wrong@example.com\" and \"P@ssw0rd\"")
    public void enterInvalidEmailAndPassword(){
        login.email().sendKeys("wrong@example.com");
        login.password().sendKeys("P@ssw0rd");
    }

    @Then("user could not login to the system")
    public void unsuccLogin(){
        String errMsg = login.errMsg().getText();
        softAssert.assertTrue(errMsg.contains("Login was unsuccessful."));
        String errMsgColor = login.errMsg().getCssValue("color");
        //Color.fromString(errMsgColor).asHex();
        softAssert.assertEquals(errMsgColor,"rgba(228, 67, 75, 1)");
        softAssert.assertAll();
    }
}
