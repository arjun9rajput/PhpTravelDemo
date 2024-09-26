package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    WebDriver driver;

    By emailField = By.id("inputEmail");
    By passwordField = By.id("inputPassword");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public boolean isLoginPage() {
        return driver.getTitle().equals("Login");
    }

    public boolean isEmailFieldPresent() {
        return driver.findElement(emailField).isDisplayed();
    }

    public boolean isPasswordFieldPresent() {
        return driver.findElement(passwordField).isDisplayed();
    }
}
