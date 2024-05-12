package com.revature.w3d5_wikipediaexample.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class WikipediaSearch {
    private WebDriver driver;

    public WikipediaSearch(WebDriver driver) {
        this.driver = driver;
    }

    public void confirmNotOnHomepage() {
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.not(ExpectedConditions.titleIs("Wikipedia")));
    }

    public boolean noResultsFound() {
        return !driver.findElements(By.className("mw-search-nonefound")).isEmpty();
    }
}
