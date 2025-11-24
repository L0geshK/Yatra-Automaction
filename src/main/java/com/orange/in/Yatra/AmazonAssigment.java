package com.orange.in.Yatra;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AmazonAssigment {
	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.amazon.in/");
		driver.manage().window().maximize();
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		 WebElement Listlocation=driver.findElement(By.xpath("//button[@aria-label='Expand Account and Lists']"));
		 
	
		js.executeScript("arguments[0].style.border='3px solid red'", Listlocation);
		Listlocation.click();
		
		
		
		
		
		
		 WebElement youraccount=driver.findElement(By.xpath("//span[contains(text(),'Your Account')]"));
		js.executeScript("arguments[0].style.border='3px solid red'", youraccount);
		youraccount.click();
	  String text =  driver.findElement(By.xpath("//div[@class='a-row a-spacing-base']")).getText();
	  System.out.println(text);
	    
	}

}
