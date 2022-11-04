package net.seamlessly.runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(strict = true,
        plugin = {"json:target/cucumber.json",
                "html:target/default-html-reports",
                "me.jvt.cucumber.report.PrettyReports:target/cucumber"

        },
        features ="src/test/resources/features",
        glue="net/seamlessly/stepdefinitions",

        tags="@withsubmitbutton",



        dryRun = false

)
public class CukesRunner {
}
