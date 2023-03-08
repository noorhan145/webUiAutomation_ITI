package org.example.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static org.example.stepDefs.Hooks.driver;

public class P04_contactUs {
    public WebElement contactLink(){
        return driver.findElement(By.xpath("//a [contains (text (), 'Contact us')]"));
    }

    public WebElement yourName(){
        return driver.findElement(By.id("FullName"));
    }

    public WebElement yourEmail(){
        return driver.findElement(By.id("Email"));
    }

    public WebElement enquiry(){
        return driver.findElement(By.id("Enquiry"));
    }

    public WebElement submitBtn(){
        return driver.findElement(By.name("send-email"));
    }

    public WebElement succMsg(){
        return driver.findElement(By.cssSelector("div[class=\"result\"]"));
    }
}
