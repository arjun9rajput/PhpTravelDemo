package stepDefinitions;

import config.DriverFactory;
import io.cucumber.java.en.*;
import org.openqa.selenium.WebDriver;
import pages.DemoPage;
import runners.TestRunner;
import utils.ApiUtils;

public class DemoSteps {
    WebDriver driver;
    DemoPage demoPage;

    @Given("User is on the Demo page")
    public void user_is_on_the_demo_page() {
        String mode = TestRunner.mode;

        if (mode.equalsIgnoreCase("desktop")) {
            driver = DriverFactory.getDesktopDriver();
        } else if (mode.equalsIgnoreCase("mobile")) {
            driver = DriverFactory.getMobileDriver();
        }

        driver.get("https://phptravels.com/demo/");
        demoPage = new DemoPage(driver);
    }

    @When("User clicks on login button")
    public void user_clicks_on_login_button() {
        demoPage.clickLogin();
    }

    @Then("Get all links and verify their status")
    public void get_all_links_and_verify_their_status() {
        ApiUtils.verifyLinks(driver);
    }

    @And("Switch back to Demo tab")
    public void switch_back_to_demo_tab() {
        driver.switchTo().window(demoPage.getCurrentTab());
    }
}
