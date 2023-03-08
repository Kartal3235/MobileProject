package MobileTask;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class BaseApp {

    @Test
    public AndroidDriver getAndroidDriver() throws MalformedURLException {

        DesiredCapabilities capabilities=new DesiredCapabilities();

        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME,"Android");
        capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION,"12.0");
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME,"Emulator");
        capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME,"UiAutomator2");
        capabilities.setCapability(MobileCapabilityType.APP,"C:\\Users\\YUEX\\IdeaProjects\\MobileProject\\src\\App\\APIDemos.apk");
        capabilities.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT,6000);
        capabilities.setCapability("noReset","true");
        capabilities.setCapability(MobileCapabilityType.SUPPORTS_JAVASCRIPT,true);

        AndroidDriver<MobileElement>driver=new AndroidDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"),capabilities);


        return driver;//
    }

}
