package com.udemy.java.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestCheckBox {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "D:\\Software\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://vins-udemy.s3.amazonaws.com/java/html/java8-stream-table-1.html");

		 driver.findElements(By.tagName("tr"))
		 .stream()
		 .skip(1)
		 .map(tr -> tr.findElements(By.tagName("td")))
		 .filter(tdList -> tdList.size() ==4)
		 .filter(tdList -> tdList.get(1).getText().equalsIgnoreCase("male"))
		 .map(tdList -> tdList.get(3))
		 .map(td -> td.findElement(By.tagName("input")))
		 .forEach(WebElement::click);
		
		
		//driver.quit();

	}

}
