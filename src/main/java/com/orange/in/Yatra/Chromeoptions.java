package com.orange.in.Yatra;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Chromeoptions {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		
		ChromeOptions chrom = new ChromeOptions();
		chrom.setExperimentalOption("debuggerAddress", "127.0.0.1:9222");
		WebDriver wd =new ChromeDriver(chrom);
		wd.get("https://www.google.com/");
		Thread.sleep(2000);
		wd.get("https://www.facebook.com/");

	}

}
