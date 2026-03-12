package com.orange.in.Yatra;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class IPLAutomaction {
	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(20));
		
		driver.get("https://www.iplt20.com/points-table/men/2025");
		By tableloactor = By.className("ih-td-tab");
		WebElement table=wait.until(ExpectedConditions.visibilityOfElementLocated(tableloactor));
		
		
		By tbodylocator = By.id("pointsdata");
		WebElement tbody =table.findElement(tbodylocator);
		
		By tablerowlocator = By.tagName("tr");
		List<WebElement> row =tbody.findElements(tablerowlocator);
		System.out.println(row.size());
		
		for(WebElement row1:row) {
			By tabledatalocator = By.tagName("td");
			List<WebElement> rowadata=row1.findElements(tablerowlocator);
			for(WebElement data :rowadata) {
				System.out.println(data.getText());
			}
		}
		
		
	}

}
