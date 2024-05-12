package com.revature.w3d5_wikipediaexample.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class WikipediaArticleGeneric {
    private WebDriver driver;

    @FindBy(id = "ca-nstab-main")
    WebElement articleTab;

    public WikipediaArticleGeneric(WebDriver driver) {
        this.driver = driver;
    }

    public void confirmNotOnHomepage() {
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.not(ExpectedConditions.titleIs("Wikipedia")));
    }

    public boolean isArticle() {
        try {
            new WebDriverWait(driver, Duration.ofSeconds(5)).until(ExpectedConditions.visibilityOf(articleTab));
            return true;
        }
        catch (Exception e) {
            System.out.println("Could not find Article element.");
            e.printStackTrace();
        }
        return false;
    }

    //This may have many points of failure, don't use this.
    /*public boolean titleContains(String text) {
        String title = driver.getTitle().toLowerCase();
        return title.contains(text.toLowerCase());
    }*/
}
