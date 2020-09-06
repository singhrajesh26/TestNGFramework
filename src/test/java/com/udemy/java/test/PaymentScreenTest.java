package com.udemy.java.test;

import java.util.concurrent.TimeUnit;
import java.util.function.Consumer;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import static com.udemy.java.test.PaymentScreenActions.*;
import com.google.common.util.concurrent.Uninterruptibles;
import com.udemy.java.PaymentScreenPage;

import suppiler.DriverFactory;

public class PaymentScreenTest {
	
	private WebDriver driver;
	private PaymentScreenPage paymentScreenPage;
	
	@BeforeTest
    @Parameters("browser")
	public void setDriver(@Optional ("chrome") String browser) {
		
		this.driver = DriverFactory.getDriver(browser);
		this.paymentScreenPage = new PaymentScreenPage(driver);
		
	}
	@Test(dataProvider = "criteriaProvider")	
	public void paymentScreenTest(Consumer<PaymentScreenPage> consumer) {
		paymentScreenPage.goTo();
		consumer.accept(paymentScreenPage);
		
			
		 Uninterruptibles.sleepUninterruptibly(6, TimeUnit.SECONDS);
	}
	
	@DataProvider(name ="criteriaProvider")
	public Object[] testdata() {
		
		return new Object[] {
				
			validCC.andThen(buy).andThen(successfulPurchase),
			freeCoupon.andThen(buy).andThen(successfulPurchase),
			discountedCoupon.andThen(validCC).andThen(buy).andThen(successfulPurchase),
			inValidCC.andThen(buy).andThen(failPurchase),
			inValidCC.andThen(discountedCoupon).andThen(buy).andThen(failPurchase),
			buy.andThen(failPurchase)
			
				
		};
	}
	
	@AfterTest
	
	public void quitDriver() {
		this.driver.quit();
	}

}
