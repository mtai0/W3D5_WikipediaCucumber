package com.revature.w3d5_wikipediaexample.steps;

import com.revature.w3d5_wikipediaexample.pages.WikipediaDe;
import com.revature.w3d5_wikipediaexample.pages.WikipediaEn;
import com.revature.w3d5_wikipediaexample.pages.WikipediaEs;
import com.revature.w3d5_wikipediaexample.pages.WikipediaHomepage;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

// Runner, after glue code, give plugin to generate report
/*
    plugin = {
        "pretty",
        "html:src/test/resources/reports/html-reports.html"
        }
 */

public class WikipediaSteps {
    private WebDriver driver;
    private WikipediaHomepage wikipediaHomepage;
    private WikipediaEn wikipediaEn;
    private WikipediaEs wikipediaEs;
    private WikipediaDe wikipediaDe;

    @Before
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();

        driver.manage().window().maximize();
        wikipediaHomepage = PageFactory.initElements(driver, WikipediaHomepage.class);
        wikipediaEn = PageFactory.initElements(driver, WikipediaEn.class);
        wikipediaEs = PageFactory.initElements(driver, WikipediaEs.class);
        wikipediaDe = PageFactory.initElements(driver, WikipediaDe.class);
    }

    @After
    public void cleanup() {
        driver.quit();
    }

    @Given("user is on the Wikipedia homepage")
    public void getHomepage() {
        wikipediaHomepage.getHomepage();
        wikipediaHomepage.confirmTitle();

        Assertions.assertEquals("Wikipedia", wikipediaHomepage.getTitle());
    }

    @When("user clicks on the button for the English portal")
    public void clickEnglish() {
        wikipediaHomepage.clickEN();
    }

    @Then("user is taken to the English homepage")
    public void confirmEnglish() {
        Assertions.assertEquals("Wikipedia, the free encyclopedia", wikipediaEn.getTitle());
    }

    @When("user clicks on the button for the Spanish portal")
    public void clickSpanish() {
        wikipediaHomepage.clickES();
    }

    @Then("user is taken to the Spanish homepage")
    public void confirmSpanish() {
        Assertions.assertEquals("Wikipedia, la enciclopedia libre", wikipediaEs.getTitle());
    }

    @When("user clicks on the button for the Deutsch portal")
    public void clickDeutsch() {
        wikipediaHomepage.clickDE();
    }

    @Then("user is taken to the Deutsch homepage")
    public void confirmDeutsch() {
        Assertions.assertEquals("Wikipedia – Die freie Enzyklopädie", wikipediaDe.getTitle());
    }
}
