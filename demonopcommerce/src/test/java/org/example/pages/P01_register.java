package org.example.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static org.example.stepDefs.Hooks.driver;

public class P01_register {
    public WebElement registerlink()
    {
        return driver.findElement(By.className("ico-register"));
    }

    public WebElement genderFemale()
    {
        return driver.findElement(By.id("gender-female"));
    }

    public WebElement genderMale()
    {
        return driver.findElement(By.id("gender-male"));
    }

    public WebElement firstname()
    {
        return driver.findElement(By.id("FirstName"));
    }

    public WebElement lastname()
    {
        return driver.findElement(By.id("LastName"));
    }

    public WebElement listOfDays()
    {
        return driver.findElement(By.name("DateOfBirthDay"));
    }

    public WebElement listOfMon(){
        return  driver.findElement(By.name("DateOfBirthMonth"));
    }

    public WebElement listOfYear(){
        return  driver.findElement(By.name("DateOfBirthYear"));
    }

    public WebElement email(){
        return  driver.findElement(By.id("Email"));
    }

    public WebElement company(){
        return  driver.findElement(By.id("Company"));
    }

    public WebElement password(){
        return  driver.findElement(By.id("Password"));
    }

    public WebElement confirmPassword(){
        return  driver.findElement(By.id("ConfirmPassword"));
    }

    public WebElement registerButton(){
        return  driver.findElement(By.id("register-button"));
    }

    public WebElement registrationSuccMsg(){
        return  driver.findElement(By.className("result"));
    }

    public WebElement existingEmail(){
        return driver.findElement(By.className("message-error"));
    }
}
