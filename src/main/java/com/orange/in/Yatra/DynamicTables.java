package com.orange.in.Yatra;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class DynamicTables {
	public static void main(String[] args) {

		WebDriver driver = new ChromeDriver();
		driver.get("https://practice.expandtesting.com/dynamic-table");
		driver.manage().window().maximize();
		By tableLocator = By.xpath("//table[@class='table table-striped']");
		WebElement tableElement = driver.findElement(tableLocator);
		List<WebElement> hearlist = tableElement.findElements(By.xpath(".//thead/tr/th"));
		Map<String, Integer> headerlist = new HashMap<String, Integer>();
		for (int index = 0; index < hearlist.size(); index++) {
			System.out.println("index for the list :" + hearlist.get(index).getText() + "indexs:" + index);
			headerlist.put(hearlist.get(index).getText().toLowerCase(), index);
		}
		System.out.println(headerlist);
		List<TaskPOJO> tasklist = new ArrayList<TaskPOJO>();
		List<WebElement> rowList = tableElement.findElements(By.xpath(".//tbody/tr"));
		for (WebElement row : rowList) {
			List<WebElement> datalist = row.findElements(By.xpath(".//td"));
			tasklist.add(new TaskPOJO(datalist.get(headerlist.get("name")).getText(),
					datalist.get(headerlist.get("memory")).getText(), datalist.get(headerlist.get("cpu")).getText(),
					datalist.get(headerlist.get("disk")).getText(), datalist.get(headerlist.get("network")).getText()));
		}
//		List<TaskPOJO> list = tasklist.stream().filter(x->x.getName().contains("Chrome")).toList();
//		System.out.println(list);
		
		for (TaskPOJO task : tasklist) {
		    if (task.getName() != null && task.getName().contains("Chrome")) {
		        System.out.println(task);
		    }
		}

		
		
		driver.quit();

	}

}
