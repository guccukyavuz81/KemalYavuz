package com.codingtech.runners;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/features",
                // glue= {"com.hrms.APIsteps.practice"},
                 glue= {"com/codingtech/APIsteps/practice"},
                dryRun = false,
                 tags ="@APITEST",
                 plugin= {"pretty",
                		 "html:target/cucumber-default-report",
                		 "json:target/cucumber.json"
                		 }

		)

public class APIrunner {

}
