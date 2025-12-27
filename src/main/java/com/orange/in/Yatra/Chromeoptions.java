package com.orange.in.Yatra;

import java.util.Arrays;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Chromeoptions {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		ChromeOptions options = new ChromeOptions();
	//	options.setExperimentalOption("excludeSwitchs", new String[] {"enable-automation"});
		//options.setExperimentalOption("excludeSwitches", Arrays.asList("enable-automation") );
		WebDriver driver = new ChromeDriver(options);
		driver.get("https://www.youtube.com/watch?v=u_LZqEAfExg");
		
		
		

	}

}
