package com.revature.w3d5_wikipediaexample.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class WikipediaEs {
    private WebDriver driver;

    public WikipediaEs(WebDriver driver) {
        this.driver = driver;
    }

    private void confirmTitle() {
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.titleIs("Wikipedia, la enciclopedia libre"));
    }

    public String getTitle() {
        confirmTitle();
        return driver.getTitle();
    }
}
