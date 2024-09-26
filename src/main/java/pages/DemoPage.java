package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DemoPage {
    WebDriver driver;

    By loginButton = By.linkText("Login");

    public DemoPage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickLogin() {
        driver.findElement(loginButton).click();
    }

    public String getCurrentTab() {
        return driver.getWindowHandle();
    }
}
