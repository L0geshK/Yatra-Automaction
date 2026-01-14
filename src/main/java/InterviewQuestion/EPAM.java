package InterviewQuestion;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class EPAM {
    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();
        driver.get("file:///C:/Users/loges/Downloads/index.html");

        // Step 1: Get all product blocks
        List<WebElement> products =
                driver.findElements(By.xpath("//div[@id='product']"));

        // Step 2: Traverse inside each product
        for (WebElement product : products) {

            String productName =
                    product.findElement(By.xpath("./span[1]")).getAttribute("name");

            String stockStatus =
                    product.findElement(By.xpath("./span[2]")).getAttribute("name");

            // Step 3: Filter logic
            if (stockStatus.equalsIgnoreCase("in stock")) {
                System.out.println(productName + " -> " + stockStatus);
            }
        }

        driver.quit();
    }
}
