package com.udemy.java.test;

import java.util.List;
import java.util.function.Predicate;

import org.apache.tools.ant.filters.LineContains.Contains;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import suppiler.Rules;

public class FiltersLinkWithStreamFoeWebPage {

	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver", "D:\\Software\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://www.google.com/");

		 driver.findElements(By.tagName("a"))
		 .stream().filter(e -> e.getText().trim().length() >0)
		 .filter(e -> !e.getText().contains("s"))
		 .map(e -> e.getText().toUpperCase())
		// .forEach(e -> System.out.println(e));
		 .forEach(System.out::println);
		
		
		driver.quit();
	}

}
