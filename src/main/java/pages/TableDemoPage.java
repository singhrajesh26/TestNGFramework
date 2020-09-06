package pages;

import java.util.List;
import java.util.function.Predicate;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class TableDemoPage {

	public final WebDriver driver;
	
	public TableDemoPage(WebDriver driver) {
		this.driver=driver;
	}
	
	public void goTo() {
		
		this.driver.get("https://vins-udemy.s3.amazonaws.com/java/html/java8-stream-table-1.html");
	}
	
	public void selectRow(Predicate<List<WebElement>> predicate) {
		
		 driver.findElements(By.tagName("tr"))
		 .stream()
		 .skip(1)
		 .map(tr -> tr.findElements(By.tagName("td")))
		 .filter(tdList -> tdList.size() ==4)
		 .filter(predicate)
		 .map(tdList -> tdList.get(3))
		 .map(td -> td.findElement(By.tagName("input")))
		 .forEach(WebElement::click);
	}
}
