package steps;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.TouchAction;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;


public class Utils {
    public static AppiumDriver driver;
    protected String phoneType = "android";

    public DesiredCapabilities setDesiredCaps(String phoneType){
        DesiredCapabilities caps = new DesiredCapabilities();
        if (phoneType.equals("android")) {
            caps.setCapability("platformName", "Android"); //android or ios
            caps.setCapability("platformVersion", "8.0"); //OS version
            caps.setCapability("deviceName", "Android Emulator"); //any name
            caps.setCapability("appWaitActivity", "app.wait.activity"); //first interactable activity of the application
            caps.setCapability("autoGrantPermissions", "true");
            caps.setCapability("automationName", "UiAutomator2");
            caps.setCapability("skipDeviceInitialization", "true");
            caps.setCapability("skipServerInstallation", "true");
            caps.setCapability("appPackage", "");
            caps.setCapability("appActivity", "launchable.activity"); //launchable application of the app
            caps.setCapability("disableAndroidWatchers", "true");
            caps.setCapability("skipUnlock", "true");
            caps.setCapability("ignoreUnimportantViews", "true");

        }
        else {
            caps.setCapability("platformName", "iOS");
            caps.setCapability("platformVersion", "12.0");
            caps.setCapability("automationName", "XCUITest");
            caps.setCapability("deviceName", "iPhone XS");
            caps.setCapability("bundleID", "bundle.id"); //bundle id ios app
            caps.setCapability("app", "app/path");
            caps.setCapability("useNewWDA", true);
            caps.setCapability("showXCodeLog", true);
            caps.setCapability("clearSystemFiles", true);
            caps.setCapability("shouldUseSingletonTestManager", false);
            caps.setCapability("noReset", true);
            caps.setCapability("wdaStartupRetryInterval", 1000);
            caps.setCapability("newCommandTimeout", 3000);
            caps.setCapability("maxTypingFrequency", 30);
        }

        return caps;
    }

    public void setup() throws MalformedURLException {
        DesiredCapabilities caps = setDesiredCaps(phoneType);
        driver = new AppiumDriver(new URL("http://127.0.0.1:4723/wd/hub"), caps);
    }

    public AppiumDriver getDriver() {
        return driver;
    }

    @After
    public void tearDown(Scenario scenario){
        if (scenario.isFailed()){
            try {
                String path;
                path = System.getProperty("user.dir");
                new File(path+"/screenshotFailure").mkdirs();
                FileOutputStream out = new FileOutputStream(path+"/screenshotFailure/"+scenario.getName()+".png");
                byte[] scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
                out.write(scrFile);
                scenario.embed(scrFile, "image/png");
                out.close();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
        getDriver().quit();
    }
}
