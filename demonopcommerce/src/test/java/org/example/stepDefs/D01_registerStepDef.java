package org.example.stepDefs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pages.P01_register;
import org.openqa.selenium.support.ui.Select;
import org.testng.asserts.SoftAssert;

public class D01_registerStepDef {

    P01_register register = new P01_register();
    SoftAssert softAssert = new SoftAssert();
    @Given("user go to register page")
    public void goRegisterPage()
    {
        register.registerlink().click();
    }

    @When("user select gender type")
    public void selectGender(){
        register.genderFemale().click();
    }

    @And("user enter first name \"automation\" and last name \"tester\"")
    public void enterFnameAndLname(){
        register.firstname().sendKeys("automation");
        register.lastname().sendKeys("tester");
    }

    @And("user enter date of birth")
    public void enterDateOfBirth(){
        Select downDay = new Select(register.listOfDays());
        int randIntDay = (int) Math.floor(Math.random()*(32-1+1)+1);
        downDay.selectByIndex(randIntDay);
        Select downMon = new Select(register.listOfMon());
        int randIntMon = (int) Math.floor(Math.random()*(12-1+1)+1);
        downMon.selectByIndex(randIntMon);
        Select downYear = new Select(register.listOfYear());
        int randIntYear = (int) Math.floor(Math.random()*(111-1+1)+1);
        downYear.selectByIndex(randIntYear);
    }

    @And("user enter email \"test@example.com\" field")
    public void enterEmail(){
        int randIntNum = (int) Math.floor(Math.random()*(1000-1+1)+1);
        register.email().sendKeys("test"+randIntNum+"@example.com");
    }

    @And("user fills Password fields \"P@ssw0rd\" \"P@ssw0rd\"")
    public void enterPassword(){
        register.password().sendKeys("P@ssw0rd");
        register.confirmPassword().sendKeys("P@ssw0rd");
    }

    @And("user clicks on register button")
    public void clickRegisterButton(){
        register.registerButton().click();
    }

    @Then("success message is displayed")
    public void succRegister(){
        String succMsgText = register.registrationSuccMsg().getText();
        softAssert.assertTrue(succMsgText.contains("registration completed"));
        String succMsgColor = register.registrationSuccMsg().getCssValue("color");
        softAssert.assertEquals(succMsgColor,"rgba(76, 177, 124, 1)");
        softAssert.assertAll();
    }

    @And("user enter existing email \"test@example.com\" field")
    public void enterExistingEmail(){
        register.email().sendKeys("test@example.com");
    }

    @Then("existing email massage is displayed")
    public void existingEmailMsg(){
        String existingEmail = register.existingEmail().getText();
        softAssert.assertTrue(existingEmail.contains("email already exists"));
        String existingEmailMsgColor = register.existingEmail().getCssValue("color");
        softAssert.assertEquals(existingEmailMsgColor,"rgba(228, 67, 75, 1)");
        softAssert.assertAll();
    }
}
