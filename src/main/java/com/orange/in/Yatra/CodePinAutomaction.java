package com.orange.in.Yatra;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CodePinAutomaction {

	public static void main(String[] args) {

		String csscode = """
						        div {
				 background-color: red;
				 border-radius: 100%;
				 height: 50px;
				 left: calc(50% - 50px);
				 position: absolute;
				 right: calc(50% - 50px);
				 width: 50px;
				 animation: bounce 1s ease-in-out infinite;
				 animation-fill-mode: both;
				 animation-direction: alternate;
				}
				span {
				 border-radius: 100%;
				 bottom: 32.5%;
				 left: calc(50% - 50px);
				 right: calc(50% - 50px);
				 position: absolute;
				 content: '';
				 background-color: black;
				 filter: blur(3px);
				 width: 50px;
				 height: 5px;
				 animation: shadow 1s ease-in-out infinite;
				 animation-fill-mode: both;
				 animation-direction: alternate;
				 z-index: -1;
				}
				@keyframes bounce {
				www.techwithjatin.com
				 from {
				 top: 25%;
				 transform: scaleX(79.5%) scaleY(65%);
				 }
				 to {
				 top: 55%;
				 transform: scale(100%);
				 }
				}
				@keyframes shadow {
				 from {
				 opacity: 0;
				 transform: scale(0);
				 }
				 to {
				 opacity: .5;
				 transform: scale(100%);
				 }
				}
						        """;

		ChromeOptions chromeoptions = new ChromeOptions();
		chromeoptions.addArguments("--start-maximized");
		WebDriver wd = new ChromeDriver(chromeoptions);
		wd.get("https://codepen.io/rolandixor/pen/mdwZReq");

		By CodeMirrorLocator = By.cssSelector("div.CodeMirror");
		WebDriverWait wait = new WebDriverWait(wd, Duration.ofSeconds(50));

		List<WebElement> Codemirrorlist = wait
				.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(CodeMirrorLocator));

		System.out.println(Codemirrorlist.size());

		WebElement CssCodemirror = Codemirrorlist.get(1);

		By testAreaLocator = By.tagName("textarea");
		WebElement textarea = CssCodemirror.findElement(testAreaLocator);// Chaining of Weblement

		Actions actions = new Actions(wd);
		actions.click(textarea).perform();

		textarea.sendKeys(Keys.chord(Keys.CONTROL, "a"));
		textarea.sendKeys(Keys.DELETE);
		textarea.sendKeys(csscode);

	}

}
