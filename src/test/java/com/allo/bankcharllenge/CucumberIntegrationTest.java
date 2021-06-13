package com.allo.bankcharllenge;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"pretty"},
        glue = {"com.allo.bankcharllenge.steps"},
        features = {"src/test/resources/features"})
public class CucumberIntegrationTest extends BankCharllengeApplicationTests{
}
