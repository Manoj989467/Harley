package testRunner;

import baseClass.BaseClass;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;



@RunWith(Cucumber.class)
@CucumberOptions(dryRun = false, plugin = {"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"}, glue = {"stepdefinition"},
        features = {"src\\test\\resources\\Features\\Login.feature"})
public class TestRunnerClass extends BaseClass {



}

