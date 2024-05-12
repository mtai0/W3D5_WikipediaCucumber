package com.revature.w3d5_wikipediaexample.steps;

import com.revature.w3d5_wikipediaexample.pages.*;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

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
    private WikipediaArticleGeneric wikipediaArticle;
    private WikipediaSearch wikipediaSearch;

    @Before
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();

        driver.manage().window().maximize();
        wikipediaHomepage = PageFactory.initElements(driver, WikipediaHomepage.class);
        wikipediaEn = PageFactory.initElements(driver, WikipediaEn.class);
        wikipediaEs = PageFactory.initElements(driver, WikipediaEs.class);
        wikipediaDe = PageFactory.initElements(driver, WikipediaDe.class);
        wikipediaArticle = PageFactory.initElements(driver, WikipediaArticleGeneric.class);
        wikipediaSearch = PageFactory.initElements(driver, WikipediaSearch.class);
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

    @And("user has their search language set to English")
    public void userHasTheirSearchLanguageSetToEnglish() {
        wikipediaHomepage.selectLanguageEN();
    }

    @Given("{string} is the name of an existing Wikipedia article")
    public void isTheNameOfAnExistingWikipediaArticle(String searchTerm) {
        //This is externally verified.
    }

    @When("user searches for {string}")
    public void userSearchesFor(String searchTerm) {
        wikipediaHomepage.search(searchTerm);
    }

    @Then("user is taken to the Wikipedia page for {string}")
    public void userIsTakenToTheWikipediaPageFor(String searchTerm) {
        wikipediaArticle.confirmNotOnHomepage();

        Assertions.assertEquals(true, wikipediaArticle.isArticle());
    }

    @Given("no page exists for {string}")
    public void noPageExistsFor(String searchTerm) {
        //This is externally verified.
    }

    @Then("user is told that no results were found")
    public void userIsToldThatNoResultsWereFound() {
        wikipediaSearch.confirmNotOnHomepage();
        Assertions.assertEquals(true, wikipediaSearch.noResultsFound());
    }

    @And("{string} is a term that appears in one or more Wikipedia pages")
    public void isATermThatAppearsInOneOrMoreWikipediaPages(String searchTerm) {
        //This is externally verified.
    }

    @Then("user is shown a list of articles that contain a match for {string}")
    public void userIsShownAListOfArticlesThatContainAMatchForTheTerm(String searchTerm) {
        wikipediaSearch.confirmNotOnHomepage();
        Assertions.assertEquals(false, wikipediaSearch.noResultsFound());
    }
}
