package com.udemy.java.test;

import java.time.LocalDateTime;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.google.common.util.concurrent.Uninterruptibles;

import pages.TableDemoPage;
import suppiler.DriverFactory;
import util.LinkUtil;

public class BrokenLinkTestAnyMatch {

	
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
		
		//this.driver.get("https://the-internet.herokuapp.com/broken_images");
		
		this.driver.get("https://www.google.com");
		
		System.out.println("Before :: " + LocalDateTime.now());
		
		List<String> collect = this.driver.findElements(By.xpath("//*[@href]"))  // can use link for "//*[@href]"
		.stream()
		.parallel()
		.map(e -> e.getAttribute("href"))		// href
		.filter(src -> LinkUtil.getResponseCode(src) != 200)
		.collect(Collectors.toList());
		
		System.out.println("After :: " + LocalDateTime.now());
		
		System.out.println(collect);
		/*.map(src -> LinkUtil.getResponseCode(src))
		.anyMatch(rc -> rc != 200); 		
		Assert.assertFalse(anyMatch);*/
		//Assert.assertEquals(collect.size(), 0, collect.toString());
		           
		 
	}
	
		
	@AfterTest
	
	public void quitDriver() {
		this.driver.quit();
	}
	
}
