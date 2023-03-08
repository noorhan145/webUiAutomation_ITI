package org.example.stepDefs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pages.P03_homePage;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;


import java.time.Duration;
import java.util.concurrent.TimeUnit;

import static org.example.stepDefs.Hooks.driver;

public class D05_hoverCategoriesStepDef {
    P03_homePage home = new P03_homePage();
    Actions action = new Actions(driver);
    int randomCategoryInt;
    int randomCategoryInt7;
    String categoryName = null;

    @When("user hover on random one of the three main categories")
    public void hoverCategoryWithSub(){
        randomCategoryInt = (int)Math.floor(Math.random()*(2-0+1)+0);
        action.moveToElement(home.categories().get(randomCategoryInt)).perform();
    }

    public int getRandomCategoryInt(){
        return randomCategoryInt;
    }

    @And("user select random one of the three sub categories")
    public void selectSubCategory(){
        int min=0,max=0;
        if (getRandomCategoryInt()==0){
            min = 0;
            max = 1;
        }
        else if (getRandomCategoryInt()==1){
            min = 3;
            max = 5;
        }
        else if (getRandomCategoryInt()==2){
            min = 6;
            max = 8;
        }
        int random_int = (int)Math.floor(Math.random()*(max-min+1)+min);
        WebDriverWait t = new WebDriverWait(driver, Duration.ofSeconds(8));
        t.until(ExpectedConditions.elementToBeClickable(home.subCategories().get(random_int)));
        categoryName = home.subCategories().get(random_int).getText().toLowerCase().trim();
        home.subCategories().get(random_int).click();
    }

    public String getCategoryName() {
        return categoryName;
    }



    @Then("user show the selected sub category page")
    public void categoryPage(){
        String pageTitle = home.pageTitle().getText().toLowerCase().trim();
        Assert.assertTrue(pageTitle.contains(getCategoryName()));
    }

    @When("user hover on any random category whether it contains sub category or not")
    public void hoverCategory(){
        randomCategoryInt7 = (int)Math.floor(Math.random()*(6-0+1)+0);
        action.moveToElement(home.categories().get(randomCategoryInt7)).perform();
    }

    public int getRandomCategoryInt7(){
        return randomCategoryInt7;
    }

    @And("user select either random one of sub categories or one of the main categories that not contains sub category")
    public void selectCategory(){
        int min=0,max=0;
        if(getRandomCategoryInt7() >= 0 && getRandomCategoryInt7() <= 2){
            if (getRandomCategoryInt7()==0){
                min = 0;
                max = 1;
            }
            else if (getRandomCategoryInt7()==1){
                min = 3;
                max = 5;
            }
            else if (getRandomCategoryInt7()==2){
                min = 6;
                max = 8;
            }

            int random_int = (int)Math.floor(Math.random()*(max-min+1)+min);
            WebDriverWait t = new WebDriverWait(driver, Duration.ofSeconds(8));
            t.until(ExpectedConditions.elementToBeClickable(home.subCategories().get(random_int)));
            categoryName = home.subCategories().get(random_int).getText().toLowerCase().trim();
            home.subCategories().get(random_int).click();
        }

        else if(getRandomCategoryInt7() >= 3 && getRandomCategoryInt7() <= 6){
            min = 3;
            max = 6;
            int random_int = (int)Math.floor(Math.random()*(max-min+1)+min);
            categoryName = home.categories().get(random_int).getText().toLowerCase().trim();
            home.categories().get(random_int).click();
        }



    }

}
