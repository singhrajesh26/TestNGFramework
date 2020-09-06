package com.udemy.java.test;

import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.function.Predicate;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.google.common.util.concurrent.Uninterruptibles;

import pages.TableDemoPage;
import suppiler.DriverFactory;
import suppiler.SearchCriteriaFactory;
import util.LinkUtil;

public class BrokenLinkTest {

	
	private WebDriver driver;
	private TableDemoPage tableDemoPage;
	
	@BeforeTest
    @Parameters("browser")
	public void setDriver(@Optional ("chrome") String browser) {
		
		this.driver = DriverFactory.getDriver(browser);
		this.tableDemoPage = new TableDemoPage(driver);
		
	}
	//https://the-internet.herokuapp.com/broken_images
	
	@Test()	
	public void linkTest() {
		
		this.driver.get("https://the-internet.herokuapp.com/broken_images");
		
		this.driver.findElements(By.xpath("//*[@src]"))  // can use link for "//*[@href]"
		.stream()
		.map(e -> e.getAttribute("src"))		// href
		.forEach(src -> {
			System.out.println(LinkUtil.getResponseCode(src) + " :: " + src);
		});
		           
		 Uninterruptibles.sleepUninterruptibly(1, TimeUnit.SECONDS);
	}
	
		
	@AfterTest
	
	public void quitDriver() {
		this.driver.quit();
	}
	
}
