package com.orange.in.Yatra;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class CssSelector {

	public static void main(String[] args) {
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--start-maximized");
		options.setExperimentalOption("excludeSwitches", new String[] { "enable-automation" });
		options.setExperimentalOption("useAutomationExtension", false);
		WebDriver driver = new ChromeDriver(options);
		driver.get("https://jatin99.github.io/ShadowDomAssignment/");

		By enteryoutnamelocator = By.cssSelector("input#email");
		WebElement namelocator = driver.findElement(enteryoutnamelocator);
		namelocator.sendKeys("logesh");

		By headertextlocator = By.cssSelector("div.header");
		WebElement headertext = driver.findElement(headertextlocator);
		System.out.println(headertext.getText());

		By Submitbuttonlocator = By.cssSelector("button[type='submit']");
		WebElement Submitbutton = driver.findElement(Submitbuttonlocator);
		Submitbutton.click();

		By CombinedClasseslocator = By.cssSelector("div.main.header");
		WebElement CombinedClasses = driver.findElement(CombinedClasseslocator);
		System.out.println(CombinedClasses.getText());

		By itemlocator = By.cssSelector("ul>li");
		WebElement item = driver.findElement(itemlocator);
		System.out.println(item.getText());

		List<WebElement> itemlist = driver.findElements(itemlocator);
		System.out.println(itemlist.size());

		System.out.println(itemlist.get(4).getText());

		By itemlocator3 = By.cssSelector("ul>li:nth-child(2)");
		WebElement item3 = driver.findElement(itemlocator3);
		System.out.println(item3.getText());

		By nestedspanlocator = By.cssSelector("div>span");
		WebElement nestedspan = driver.findElement(nestedspanlocator);
		System.out.println(nestedspan.getText());

//		By Linktextlocator = By.cssSelector("a[href *='login']");
//		WebElement linktext = driver.findElement(Linktextlocator);
//		linktext.click();

		// to handle Shadow element

		By mcomponentLocator = By.xpath("//my-component");
		WebElement mcomponent = driver.findElement(mcomponentLocator);
		SearchContext componenet = mcomponent.getShadowRoot();

		By headerloacator = By.cssSelector("div.header");
		WebElement headertextshadow = componenet.findElement(headerloacator);
		System.out.println(headertextshadow.getText());

	}
}
