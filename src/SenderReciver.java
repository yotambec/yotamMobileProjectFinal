import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileDriver;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SenderReciver {

    private static MobileElement element = null;

    public static MobileElement enterReciver (MobileDriver driver) {
        driver.findElement(By.id(Constants.RECIEVER)).sendKeys("daniel");
        return (MobileElement) element;
    }


    public static MobileElement enterBless (MobileDriver driver) {
        driver.findElement(By.id(Constants.BLESS)).sendKeys("mazal tov neshama");
        return (MobileElement) element;
    }

    public static MobileElement pressContinue (MobileDriver driver) {
        driver.findElement(MobileBy.AndroidUIAutomator(Constants.CONTINUE)).click();
        return (MobileElement) element;
    }

    public static WebElement enterSender (WebDriver driver) {
        driver.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector()." +
                "scrollable(true)).scrollIntoView(new UiSelector().resourceId(\"il.co.mintapp.buyme:id/userFrom\"))"));
        driver.findElement(By.id("il.co.mintapp.buyme:id/userFrom")).clear();
        driver.findElement(By.id("il.co.mintapp.buyme:id/userFrom")).sendKeys("Yotam");
        return (MobileElement) element;
    }
}

