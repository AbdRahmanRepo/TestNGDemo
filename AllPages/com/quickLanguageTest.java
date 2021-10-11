package com.AllPages.com;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.beust.jcommander.Parameter;
import com.fasterxml.jackson.databind.ser.std.StdKeySerializers.Default;

import io.github.bonigarcia.wdm.WebDriverManager;

public class quickLanguageTest {
	SoftAssert soft = new SoftAssert(); 
	public static WebDriver driver;
	
	@Parameters({"browserName", "url" })
	@BeforeTest
	public void setUp(String browserName, String Url) throws Exception {
		switch(browserName) {
		
		case "Chrome" :
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			driver.manage().window().maximize();
			break;
			
		case "Edge":
			WebDriverManager.edgedriver().setup();
			driver = new ChromeDriver();
			driver.manage().window().maximize();
			break;
			
		default:
			System.err.println("Invalid Browser Name");
			break;
		}
		
		
		//		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().deleteAllCookies();
		driver.get(Url);
		}
	
	@Parameters({"username","password"})
	@Test(priority = 1, groups = "login")
	private void TC_004(String username, String password) {

		driver.findElement(By.id("txtUsername")).sendKeys(username);
		driver.findElement(By.id("txtPassword")).sendKeys(password);
		driver.findElement(By.id("btnLogin")).click();
		System.out.println(driver.getCurrentUrl());
		String actURL = driver.getCurrentUrl();
		String expURL = "https://opensource-demo.orangehrmlive.com/index.php/dashboard";
		Assert.assertEquals(actURL, expURL);

	}
	
	@Test(priority = 5, dependsOnMethods = "TC_004")       //(priority = 5, dependsOnMethods = "TC_004")
	public void quickLanguage() {
		//Assign Leave
		boolean assignLeave = driver.findElement(By.xpath("//span[.='Assign Leave']")).isEnabled();
		soft.assertTrue(assignLeave, "Assign Leave is not Enabled");
		//Leave List
		boolean leaveList = driver.findElement(By.xpath("//span[text()='Leave List']")).isEnabled();
		soft.assertTrue(leaveList, "Leave List is not Enabled");
		//Time sheets
		boolean timesheets = driver.findElement(By.xpath("//span[text()='Timesheets']")).isEnabled();
		soft.assertTrue(timesheets, "Time sheets  is not Enabled");
		//Apply Leave
		boolean applyLeave = driver.findElement(By.xpath("//span[text()='Apply Leave']")).isEnabled();
		soft.assertTrue(applyLeave, "Apply Leave is not Enabled");
		//My Leave
		boolean myLeave = driver.findElement(By.xpath("//span[text()='My Leave']")).isEnabled();
		soft.assertTrue(myLeave, "My Leave is not Enabled");
		//My TimeSheet
		boolean myTimesheet = driver.findElement(By.xpath("//span[text()='My Timesheet']")).isEnabled();
		soft.assertTrue(myTimesheet, "My Timesheet is not Enabled");
		//AssertAll
		soft.assertAll();
		
	}
	
	@Parameters("sleepTime")   //Directly read the value as that specific format 
	@AfterTest
	public void tearDown(Long sleepTime) throws Exception {  //String sleepTime
		//System.out.println(sleepTime);
		Thread.sleep(sleepTime);						                               //Thread.sleep(Long.valueOf(sleepTime));
		driver.quit();
	}

}
