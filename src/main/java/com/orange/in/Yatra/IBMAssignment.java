package com.orange.in.Yatra;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class IBMAssignment {
	public static void main(String[] args) throws InterruptedException {
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--start-maximized");
		options.setExperimentalOption("excludeSwitches", new String[] { "enable-automation" });
		options.setExperimentalOption("useAutomationExtension", false);
		WebDriver driver = new ChromeDriver(options);
		driver.get("https://www.ibm.com/in-en");

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

		By hybirdlocationmenu = By.xpath("//c4d-megamenu-top-nav-menu[@menu-label='Hybrid Cloud']");
		By hybirdloactionlink = By.cssSelector("a");
		By infralink = By.xpath("//c4d-megamenu-category-heading[@title='IT infrastructure']");
		By heading = By.xpath("//h1[@class='cmp-leadspace__heading ']");

		WebElement hybirdlocationmenuelement = wait
				.until(ExpectedConditions.visibilityOfElementLocated(hybirdlocationmenu));
		SearchContext hybirdlocationmenushadow = hybirdlocationmenuelement.getShadowRoot();

		WebElement hybirdloactionlinkcliekc = hybirdlocationmenushadow.findElement(hybirdloactionlink);
		hybirdloactionlinkcliekc.click();

		WebElement infraclick = wait.until(ExpectedConditions.visibilityOfElementLocated(infralink));
		infraclick.click();

		WebElement headingtext = driver.findElement(heading);
		System.out.println(headingtext.getText());
	}

}
