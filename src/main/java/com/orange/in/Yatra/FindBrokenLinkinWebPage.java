package com.orange.in.Yatra;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FindBrokenLinkinWebPage {

    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();
        driver.get("file:///C:/Users/loges/Downloads/J4uJiCdnTjanCiiyKFiA_lti-%20html%20files/brokenlink.html");

        // ✅ Correct locator
        List<WebElement> listof = driver.findElements(By.tagName("a"));
        System.out.println("Total links: " + listof.size());

        for (WebElement element : listof) {

            String url = element.getDomAttribute("href");

            // ✅ Important null & empty check
            if (url != null && !url.isEmpty()) {
                checkvalidURL(url);
            }
        }

        driver.quit();
    }

    private static void checkvalidURL(String url) {

        try {
            URL linkurl = new URL(url);
            HttpURLConnection conn =
                    (HttpURLConnection) linkurl.openConnection();

            conn.setRequestMethod("HEAD");
            conn.connect();

            int statuscode = conn.getResponseCode();

            if (statuscode >= 400) {
                System.out.println("Invalid link : " + url + " --> " + statuscode);
            } else {
                System.out.println("Valid link   : " + url + " --> " + statuscode);
            }

        } catch (IOException e) {
            System.out.println("Exception for URL: " + url);
        }
    }
}
