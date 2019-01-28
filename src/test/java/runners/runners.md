# What is?
Runner é o código responsável por organizar como um cenário
vai rodar. Como é o usado o TestNGCucumberRunner, é possível utilizar
alguns decorators para auxiliar na construcão dos testes
como @AfterClass e @BeforeClass, além do próprio @Test, que precede
o teste.
Além disso, é possível usar o decorator @CucumberOptions, no qual
o usuário indica onde estão os arquivos que são necessários para
rodar o teste.
# Examples
```java
CucumberOptions(
        features = "src/test/java/resources/login.feature", //path to your features
        glue = {"Steps/"}, //path to your steps
        tags = {"~@Ignore"},
        format = { "pretty" })
public class TestRunner {
    private TestNGCucumberRunner testNGCucumberRunner;

    @BeforeClass(alwaysRun = true)
    public void setUpClass(String test_param) throws Exception {
        testNGCucumberRunner = new TestNGCucumberRunner(this.getClass());
    }

    @Test(groups = "cucumber", description = "Runs Cucumber Feature", dataProvider = "features")
    public void feature(CucumberFeatureWrapper cucumberFeature) {
        testNGCucumberRunner.runCucumber(cucumberFeature.getCucumberFeature());
    }
}
```