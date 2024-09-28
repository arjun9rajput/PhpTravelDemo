package config;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.HashMap;
import java.util.Map;

public class DriverFactory {
    public static WebDriver driver;
    public static ChromeOptions options = new ChromeOptions();

    public static WebDriver getDesktopDriver() {
        if(driver == null){
            return driver= new ChromeDriver(options); // Normal Chrome for desktop
        }
        return driver;
    }

    public static WebDriver getMobileDriver() {
        if (driver==null){
            options.setExperimentalOption("mobileEmulation", getMobileEmulationConfig());
            return driver = new ChromeDriver(options); // Chrome with mobile emulation
        }
        return driver;
    }

    private static Map<String, Object> getMobileEmulationConfig() {
        Map<String, Object> mobileEmulation = new HashMap<>();
        mobileEmulation.put("deviceName", "Pixel 2");
        return mobileEmulation;
    }

    public static void closeDriver() {
        if (driver != null) {
            driver.quit();
        }
    }
}
