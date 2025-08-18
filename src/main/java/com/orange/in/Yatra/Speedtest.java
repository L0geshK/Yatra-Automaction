package com.orange.in.Yatra;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Speedtest {

	public static void main(String[] arg) {

		ChromeOptions chromeOptions = new ChromeOptions();
		chromeOptions.addArguments("--start-maximized");

		WebDriver wd = new ChromeDriver(chromeOptions);
		wd.get("https://fast.com/");

		WebDriverWait wait = new WebDriverWait(wd, Duration.ofSeconds(20));

		By Speedlocator = By.id("speed-value");
		By SpeedUnitlocator = By.id("speed-units");
		String Classname;

		WebElement Speedlocatorvalue = wait.until(ExpectedConditions.visibilityOfElementLocated(Speedlocator));
		WebElement SpeedUnitlocatorvalue = wait
				.until(ExpectedConditions.visibilityOfElementLocated(SpeedUnitlocator));
		while (true) {

			Classname=Speedlocatorvalue.getAttribute("class");
			if(Classname!=null&&Classname.contains("succeeded")) {
				break;
		}
		
		}
		System.out.println(Speedlocatorvalue.getText()+""+SpeedUnitlocatorvalue.getText());
	

}
}

