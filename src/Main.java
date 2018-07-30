import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import io.appium.java_client.MobileDriver;
import org.apache.commons.io.FileUtils;

import org.junit.*;
import org.junit.rules.TestName;
import org.junit.runners.MethodSorters;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;

import org.openqa.selenium.*;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)

public class Main {

    private static AndroidDriver<MobileElement> driver;

    @Rule
    public TestName name = new TestName();
    private static ExtentReports extent ;
    private static ExtentTest test;

    @BeforeClass
    public static void test01_setUp() throws IOException, SAXException, ParserConfigurationException {
        ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter("C:\\Users\\יותם\\IdeaProjects\\extent.html");
        htmlReporter.setAppendExisting(true);
        extent = new ExtentReports();
        extent.attachReporter(htmlReporter);
        test = extent.createTest("MyFirstTest", "Sample description");
        extent.setSystemInfo("Environment", "Production");
        extent.setSystemInfo("Tester", "Yotam");
        test.log(Status.INFO, "@Before class");

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("deviceName", "Android Device");
        capabilities.setCapability("appPackage", ReadFromXML.getData("packageValue"));
        capabilities.setCapability("appActivity", ReadFromXML.getData("activityValue"));
        capabilities.setCapability("newCommandTimeout", 120);
        capabilities.setCapability(MobileCapabilityType.NO_RESET, true);
        capabilities.setCapability("unicodekeyboard", true);
        capabilities.setCapability("resetkeyboard", true);
        driver = new AndroidDriver(new URL("http://0.0.0.0:4723/wd/hub/"), capabilities);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    @Test
    public void test02_signing_up() throws InterruptedException, IOException {
        boolean signedup = false;
        try {
            //Registering with Google Account
            RegScreen.regWithGoogle(driver);

            Thread.sleep(2000);
            signedup = true;
        } catch (Exception e) {
            e.printStackTrace();
            test.log(Status.FAIL, "Couldn't sign in " + e.getMessage());
            signedup = false;
        } finally {
            if (signedup) {
                test.log(Status.PASS, "Signed in successfully " + test.addScreenCaptureFromPath(takeScreenShot(driver, "C:\\Users\\יותם\\IdeaProjects" + name.getMethodName())));
            }
        }
    }

    @Test
    public void test03_homescreen() throws IOException {
        boolean gift_was_searched = false;
        try {

            //Choosing resturants category
            HomeScreen.pickResturants(driver);

            //Choosing a business
            HomeScreen.pickBuyMeChef(driver);

            //Enter Gift budget
            HomeScreen.enterAmount(driver);

            //Pressing "LeKniya"
            HomeScreen.pressContinue(driver);

            gift_was_searched = true;
        } catch (Exception e) {
            e.printStackTrace();
            test.log(Status.FAIL, "couldn't search gift " + e.getMessage());
            gift_was_searched = false;
        } finally {
            if (gift_was_searched) {
                test.log(Status.PASS, "Found the right gift " + test.addScreenCaptureFromPath(takeScreenShot(driver,"C:\\Users\\יותם\\IdeaProjects"+name.getMethodName())));
            }
        }
    }

    @Test
    public void test04_Sender_and_Reciever_Information() throws InterruptedException, IOException {
        boolean information_was_inserted = false;
        try {

            //Enter reciver name
            SenderReciver.enterReciver(driver);
            try{
                driver.hideKeyboard();
            }catch (Exception e) {
                e.printStackTrace();
            }

            //Enter blessing
            SenderReciver.enterBless(driver);
            try{
                driver.hideKeyboard();
            }catch (Exception e) {
                e.printStackTrace();
            }

            //Enter Sender
            SenderReciver.enterSender(driver);

            try{
            driver.hideKeyboard();
            }catch (Exception e) {
                e.printStackTrace();
            }

            //Press Continue
            SenderReciver.pressContinue(driver);

            information_was_inserted = true;
        } catch (Exception e) {
            e.printStackTrace();
            test.log(Status.FAIL, "Problem with inserting informaion " + e.getMessage());
            information_was_inserted = false;
        } finally {
            if (information_was_inserted) {
                test.log(Status.PASS, "Information was inserted " + test.addScreenCaptureFromPath(takeScreenShot(driver,"C:\\Users\\יותם\\IdeaProjects"+name.getMethodName())));
            }
        }
    }

    @Test
    public void test05_How_To_send_screen() throws InterruptedException, IOException {
        boolean information_was_inserted = false;
        try {
            //Press "Now" radio button
            HowToSend.pressNow(driver);

            //Picking Email option
            HowToSend.pickMail(driver);

            //Entering Email Address
            HowToSend.enterMail(driver);

            //Pressing "Next" button
            HowToSend.pressContinue(driver);

            information_was_inserted = true;
        } catch (Exception e) {
            e.printStackTrace();
            test.log(Status.FAIL, "Problem with inserting informaion " + e.getMessage());
            information_was_inserted = false;
        } finally {
            if (information_was_inserted) {
                test.log(Status.PASS, "Information was inserted " + test.addScreenCaptureFromPath(takeScreenShot(driver,"C:\\Users\\יותם\\IdeaProjects"+name.getMethodName())));
            }
        }
    }

    @AfterClass
    public static void test06_End() {
        test.log(Status.INFO, "@After test " + "After test method");
        extent.flush();
    }

    private static String takeScreenShot(MobileDriver driver, String ImagesPath) {
        TakesScreenshot takesScreenshot = (TakesScreenshot) Main.driver;
        File screenShotFile = takesScreenshot.getScreenshotAs(OutputType.FILE);
        File destinationFile = new File(ImagesPath+".png");
        try {
            FileUtils.copyFile(screenShotFile, destinationFile);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return ImagesPath+".png";
    }
}
