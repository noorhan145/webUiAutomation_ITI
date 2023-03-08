package org.example.stepDefs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pages.P04_contactUs;
import org.testng.Assert;

public class D07_contactUsStepDef {
    P04_contactUs contactUs = new P04_contactUs();

    @When("user click on 'Contact us' link")
    public void clickContactUs(){
        contactUs.contactLink().click();
    }

    @And("user enter his name in 'Your name' field")
    public void enterName(){
        contactUs.yourName().sendKeys("nn");
    }

    @And("user enter his email in 'Your email' field")
    public void enterEmail(){
        contactUs.yourEmail().sendKeys("test@example.com");
    }

    @And("user enter his enquiry in 'enquiry' field")
    public void enterEnquiry(){
        contactUs.enquiry().sendKeys("This is an enquiry massage");
    }

    @And("user click 'Submit' button")
    public void clickSubmit(){
        contactUs.submitBtn().click();
    }

    @Then("user enquiry has been successfully sent")
    public void succMsg(){
        String succMsg = contactUs.succMsg().getText().toLowerCase().trim();
        Assert.assertTrue(succMsg.contains("your enquiry has been successfully sent"));
    }
}
