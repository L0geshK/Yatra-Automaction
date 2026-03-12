package com.orange.in.Yatra;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Amazonass {
	public static void main(String[] args) {
		
		
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--start-maximized");
		WebDriver driver = new ChromeDriver(options);
		driver.get("https://www.amazon.in/");
		By searchboxlocator = By.id("twotabsearchtextbox");
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		WebElement search = wait.until(ExpectedConditions.visibilityOfElementLocated(searchboxlocator));
		search.sendKeys("iphone 17");
		
		By searchbuttonlocator  = By.id("nav-search-submit-button");
		WebElement searchbutton = wait.until(ExpectedConditions.visibilityOfElementLocated(searchbuttonlocator));
		searchbutton.click();
		
		By Productlocator = By.xpath("//div[@data-cy='asin-faceout-container']");
		
		List<WebElement>products = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(Productlocator));
		System.out.println(products.size());
		
		products.forEach(i -> System.out.println(i.getText()));
		
		List<product> productlist = new ArrayList<product>();
		for(WebElement product :products) {
			By productnameLocator = By.tagName("h2");
			WebElement productnamelist = product.findElement(Productlocator);
			String productname=productnamelist.getText();
			
			
		
			
			By linklocator = By.xpath(".//a[contains(@class,'a-link-normal')]");
			WebElement productLink = product.findElement(linklocator);
			
			
			By productpricelocator = By.xpath(".//span[@class='a-price-whole']");
			List<WebElement> pricelistelement = product.findElements(productpricelocator);
			String price;
			if(pricelistelement.size() >0) {
				price=pricelistelement.get(0).getText();
			}else {
				price="Price not Avaliable";
			}
		
			
			By addtoCardlocator = By.xpath(".//button[@class='a-button-text']");
			List<WebElement> addToCardButtonlist= product.findElements(addtoCardlocator);
			WebElement addToCardButton=null;
			if(addToCardButtonlist.size() >0) {
				addToCardButton=addToCardButtonlist.get(0);
			}
			product prod = new product(productname, price, addToCardButton, productLink);
			productlist.add(prod);
			
			
		}
		productlist.forEach(i -> System.out.println(i));
		//productlist.get(0).getAddToCardButton().click();
		productlist.get(0).getProductLink().click();
		
		String parentwindow = driver.getWindowHandle();
		Set<String>allwindows = driver.getWindowHandles();
		String Childwindow = null;
		for(String handels :allwindows) {
			if(!handels.equalsIgnoreCase(parentwindow)) {
				Childwindow=handels;
			}
		}
		driver.switchTo().window(Childwindow);
			
		By addtocardlocator = By.xpath("//div[@id='newAccordionRow_0']//input[@id='add-to-cart-button']");
		WebElement addtocard = wait.until(ExpectedConditions.visibilityOfElementLocated(addtocardlocator));
		addtocard.click();
		
		
		
		
	}

}
