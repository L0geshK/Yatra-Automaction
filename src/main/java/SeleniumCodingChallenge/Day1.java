package SeleniumCodingChallenge;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Day1 {
	/*
	 * Selenium Coding Challenge # Day 1
	 * 
	 * Open chrome/firefox browser Launch the URL :
	 * https://www.worldometers.info/world-p...
	 * 
	 * Keep getting the count of: Current World Population Today: Births, Deaths and
	 * population growth today This Year: Births, Deaths and population growth today
	 * 
	 * while(true){
	 * 
	 * keep getting the element text using selenium print it on console
	 * 
	 * //break the loop after few secs (20 secs) }
	 */

	public static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {

		driver = new ChromeDriver();
		driver.get("https://www.worldometers.info/world-population/");
		String xpathofelement = "//span[@rel='current_population']";
		String xpathofthisyear = "//div[text()='  This Year  ']/parent::div//span[@class='rts-counter text-2xl font-bold']";
		String xpathofTODAY = "//div[text()='  Today  ']/parent::div//span[@class='rts-counter text-2xl font-bold']";
		int count = 1;
		while (count <= 5) {
			if (count == 5)
				break;
		System.out.println("Current World populaction");
		printpopulaction(xpathofelement);
		System.out.println("Today World populaction");
		printpopulaction(xpathofTODAY);
		System.out.println("This year World populaction");
		printpopulaction(xpathofthisyear);
		Thread.sleep(1000);
		count++;
		}
	}

	public static void printpopulaction(String locator) {
//		try {
//			
//				List<WebElement> Listofelement = driver.findElements(By.xpath(locator));
//				for (WebElement e : Listofelement) {
//					System.out.println(e.getText());
//				}
//			
//		} catch (Exception e) {
//			e.printStackTrace();
//
//		}
		driver.findElements(By.xpath(locator)).stream().forEach(e -> System.out.println(e.getText()));
		
		
	}

}
