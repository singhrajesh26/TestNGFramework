package com.udemy.java.test;

import util.LinkUtil;

public class TestResponseOfTheURL {

	public static void main(String[] args) {
		
		//200
		//404 something wrong at our side
		//0 host is not available
		//500
		
		System.out.println(
				
				
				LinkUtil.getResponseCode("https://www.google.com/sdhwhdkwhdkwl")
				
				);

	}

}
