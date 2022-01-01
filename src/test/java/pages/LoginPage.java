package pages;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class LoginPage extends BasePage {
    @AndroidFindBy(xpath = "//*[contains(@text, 'Email address')]")
    public MobileElement emailAddress;
    @AndroidFindBy(xpath = "//*[contains(@text, 'Password')]")
    public MobileElement password;
    @AndroidFindBy(xpath = "//android.widget.Button[@content-desc=\"LOGIN\"]")
    public MobileElement login;
    @AndroidFindBy(xpath = "//android.view.View[@content-desc=\"Good Morning\"]\n")
    public MobileElement textDisplayed;

    /**
     * Method declared for the step definitions
     */
    public void loginInfo() {
        emailAddress.click();
        emailAddress.sendKeys("tlive5@yopmail.com");
        password.click();
        password.sendKeys("t12345678");
        sleepForSeconds(4);
    }

    public void clickLogin() {
        login.click();
        sleepForMilliSeconds(5);
    }

    public String setTextDisplayed() {
        sleepFor(5);
        return textDisplayed.getText();
    }


}
