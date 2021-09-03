package cucumberRunner;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(

		features = "./FeatureClasses/FullOperation.feature",tags = "@SmokeTest", glue = { "stepDefinition" })

	public class TestRun extends AbstractTestNGCucumberTests {
	public static Properties config;

	public TestRun() throws IOException {

		config = new Properties();
		FileInputStream ip = new FileInputStream(System.getProperty("user.dir") + ".\\ConfigFile\\config.properties");
		config.load(ip);

	}
}
