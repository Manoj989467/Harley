package reporting;

import net.masterthought.cucumber.ReportBuilder;

import java.io.File;

import net.masterthought.cucumber.Configuration;

import java.util.ArrayList;
import java.util.List;

public class ReportingClass {

    public static void htmlReport(String htmlfile) {

        File file = new File("C:\\Users\\Welcome\\IdeaProjects\\Harley\\target");

        Configuration config = new Configuration(file, "Harley");
        config.addClassifications("browser", "Chrome");
        config.addClassifications("browser version", "1.2");
        config.addClassifications("os", "windows 11");

        List<String> htmlfiles = new ArrayList<>();
        htmlfiles.add(htmlfile);

        ReportBuilder build = new ReportBuilder(htmlfiles, config);
        build.generateReports();

    }
}
