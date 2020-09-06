package com.udemy.java.test;

import java.util.function.Consumer;

import org.testng.Assert;

import com.udemy.java.PaymentScreenPage;

public class PaymentScreenActions {
	
	public static final Consumer<PaymentScreenPage> freeCoupon = (p) -> p.applyPromoCode("FREEUDEMY");
	public static final Consumer<PaymentScreenPage> discountedCoupon = (p) -> p.applyPromoCode("PARTIALUDEMY");
	public static final Consumer<PaymentScreenPage> validCC = (p) -> p.enterCC("4111111111111111", "2023", "123");
	public static final Consumer<PaymentScreenPage> inValidCC = (p) -> p.enterCC("4111111111111122", "2023", "123");
	public static final Consumer<PaymentScreenPage> buy = (p) -> p.buyProduct();
	
	//Validation
	public static final Consumer<PaymentScreenPage> successfulPurchase = (p) -> Assert.assertEquals(p.getStatus(), "PASS");
	public static final Consumer<PaymentScreenPage> failPurchase = (p) -> Assert.assertEquals(p.getStatus(), "FAIL");
}
