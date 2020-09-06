package suppiler;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverFactory {
	
	static final Supplier<WebDriver> chromeSuppliler= () -> {
		System.setProperty("webdriver.chrome.driver", "D:\\Software\\chromedriver.exe");
		return new ChromeDriver();
		
	};
	
	static final Supplier<WebDriver> firefoxSuppiler= () -> {
		System.setProperty("webdriver.gecko.driver", "D:\\Software\\geckodriver.exe");
		return new FirefoxDriver();
		
	};
	
	private static final Map<String, Supplier<WebDriver>> MAP = new HashMap<>();
	
	static {
		
		MAP.put("chrome", chromeSuppliler);
		MAP.put("firefox", firefoxSuppiler);
	}
	
	public static WebDriver getDriver(String browser) {
		
		return MAP.get(browser).get();
		
	}

}

