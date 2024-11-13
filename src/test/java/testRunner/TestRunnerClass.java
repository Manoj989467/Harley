package testRunner;

import baseClass.BaseClass;
import reporting.ReportingClass;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

import java.io.FileNotFoundException;
import java.io.IOException;


@RunWith(Cucumber.class)
@CucumberOptions(dryRun = true, plugin = {"pretty", "html:target//report.html"}, glue = {"stepdefinition"},
        features = "src\\test\\resources\\Features\\Login.feature", tags = ("@LoginWithOTP"))
public class TestRunnerClass extends BaseClass {

    public static void report() throws FileNotFoundException, IOException {

        ReportingClass.htmlReport(getpropertypath() + getpropertyfilevalue("html"));

    }
}
