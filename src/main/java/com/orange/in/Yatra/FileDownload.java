package com.orange.in.Yatra;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class FileDownload {
	public static void main(String[] args) throws InterruptedException {
		
		
		
		
		String jenkinsdownloadfolder=System.getProperty("user.dir")+File.separator+"JenkinsDownloadFolder";
		File jenkinsfile = new File(jenkinsdownloadfolder);
		if(!jenkinsfile.exists()) {
			System.out.println("Jenkins folder not present!!1");
			if(jenkinsfile.mkdir()) {
				System.out.println("Folder Created!!!!");
			}
		}
		
		Map<String,Object>prefs = new HashMap<String, Object>();
		prefs.put("download.default_directory", jenkinsdownloadfolder);
		prefs.put("download.prompt_for_download", false);
		
		
		ChromeOptions chromeoptions = new ChromeOptions();
		chromeoptions.addArguments("--start-maximized");
		chromeoptions.setExperimentalOption("prefs", prefs);
		WebDriver driver = new ChromeDriver(chromeoptions);
		
		driver.get("https://get.jenkins.io/war-stable/2.528.2/jenkins.war");
		//driver.findElement(By.xpath("//a[@class='app-button app-button--primary']")).click();
		
		
		//TOchek the file Download successfully
		File jenkinsFile = new File(jenkinsfile,"jenkins3.war");
		int timeout =30;
		int elapsedtime =0;
		while(elapsedtime<timeout && !jenkinsFile.exists()) {
			Thread.sleep(1000);
			elapsedtime++;
			System.out.println("Waiting for file downlaod!!!");
			
			
		}if(jenkinsFile.exists()) {
			System.out.println("File Download syccessfully");
		}else {
			System.err.println("File could not able to download the file!!!!!!!");
		}
		
		
	}
	

}
