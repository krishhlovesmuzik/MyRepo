package Runners;
import org.junit.runner.RunWith;
import org.testng.annotations.Test;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
@Test
@RunWith(Cucumber.class)
@CucumberOptions(
		features="src/test/resources/bookATicketFeatureFiles",
		glue="tecketBookingDefinition",
tags= "@tag1")
public class TestRunner {

}
