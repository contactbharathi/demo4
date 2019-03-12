package grpid4;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
//C:/Users/abraham.paulraj/IdeaProjects/demo4/
@CucumberOptions(features = "src/test/java/resources/",

        dryRun = false,
        tags = "@wip",
       strict = false,
        plugin = {"pretty","json:target/cucumber.json"})

public class RunCucumberClasstest
{
}
