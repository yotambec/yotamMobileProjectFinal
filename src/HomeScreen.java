import io.appium.java_client.*;
import io.appium.java_client.touch.LongPressOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import java.time.Duration;
import java.util.List;

public class HomeScreen {

    private static MobileElement element = null;

    public static MobileElement pickResturants (MobileDriver driver) {
        driver.findElement(MobileBy.AndroidUIAutomator(Constants.RESTURANTS)).click();
        return element;
    }

    public static MobileElement pickBuyMeChef (MobileDriver driver) {
        driver.findElement(MobileBy.AndroidUIAutomator(Constants.BUYME_CHEF)).click();
        return element;
    }

    public static MobileElement enterAmount (MobileDriver driver) {
        driver.findElement(By.id(Constants.AMOUNT_FIELD)).sendKeys("150");
        return element;
    }

    public static MobileElement pressContinue (MobileDriver driver) {
        driver.findElement(By.id(Constants.BUY_BTN)).click();
        return element;
    }

//    public static void swipe(int a, int b, int x, int y) {
//        TouchAction action = new TouchAction(driver);
//        Duration twoSecs = Duration.ofSeconds(2);
//        LongPressOptions longPressOptions = new LongPressOptions();
//
//        PointOption from = new PointOption();
//        from.withCoordinates(a, b);
//
//        PointOption to = new PointOption();
//        to.withCoordinates(x, y);
//
//        longPressOptions.withDuration(twoSecs).withPosition(from).build();
//
//        action.longPress(longPressOptions).moveTo(to).release().perform();
//    }

}
