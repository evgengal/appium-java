package scenarios;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by evgeniy.galkin on 03.04.2017.
 */
public class AndroidSetup {
    protected AndroidDriver driver;

    protected void prepareAndroidForAppium() throws MalformedURLException {

        File appDir = new File("C:\\less\\MapsMeAppiumTest\\apps");
        File app = new File(appDir, "MAPS.ME+v7.2.1-Google.apk");
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("device","Android");

        //mandatory capabilities
        capabilities.setCapability("deviceName","Nexus 5");
        capabilities.setCapability("platformVersion", "6.0");
        capabilities.setCapability("platformName","Android");
        capabilities.setCapability("appPackage", "com.mapswithme.maps.pro");
        capabilities.setCapability("appActivity", "com.mapswithme.maps.MwmActivity");

        //other caps
        capabilities.setCapability("app", app.getAbsolutePath());
        driver =  new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
    }
}
