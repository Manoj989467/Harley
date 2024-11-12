package TestRunner;

import BaseClass.BaseClass;
import Reporting.ReportingClass;
import io.cucumber.java.After;
import io.cucumber.java.AfterAll;
import io.cucumber.java.Scenario;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.AfterClass;
import org.junit.runner.RunWith;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.FileNotFoundException;
import java.io.IOException;


@RunWith(Cucumber.class)
@CucumberOptions(dryRun = true, plugin = {"pretty", "json:target//index.json"}, glue = {"Stepdefinition"},
        features = "src\\test\\resources\\Features\\Login.feature", monochrome = true, tags = ("@LoginWithOTP and @SuccessfulLogin"))
public class TestRunnerClass extends BaseClass {

    public static void report() throws FileNotFoundException, IOException {

        ReportingClass.jvmReport(getpropertypath() + getpropertyfilevalue("html"));

    }




}
