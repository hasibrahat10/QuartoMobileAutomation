package pages;

import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;
import steps.TestSetupPage;

import java.time.Duration;
import java.util.List;

public class BasePage extends TestSetupPage {
    private final FluentWait<String> wait = new FluentWait<>("")
            .withTimeout(Duration.ofSeconds(20))
            .pollingEvery(Duration.ofMillis(400))
            .ignoring(NoSuchElementException.class, NullPointerException.class);

    public BasePage() {
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    public static void sleepFor(int seconds) {
        try {
            Thread.sleep(1000 * seconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void pressAndWait(MobileElement elm, int seconds) {
        new TouchAction(driver).press(PointOption.point(elm.getCenter())).waitAction(WaitOptions.waitOptions(Duration.ofSeconds(seconds))).release().perform();
    }

    public void swipeUp() {
        Dimension size = driver.manage().window().getSize();
        int x = size.width;
        int y = size.height;
        int startx = (int) (x / 2.0);
        int starty = (int) (y * 0.75);
        int endx = (int) (x / 2.0);
        int endy = (int) (y * 0.25);
        new TouchAction(driver).press(PointOption.point(startx, starty)).waitAction(WaitOptions.waitOptions(Duration.ofMillis(800))).moveTo(PointOption.point(endx, endy)).release().perform();
        sleepForSeconds(1);
    }

    public void swipeDown() {
        Dimension size = driver.manage().window().getSize();
        int x = size.width;
        int y = size.height;
        int startx = (int) (x / 2.0);
        int starty = (int) (y * 0.50);
        int endx = (int) (x / 2.0);
        int endy = (int) (y * 0.75);
        new TouchAction(driver).press(PointOption.point(startx, starty)).waitAction(WaitOptions.waitOptions(Duration.ofMillis(800))).moveTo(PointOption.point(endx, endy)).release().perform();
        sleepForSeconds(1);
    }

    public void swipeLeft() {
        sleepForMilliSeconds(500);
        Dimension size = driver.manage().window().getSize();
        int x = size.width;
        int y = size.height;
        int startx = x - 10;
        int starty = y / 2;
        new TouchAction(driver).press(PointOption.point(startx, starty)).waitAction(WaitOptions.waitOptions(Duration.ofMillis(800))).moveTo(PointOption.point(10, starty)).release().perform();
        sleepForSeconds(1);
    }

    public void swipeRight() {
        sleepForMilliSeconds(500);
        Dimension size = driver.manage().window().getSize();
        int x = size.width;
        int y = size.height;
        int starty = y / 2;
        int endx = x - 10;
        new TouchAction(driver).press(PointOption.point(10, starty)).waitAction(WaitOptions.waitOptions(Duration.ofMillis(800))).moveTo(PointOption.point(endx, starty)).release().perform();
        sleepForSeconds(1);
    }

    public WebElement patientlyScroll(WebElement elm) {
        return patientlyScroll(elm, 5);
    }

    public void patientlyScrollMobile(String selectorType, String selectorValue, int count) {

        for(int j =0; j<count; j++){ swipeDown();}
        String elementXpath = "";
        if (selectorType.equals("text")) {
            elementXpath = "//*[contains(@text,'" + selectorValue + "')]";
        } else {
            elementXpath = "//*[@" + selectorType + "='" + selectorValue + "')]";
        }
        for (int i = 0; i < (count*2); i++) {
            try {
                if (driver.findElement(By.xpath(elementXpath)).isDisplayed()) {
                    break;
                }
            } catch (org.openqa.selenium.NoSuchElementException e) {
                swipeUp();
            }
        }
    }

    public WebElement patientlyScroll(WebElement elm, int count) {
        for (int i = 0; i < count; i++) {
            try {
                if (elm.isDisplayed() && elm.isEnabled()) {
                    return elm;
                }
            } catch (org.openqa.selenium.NoSuchElementException e) {
                swipeUp();
            }
        }
        Assert.fail("\nElement not found" + "\nLocator: " + elm.toString() + "\n");
        return null;
    }

    public MobileElement waitForVisibility(WebElement element, int seconds) {
        WebDriverWait wait = new WebDriverWait(driver, seconds);
        wait.until(ExpectedConditions.visibilityOf(element));
        return (MobileElement) element;
    }

    public MobileElement waitForVisibility(WebElement element) {
        int defaultWaitTime = 15;
        return waitForVisibility(element, defaultWaitTime);
    }

    protected void waitForInvisibility(By by, int seconds) {
        WebDriverWait wait = new WebDriverWait(driver, seconds);
        wait.until(ExpectedConditions.invisibilityOfElementLocated(by));
    }
//
//    protected void waitForInvisibility(MobileElement element, int seconds) {
//        wait.withTimeout(Duration.ofSeconds(seconds))
//                .until(a -> !isElementVisible(element));
//    }


    public boolean isElementVisible(MobileElement elm) {
        try {
            return elm.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    public boolean isElementVisible(By by) {
        List elms = driver.findElements(by);
        return elms.size() == 1 && ((WebElement) elms.get(0)).isDisplayed();
    }

    public void setValue(MobileElement element, String keys) {
        element.clear();
        element.setValue(keys);
    }

    public String removeUnseenCharacters(String string) {
        return string.replaceAll("[^\\x00-\\x7F]", "");
    }

    public boolean isNumber(String str) {
        return str.matches("^-?\\d+$");
    }

    public boolean isLetters(String str) {
        return str.matches("[a-zA-Z]+");
    }

    public void sleepForSeconds(int seconds) {
        try {
            Thread.sleep(seconds * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void sleepForMilliSeconds(int milliseconds) {
        try {
            Thread.sleep(milliseconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public WebElement findItemWithScrolling(By by) {
        for (int i = 0; i < 5; i++) {
            if (isElementVisible(by)) {
                return driver.findElement(by);
            }
            swipeUp();
            i++;
        }
        Assert.fail("\nElement not found" + "\nLocator: " + by.toString() + "\n");
        return null;
    }
}
