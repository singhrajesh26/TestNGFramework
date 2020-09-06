package com.udemy.java.test;

import org.testng.annotations.Test;

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

import com.beust.jcommander.Parameter;
import com.google.common.util.concurrent.Uninterruptibles;

import pages.TableDemoPage;
import suppiler.DriverFactory;
import suppiler.SearchCriteriaFactory;

public class DriverTest {

	private WebDriver driver;
	private TableDemoPage tableDemoPage;
	
	@BeforeTest
    @Parameters("browser")
	public void setDriver(@Optional ("chrome") String browser) {
		
		this.driver = DriverFactory.getDriver(browser);
		this.tableDemoPage = new TableDemoPage(driver);
		
	}
	@Test(dataProvider = "criteriaProvider")	
	public void tableRowTest(Predicate<List<WebElement>> searchCriteria) {
		
		tableDemoPage.goTo();
		tableDemoPage.selectRow(searchCriteria); 		
		 Uninterruptibles.sleepUninterruptibly(1, TimeUnit.SECONDS);
	}
	
	@DataProvider(name ="criteriaProvider")
	public Object[] testdata() {
		
		return new Object[] {
				
				SearchCriteriaFactory.getCriteria("allMale"),				
				SearchCriteriaFactory.getCriteria("allFemale"),
				SearchCriteriaFactory.getCriteria("allGender"),
				SearchCriteriaFactory.getCriteria("allAU"),
				SearchCriteriaFactory.getCriteria("fenaleAU"),
				
		};
	}
	
	@AfterTest
	
	public void quitDriver() {
		this.driver.quit();
	}

}
