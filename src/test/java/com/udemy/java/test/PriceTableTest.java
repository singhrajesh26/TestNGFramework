package com.udemy.java.test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.google.common.util.concurrent.Uninterruptibles;
import com.udemy.java.PriceTable;

import junit.framework.Assert;
import suppiler.DriverFactory;


public class PriceTableTest {

	private WebDriver driver;

	
	@BeforeTest
    @Parameters("browser")
	public void setDriver(@Optional ("chrome") String browser) {
		
		this.driver = DriverFactory.getDriver(browser);
		
		
		
	}
	@Test()	
	public void minPriceTest() {
		
		PriceTable p = new PriceTable(driver);
		p.selectMinPriceRow();
		String status = p.getStatus();
		Assert.assertEquals("PASS", status);
		
		Uninterruptibles.sleepUninterruptibly(3, TimeUnit.SECONDS);
	}
	
	
	
	
	@AfterTest
	
	public void quitDriver() {
		this.driver.quit();
	}

}
