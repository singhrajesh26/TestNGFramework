package com.udemy.java.test;

import java.util.List;
import java.util.function.Predicate;

import org.apache.tools.ant.filters.LineContains.Contains;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import suppiler.Rules;

public class NewTestSel {

	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver", "D:\\Software\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://www.google.com/");

		List<WebElement> elements = driver.findElements(By.tagName("a"));
		//.forEach(e -> System.out.println(e.getText()));
		
		
		
		
		System.out.println("Befor ::" + elements.size());
		
		//Rules.get().forEach(rule -> elements.removeIf(rule));
		
		Rules.get().forEach(elements::removeIf);
		
		System.out.println("After ::" + elements.size());
		
		
		
		elements.forEach(e ->System.out.println(e.getText()));
		
		driver.quit();
	}

}
