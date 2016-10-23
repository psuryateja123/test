package Assignment;

import io.appium.java_client.AppiumDriver;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import static com.sun.xml.internal.ws.dump.LoggingDumpTube.Position.Before;

/**
 * Created by surya on 23/10/2016.
 */
public class MainTest {

    public static AppiumDriver wd;
    static boolean ci = false; // it could be set to true if CI is true

    @BeforeClass

    public static void start() {


        try {

            DesiredCapabilities capabilities = new DesiredCapabilities();
            capabilities.setCapability("appium-version", "1.4");
            capabilities.setCapability("platformName", "Android");
            capabilities.setCapability("platformVersion", "5.1");
            capabilities.setCapability("deviceName", "surya");
            File app = new File("/Users/surya/Desktop/automation-sandbox-v1.apk");
            capabilities.setCapability("appPackage", "novoda.com.sandbox");
            capabilities.setCapability("appActivity", "novoda.com.sandbox.sandbox.activites.MainActivity");
            AppiumDriver driver;
            wd = new AppiumDriver(new URL("http://0.0.0.0:4723/wd/hub"), capabilities) {
                public WebElement scrollTo(java.lang.String text) {
                    return null;
                }

                public WebElement scrollToExact(java.lang.String text) {
                    return null;
                }




            };



        } catch (Exception e) {
            e.printStackTrace();
        }





    }




    @Test

    public void RunTest(){
        try{

            //  wd.findElement(By.linkText(locators.thirdpartyapp)).click();
//    wd.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);


            wd.findElement(By.id(locators.signinbutton)).click();
            wd.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
            //can also use explicit wait
            wd.findElement(By.linkText(locators.username)).click();
            wd.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

            wd.findElement(By.linkText(locators.userpassword)).click();
            wd.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

            wd.findElement(By.linkText(locators.submit_button)).click();
            wd.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);


        }catch (NullPointerException e){
            e.printStackTrace();
        }

    }

}
