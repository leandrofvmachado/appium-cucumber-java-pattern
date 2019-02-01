import cucumber.api.CucumberOptions;
import cucumber.api.testng.TestNGCucumberRunner;
import cucumber.api.testng.CucumberFeatureWrapper;
import org.testng.annotations.*;
import steps.Utils;

import java.net.MalformedURLException;


@CucumberOptions(
        features = "src/test/java/resources/feature.feature", //path to your features
        glue = {"steps/"}, //path to your steps
        tags = {"~@Ignore"},
        format = {
                "pretty",
                "html:target/cucumber-reports/cucumber-pretty",
                "html:target/cucumber-reports",
                "json:target/cucumber.json",
                "rerun:target/cucumber-reports/rerun.txt"
        })
public class TestRunner extends Utils {
    private TestNGCucumberRunner testNGCucumberRunner;
    Utils utils = new Utils();

    @BeforeClass(alwaysRun = true)
    public void setUpClass() throws Exception {
        testNGCucumberRunner = new TestNGCucumberRunner(this.getClass());
    }

    @Test(groups = "cucumber", description = "Runs Cucumber Feature", dataProvider = "features")
    public void feature(CucumberFeatureWrapper cucumberFeature) throws MalformedURLException {
        utils.setup();
        testNGCucumberRunner.runCucumber(cucumberFeature.getCucumberFeature());
    }

    @DataProvider
    public Object[][] features() {
        return testNGCucumberRunner.provideFeatures();
    }

    @AfterClass(alwaysRun = true)
    public void tearDownClass() throws Exception {
        testNGCucumberRunner.finish();
    }
}