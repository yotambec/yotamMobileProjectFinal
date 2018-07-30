import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileDriver;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class RegScreen {
    private static MobileElement element = null;

    public static MobileDriver regWithGoogle (MobileDriver driver) {
        driver.findElement(MobileBy.AndroidUIAutomator(Constants.GOOGLE)).click();
        return (MobileDriver) element;
    }
}
