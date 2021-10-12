//@ignore-when ignore at package level have create file as package-info.java
package com.AllPages.com;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

// @Ignore - we can specify at class level also
//@Test(groups= {"All"}) - Partial Group
public class STCM_Test {
	@Test(priority = 1, groups= {"smoke","functional","regresion, windows.sanity"})
	private void testCase1() {
		System.out.println("testCase 1 Executing, smoke,functional,regresion and Regular Expression windows.sanity");

	}
	@Test(groups= "suiteLvl")
	private void testCase() {
		System.out.println("testCase Group level Executing method");

	}

	@Test(priority = 3, groups= "smoke, ios.sanity") //ios.sanity - Regular Expression
	private void testCase3() {
		System.out.println("testCase 3 Executing,smoke only and Regular Expression ios.sanity");

	}
	@Test(priority = 6, groups= {"sanity","regresion, windows.smoke"})
	private void testCase6() {
		System.out.println("testCase 6 Executing,sanity,regresion and Regular Expression windows.smoke");

	}
	@Test(priority = 3, groups= {"smoke","functional"})
	private void testCase7() {
		System.out.println("testCase 7 Executing,smoke,functional");

	}
	@Test(priority = 3, groups= "functional")
	private void testCase8() {
		System.out.println("testCase 8 Executing, functional");

	}
	@Test(priority = 9,groups= {"smoke","regresion"})
	private void testCase9() {
		System.out.println("testCase 9 Executing, smoke,regresion ");

	}
	
	@Ignore			//this also Ignoring method
	@Test(priority = 4,enabled=true )	//even method enabled...ignore has diabled method..ignore has highest precidence
	private void testCase4() {
		System.out.println("testCase 4 Executing");

	}
	@Test(priority = 5, enabled= false)		//ignore case at method level
	private void testCase5() {
		System.out.println("testCase 5 Executing");

	}

	@Test(priority = 2)
	private void testCase002() {
		System.out.println("testCase 2 Executing");

	}


//	@BeforeSuite
//	public void beforeSuit() {
//		System.out.println("beforeSuit");
//
//	}
//	@BeforeTest
//	public void beforeTest() {
//		System.out.println("beforeTest");
//
//	}
//	@BeforeClass
//	private void beforeClass() {
//		System.out.println("beforeClass");
//
//	}
//	@BeforeMethod
//	private void beforeMethod() {
//		System.out.println("beforeMethod");
//
//	}
//	@AfterMethod
//	private void afterMethod() {
//		System.out.println("afterMethod");
//
//	}
//	@AfterClass
//	private void afterClass() {
//		System.out.println("afterClass");
//
//	}
//	@AfterTest
//	public void afterTest() {
//		System.out.println("afterTest");
//
//	}
//	@AfterSuite
//	public void afterSuit() {
//		System.out.println("afterSuit");
//
//	}

}

