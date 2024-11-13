package hooks;

import baseClass.BaseClass;
import io.cucumber.java.After;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class Hooks extends BaseClass {
    @After
    public void screenshot(Scenario scenario) {

        if (scenario.isFailed() || scenario.getStatus().toString().equalsIgnoreCase("PASSED")) {

            final byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot, "img/png", scenario.getName());
        }
    }
}
