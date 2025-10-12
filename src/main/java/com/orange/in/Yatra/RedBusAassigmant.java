package com.orange.in.Yatra;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RedBusAassigmant {
	
	public static void main(String[] args) {
		
		ChromeOptions chromeOptions = new ChromeOptions();
		chromeOptions.addArguments("--start-maximized");
		WebDriver wd =new ChromeDriver(chromeOptions);
		wd.get("https://www.redbus.in");
		WebDriverWait wait = new WebDriverWait(wd, Duration.ofSeconds(30));
		
		
		By FrombuttonLocator = By.xpath("//div[contains(@class, 'srcDestWrapper') and @role='button']");
		WebElement Frombutton = wait.until(ExpectedConditions.visibilityOfElementLocated(FrombuttonLocator));
		Frombutton.click();
		
		
		By searchSuggestionSectionLocator = By.xpath("//div[contains(@class,\"searchSuggestionWrapper\")]");
		wait.until(ExpectedConditions.visibilityOfElementLocated(searchSuggestionSectionLocator));
		WebElement Searchbutton = wd.switchTo().activeElement();
		Searchbutton.sendKeys("Mumbai");
		By searchCategoryLocator = By.xpath("//div[contains(@class,\"searchCategory\")]");
		List<WebElement> searchList = wait
				.until(ExpectedConditions.numberOfElementsToBeMoreThan(searchCategoryLocator, 2));

		System.out.println(searchList.size());

		WebElement locationSearchResult = searchList.get(0);
	}

}
