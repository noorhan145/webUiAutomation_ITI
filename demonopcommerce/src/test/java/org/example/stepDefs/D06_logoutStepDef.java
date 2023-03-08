package org.example.stepDefs;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pages.P02_login;
import org.testng.Assert;

public class D06_logoutStepDef {
    P02_login login = new P02_login();

    @Given("user is logged in")
    public void login(){
        login.loginLink().click();
        login.email().sendKeys("test@example.com");
        login.password().sendKeys("P@ssw0rd");
        login.loginBtn().click();
    }

    @When("user click on logout icon")
    public void logout(){
        login.logout().click();
    }

    @Then("user logout from the system successfully")
    public void succLogout(){
        String loginIcon = login.loginLink().getText().toLowerCase().trim();
        Assert.assertEquals(loginIcon,"log in");
    }
}
