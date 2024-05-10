package com.revature.w3d5_wikipediaexample.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class WikipediaHomepage {
    private WebDriver driver;
    private WebDriverWait genericWait;

    @FindBy(css = "a[href='//en.wikipedia.org/']")
    WebElement buttonEN;

    @FindBy(css = "a[href='//es.wikipedia.org/']")
    WebElement buttonES;

    @FindBy(css = "a[href='//de.wikipedia.org/']")
    WebElement buttonDE;

    public WikipediaHomepage(WebDriver driver) {
        this.driver = driver;
        genericWait = new WebDriverWait(driver, Duration.ofSeconds(5));
    }

    public void getHomepage() {
        driver.get("https://www.wikipedia.org/");
    }

    public String getTitle() {
        return driver.getTitle();
    }

    public void clickEN() {
        genericWait.until(ExpectedConditions.elementToBeClickable(buttonEN)).click();
    }

    public void clickES() {
        genericWait.until(ExpectedConditions.elementToBeClickable(buttonES)).click();
    }

    public void clickDE() {
        genericWait.until(ExpectedConditions.elementToBeClickable(buttonDE)).click();
    }

    public void confirmTitle() {
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.titleIs("Wikipedia"));
    }
}
