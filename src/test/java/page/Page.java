package page;

import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.WebElement;

public class Page {
    @AndroidFindBy(id = "idTextInput")
    @iOSXCUITFindBy(accessibility = "id_money")
    WebElement textInput;

    @AndroidFindBy(xpath = "//*[contains(@text, 'screenTitle')]")
    @iOSXCUITFindBy(iOSNsPredicate = "label == \"screenTitle\"")
    WebElement screenTitle;

    public WebElement getScreenTitle(){
        return screenTitle;
    }
}