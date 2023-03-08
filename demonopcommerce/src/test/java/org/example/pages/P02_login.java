package org.example.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static org.example.stepDefs.Hooks.driver;

public class P02_login {
    public WebElement loginLink(){
        return driver.findElement(By.className("ico-login"));
    }

    public WebElement email(){
        return driver.findElement(By.id("Email"));
    }

    public WebElement password(){
        return driver.findElement(By.id("Password"));
    }

    public WebElement loginBtn(){
        return driver.findElement(By.cssSelector("button[class=\"button-1 login-button\"]"));
    }

    public WebElement myAccountIcon(){
        return driver.findElement(By.className("ico-account"));
    }

    public WebElement errMsg(){
        return driver.findElement(By.cssSelector("div[class=\"message-error validation-summary-errors\"]"));
    }

    public String currentUrl(){
        return driver.getCurrentUrl();
    }

    public WebElement logout(){
        return driver.findElement(By.className("ico-logout"));

    }
}
