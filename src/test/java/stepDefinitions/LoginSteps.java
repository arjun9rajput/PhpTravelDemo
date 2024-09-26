package stepDefinitions;

import io.cucumber.java.en.*;
import org.openqa.selenium.WebDriver;
import pages.LoginPage;

public class  LoginSteps {
    WebDriver driver;
    LoginPage loginPage;

    @Then("Login page is displayed in new tab")
    public void login_page_is_displayed_in_new_tab() {
        for (String handle : driver.getWindowHandles()) {
            driver.switchTo().window(handle);
        }
        loginPage = new LoginPage(driver);
        assert loginPage.isLoginPage();
    }

    @And("Email and Password fields are present")
    public void email_and_password_fields_are_present() {
        assert loginPage.isEmailFieldPresent();
        assert loginPage.isPasswordFieldPresent();
    }
}
