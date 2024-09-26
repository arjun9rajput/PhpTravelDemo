package utils;

import io.restassured.RestAssured;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class ApiUtils {
    public static void verifyLinks(WebDriver driver) {
        List<WebElement> links = driver.findElements(By.tagName("a"));
        for (int i = 0; i < 10; i++) {
            String url = links.get(i).getAttribute("href");
            int statusCode = RestAssured.get(url).statusCode();
            System.out.println(url + " -> " + statusCode);
            assert statusCode < 400 : "Broken link: " + url;
        }
    }
}
