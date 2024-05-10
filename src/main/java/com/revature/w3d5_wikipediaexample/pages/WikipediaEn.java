package com.revature.w3d5_wikipediaexample.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class WikipediaEn {
    private WebDriver driver;

    public WikipediaEn(WebDriver driver) {
        this.driver = driver;
    }

    private void confirmTitle() {
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.titleIs("Wikipedia, the free encyclopedia"));
    }

    public String getTitle() {
        confirmTitle();
        return driver.getTitle();
    }
}
