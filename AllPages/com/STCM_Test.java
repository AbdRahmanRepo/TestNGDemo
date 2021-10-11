package com.AllPages.com;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class STCM_Test {
	
		@Test
		private void testCase001() {
			System.out.println("testCase001 Executing");

		}
		
		@Test
		private void testCase002() {
			System.out.println("testCase002 Executing");

		}
		
	
		@BeforeSuite
		public void beforeSuit() {
			System.out.println("beforeSuit");

		}
		@BeforeTest
		public void beforeTest() {
			System.out.println("beforeTest");

		}
		@BeforeClass
		private void beforeClass() {
			System.out.println("beforeClass");

		}
		@BeforeMethod
		private void beforeMethod() {
			System.out.println("beforeMethod");

		}
		@AfterMethod
		private void afterMethod() {
			System.out.println("afterMethod");

		}
		@AfterClass
		private void afterClass() {
			System.out.println("afterClass");

		}
		@AfterTest
		public void afterTest() {
			System.out.println("afterTest");

		}
		@AfterSuite
		public void afterSuit() {
			System.out.println("afterSuit");

		}

}
