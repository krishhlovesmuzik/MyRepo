package Runners;
import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
@RunWith(Cucumber.class)
@CucumberOptions(
		features="src/test/resources/bookATicketFeatureFiles",
		glue="tecketBookingDefinition",
tags= "@tag1")
public class BookATicketRunner {

}
