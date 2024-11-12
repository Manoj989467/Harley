package Hooks;

import BaseClass.BaseClass;
import io.cucumber.java.After;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class Hooks extends BaseClass {
    @After
    public  static  void scenario(Scenario scenario){

        final byte[] screenshot= ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
        scenario.attach(screenshot,"img/png","End of every scenario Screenshot");
    }
}
