package com.orange.in.Yatra;

import java.time.Duration;
import java.time.LocalDate;
import java.time.format.TextStyle;
import java.util.Locale;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SpiceJetAutomaction {

	public static void main(String[] args) {

		ChromeOptions chromeOptions = new ChromeOptions();
		chromeOptions.addArguments("--start-maximized");
		chromeOptions.addArguments("--disable-notification");
		
	     WebDriver wd=new ChromeDriver(chromeOptions);
	     wd.get("https://www.spicejet.com/");
	     WebDriverWait wait = new WebDriverWait(wd,Duration.ofSeconds(20));
	     
	     By FromCityLocator= By.xpath("//div[text()=\"From\"]/following-sibling::div/input");
	     WebElement FromCitybox = wait.until(ExpectedConditions.visibilityOfElementLocated(FromCityLocator));
	     FromCitybox.sendKeys("Mum");
	     
	     By ToCityLocator= By.xpath("//div[text()=\"To\"]/following-sibling::div/input");
	     WebElement toCitybox = wait.until(ExpectedConditions.visibilityOfElementLocated(ToCityLocator));
	     toCitybox.sendKeys("Pun");
	     
	     By CalendarLocator = By.xpath("//div[@data-testid='undefined-calendar-picker']");
	     WebElement CalendorPicker = wait.until(ExpectedConditions.visibilityOfElementLocated(CalendarLocator));
	     
	     By NextButtonLocator = By.xpath(".//*[local-name()=\"svg\" and  @data-testid=\"svg-img\"]");
	     WebElement NextButton = CalendorPicker.findElement(NextButtonLocator);
	     NextButton.click();
	     
	    LocalDate localDate = LocalDate.now();
	    localDate=localDate.plusMonths(2);
	    String Month =localDate.getMonth().getDisplayName(TextStyle.FULL, Locale.ENGLISH);
	    int year = localDate.getYear();
	    
	    By MonthCalendorlocator = By.xpath("//div[@data-testid='undefined-month-"+Month+"-"+year+"']");
	    WebElement monthCalendor = wait.until(ExpectedConditions.visibilityOfElementLocated(MonthCalendorlocator));
	    
	    By DateLocator = By.xpath(".//div[contains(text(),'16')]");
	    monthCalendor.findElement(DateLocator).click();
	    
	     
		
		
	}

}
