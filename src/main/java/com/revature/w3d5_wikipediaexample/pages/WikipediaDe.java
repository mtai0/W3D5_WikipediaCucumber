package com.revature.w3d5_wikipediaexample.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class WikipediaDe {
    private WebDriver driver;

    public WikipediaDe(WebDriver driver) {
        this.driver = driver;
    }

    private void confirmTitle() {
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.titleIs("Wikipedia – Die freie Enzyklopädie"));
    }

    public String getTitle() {
        confirmTitle();
        return driver.getTitle();
    }
}
