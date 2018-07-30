import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileDriver;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.*;
import java.util.List;

public class HowToSend {
    private static MobileElement element = null;

    public static MobileElement pressContinue (MobileDriver driver) {
        driver.findElement(MobileBy.AndroidUIAutomator(Constants.CONTINUE)).click();
        return (MobileElement) element;
    }

    public static MobileElement pressNow (MobileDriver driver) {
        driver.findElement(By.id(Constants.RADIO_BTN)).click();
        return (MobileElement) element;
    }

    public static MobileElement pickMail (MobileDriver driver) {
        List<MobileElement> checkBoxes = driver.findElements(By.id(Constants.CHECKBOX));
        checkBoxes.get(2).click();
        return (MobileElement) element;
    }

    public static MobileElement enterMail (MobileDriver driver) {
        driver.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector()." +
                "scrollable(true)).scrollIntoView(new UiSelector().resourceId(\"il.co.mintapp.buyme:id/description\"))"));
        driver.findElement(By.className(Constants.MAIL_FIELD)).sendKeys("yotambec@gmail.com");
        return (MobileElement) element;
    }
}



