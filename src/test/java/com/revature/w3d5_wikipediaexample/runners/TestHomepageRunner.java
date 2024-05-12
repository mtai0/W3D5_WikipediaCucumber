package com.revature.w3d5_wikipediaexample.runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"src/main/resources/features/ViewHomepage.feature"},
        glue = {"com.revature.w3d5_wikipediaexample.steps"}
)
public class TestHomepageRunner {
}
