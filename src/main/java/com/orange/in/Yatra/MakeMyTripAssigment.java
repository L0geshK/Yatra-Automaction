package com.orange.in.Yatra;

import java.time.Duration;
import java.time.LocalDate;
import java.time.format.TextStyle;
import java.util.List;
import java.util.Locale;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MakeMyTripAssigment {

	public static void getdates() {
		LocalDate date = LocalDate.now();
		date = date.plusDays(10);
		System.out.println(date.getMonth().getDisplayName(TextStyle.FULL, Locale.ENGLISH));
	}

	public static void main(String[] args) {
		getdates();

		ChromeOptions chromeoptions = new ChromeOptions();

		chromeoptions.addArguments("--start-maximized");
		WebDriver wd = new ChromeDriver(chromeoptions);

		wd.get("https://www.makemytrip.com/");
		WebDriverWait wait = new WebDriverWait(wd, Duration.ofSeconds(30));
		By Closepopuplocator = By.xpath("//span[@data-cy=\"closeModal\"]");
		WebElement closedbutton = wait.until(ExpectedConditions.elementToBeClickable(Closepopuplocator));
		closedbutton.click();

		// FromCity
		By FromCityLablelocator = By.xpath("//label[@for=\"fromCity\"]");
		WebElement FromCityLable = wait.until(ExpectedConditions.visibilityOfElementLocated(FromCityLablelocator));
		FromCityLable.click();

		By FromCityLableInputlocatorInput = By.xpath("//input[@placeholder=\"From\"]");
		WebElement FromCityLableInput = wait
				.until(ExpectedConditions.visibilityOfElementLocated(FromCityLableInputlocatorInput));
		FromCityLableInput.sendKeys("Chennai");
		//// p[contains(text(), "SUGGESTIONS")]/../../ul/li xpath for auto SUGGESTIONS
		//// drop down

		By FromCityAutoSuggestionlocation = By.xpath(
				"//p[contains(text(), \"SUGGESTIONS\")]/ancestor::div[contains(@class,\"react-autosuggest\")]/ul/li");
		boolean state = wait.until(ExpectedConditions.and(
				ExpectedConditions.visibilityOfAllElementsLocatedBy(FromCityAutoSuggestionlocation),
				ExpectedConditions.numberOfElementsToBeLessThan(FromCityAutoSuggestionlocation, 12)));
		List<WebElement> FromCityAutoSuggestionlist = null;

		if (state) {
			FromCityAutoSuggestionlist = wait
					.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(FromCityAutoSuggestionlocation));
		}
		System.out.println(FromCityAutoSuggestionlist.size());

		for (WebElement suggestion : FromCityAutoSuggestionlist) {
			System.out.println(suggestion.getText());
		}
		FromCityAutoSuggestionlist.get(0).click();
		System.out.println(FromCityAutoSuggestionlist.get(0));

		// TOCity
		By ToCityLablelocator = By.xpath("//label[@for=\"toCity\"]");
		WebElement ToCityLable = wait.until(ExpectedConditions.visibilityOfElementLocated(ToCityLablelocator));
		ToCityLable.click();

		By ToCityLableInputlocatorInput = By.xpath("//input[@placeholder=\"To\"]");
		WebElement ToCityLableInput = wait
				.until(ExpectedConditions.visibilityOfElementLocated(ToCityLableInputlocatorInput));
		ToCityLableInput.sendKeys("pune");

		By ToCityAutoSuggestionlocation = By.xpath(
				"//p[contains(text(), \"SUGGESTIONS\")]/ancestor::div[contains(@class,\"react-autosuggest\")]/ul/li");
		boolean state1 = wait.until(ExpectedConditions.and(
				ExpectedConditions.visibilityOfAllElementsLocatedBy(ToCityAutoSuggestionlocation),
				ExpectedConditions.numberOfElementsToBeLessThan(ToCityAutoSuggestionlocation, 12)));
		List<WebElement> ToCityAutoSuggestionlist = null;

		if (state) {
			ToCityAutoSuggestionlist = wait
					.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(ToCityAutoSuggestionlocation));
		}
		System.out.println(ToCityAutoSuggestionlist.size());

		for (WebElement suggestion : ToCityAutoSuggestionlist) {
			System.out.println(suggestion.getText());
		}
		ToCityAutoSuggestionlist.get(0).click();
		System.out.println(ToCityAutoSuggestionlist.get(0));

		LocalDate targetDate = LocalDate.now();
		targetDate = targetDate.plusDays(5);
		String TargetMonth = targetDate.getMonth().getDisplayName(TextStyle.FULL, Locale.ENGLISH);
		int TargetYear = targetDate.getYear();
		int targetday = targetDate.getDayOfMonth();

		// div[contains(text(),"+TargetMonth+""+TargetYear+")]/ancestor::div[@class="DayPicker-Month"]
		System.out.println("//div[contains(text()," + TargetMonth + " " + TargetYear
				+ ")]/ancestor::div[@class=\"DayPicker-Month\"]");

//		By CalendarmonthLocator = By.xpath("//div[contains(text(),'"+TargetMonth+" "+TargetYear+"')]/ancestor::div[@class=\"DayPicker-Month\"]");
//		WebElement Calendarmonth = wait.until(ExpectedConditions.visibilityOfElementLocated(CalendarmonthLocator));
//	
//	//p[contains(text(),"+targetDate+")]/ancestor::div[contains(@class,\"DayPicker-Day\")]
//	System.out.println("//p[contains(text(),"+targetDate+")]/ancestor::div[contains(@class,\\\"DayPicker-Day\\\")]");
//		By CalendarDaysLocator = By.xpath(".//p[contains(text(),'"+targetDate+"')]/ancestor::div[contains(@class,\"DayPicker-Day\")]");
//	WebElement day= Calendarmonth.findElement(CalendarDaysLocator);
//		day.click();

		By CalendarmonthLocator = By.xpath("//div[contains(text(),'" + TargetMonth + " " + TargetYear
				+ "')]/ancestor::div[@class='DayPicker-Month']");
		WebElement Calendarmonth = wait.until(ExpectedConditions.visibilityOfElementLocated(CalendarmonthLocator));

		By CalendarDaysLocator = By
				.xpath(".//p[text()='" + targetday + "']/ancestor::div[contains(@class,'DayPicker-Day')]");
		WebElement day = Calendarmonth.findElement(CalendarDaysLocator);
		day.click();

	}

}
