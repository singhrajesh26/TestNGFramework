package com.udemy.java;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PriceTable {
	
	private final WebDriver driver;
	
	@FindBy(css = "table#prods tr")
	private List<WebElement> rows;
	
	@FindBy(id = "result")	
	private WebElement verifyButton ;
	
	@FindBy(id = "status")	
	private WebElement status ;
	
	
	public PriceTable(WebDriver driver) {
		
		this.driver = driver;
		this.driver.get("https://vins-udemy.s3.amazonaws.com/java/html/java8-stream-table-price.html");
		
		PageFactory.initElements(driver, this);
		
	}
	
	public void selectMinPriceRow() {
		Optional<List<WebElement>> minRow = rows.stream()
		.skip(1)
		.map(tr -> tr.findElements(By.tagName("td")))
		.min(Comparator.comparing(tdList -> Integer.parseInt(tdList.get(2).getText())));
		
		//.min(Comparator.comparing(tdList -> Integer.parseInt(tdList.get().getText())));
		
		if(minRow.isPresent()) {
			List<WebElement> cells = minRow.get();
			cells.get(3).findElement(By.tagName("input")).click();
		}
		
		this.verifyButton.click();
	}
	
	public String getStatus() {
		return this.status.getText().trim();
		
	}

}
