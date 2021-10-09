package com.google.com.DemoCart;

import org.testng.annotations.Test;

public class TestClass {
	
	@Test(priority = 1)
	public static void openBrowser() {
		System.out.println("Browser Launched");

	}
	
	@Test(priority = 2)
	private void getUrl() {
		System.out.println("Navigated To URL");

	}

}
