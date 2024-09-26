package config;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.HashMap;
import java.util.Map;

public class DriverFactory {
    public static WebDriver driver;

    public static WebDriver getDesktopDriver() {
        System.setProperty("webdriver.chrome.driver", "path-to-chromedriver");
        return new ChromeDriver(); // Normal Chrome for desktop
    }

    public static WebDriver getMobileDriver() {
        System.setProperty("webdriver.chrome.driver", "path-to-chromedriver");
        ChromeOptions options = new ChromeOptions();
        options.setExperimentalOption("mobileEmulation", getMobileEmulationConfig());
        return new ChromeDriver(options); // Chrome with mobile emulation
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
