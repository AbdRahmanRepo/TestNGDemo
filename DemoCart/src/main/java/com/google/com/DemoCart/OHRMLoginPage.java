package com.google.com.DemoCart;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class OHRMLoginPage {
	
	SoftAssert soft = new SoftAssert(); 
	public static WebDriver driver;
	
	@BeforeClass
	public void setUp() throws Exception {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().deleteAllCookies();
		driver.get("https://opensource-demo.orangehrmlive.com/");
		
	}
	//Negative TC
	@Test(priority = 1, groups = "login")
	private void TC_001() {
		
		driver.findElement(By.id("txtUsername")).sendKeys("Aadmin");
		driver.findElement(By.id("txtPassword")).sendKeys("admin123");
		driver.findElement(By.id("btnLogin")).click();
		String actURL = driver.getCurrentUrl();
		String expURL = "https://opensource-demo.orangehrmlive.com/index.php/dashboard";
		Assert.assertNotEquals(actURL, expURL);
		
	}
	//Negative TC
	@Test(priority = 2, groups = "login")
	private void TC_002() {
		
		driver.findElement(By.id("txtUsername")).sendKeys("Admin");
		driver.findElement(By.id("txtPassword")).sendKeys("admin1234");
		driver.findElement(By.id("btnLogin")).click();
		String actURL = driver.getCurrentUrl();
		String expURL = "https://opensource-demo.orangehrmlive.com/index.php/dashboard";
		Assert.assertNotEquals(actURL, expURL);
		
	}
	//Negative TC
	@Test(priority = 3, groups = "login")
	private void TC_003() {
		
		driver.findElement(By.id("txtUsername")).sendKeys("Adminn");
		driver.findElement(By.id("txtPassword")).sendKeys("admin12334");
		driver.findElement(By.id("btnLogin")).click();
		String actURL = driver.getCurrentUrl();
		String expURL = "https://opensource-demo.orangehrmlive.com/index.php/dashboard";
		Assert.assertNotEquals(actURL, expURL);
		
	}
	//positive TC 
	@Test(priority = 4, groups = "login")
	private void TC_004() {
		
		driver.findElement(By.id("txtUsername")).sendKeys("Admin");
		driver.findElement(By.id("txtPassword")).sendKeys("admin123");
		driver.findElement(By.id("btnLogin")).click();
		System.out.println(driver.getCurrentUrl());
		String actURL = driver.getCurrentUrl();
		String expURL = "https://opensource-demo.orangehrmlive.com/index.php/dashboard";
		Assert.assertEquals(actURL, expURL);
		
	}
	@Test(priority = 5, dependsOnMethods = "TC_004")
	private void quickLanguageTest() {
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
	@Test(priority = 6, dependsOnMethods = "TC_004")
	private void recruitment() throws Throwable {  //String fname, String mname, String lname, String mailId, String contactnum, String kWrd, String cmt,String DOA
		//Move To RecruitmentPage
		driver.findElement(By.xpath("//b[.='Recruitment']")).click();
		
		//click Add
		driver.findElement(By.id("btnAdd")).click();
		
		//FirstName
		WebElement firstname = driver.findElement(By.id("addCandidate_firstName"));
		soft.assertTrue(firstname.isEnabled(), "firstname Field is Not Enabled");
		firstname.clear();
		firstname.sendKeys("abdul");
		
		//Middle Name
		WebElement middlename = driver.findElement(By.id("addCandidate_middleName"));
		soft.assertTrue(middlename.isEnabled(), "middlename Field is Not Enabled");
		middlename.clear();
		middlename.sendKeys("rahmajn");
		
		//Last Name
		WebElement lastname = driver.findElement(By.id("addCandidate_lastName"));
		soft.assertTrue(lastname.isEnabled(), "lastname Field is Not Enabled");
		lastname.clear();
		lastname.sendKeys("ibrahim");
		
		//Email
		WebElement email = driver.findElement(By.id("addCandidate_email"));
		soft.assertTrue(email.isEnabled(), "email Field is Not Enabled");
		email.clear();
		email.sendKeys("abransafa@gmail.com");
		
		//Contact number
		WebElement contactnum = driver.findElement(By.id("addCandidate_contactNo"));
		soft.assertTrue(contactnum.isEnabled(), "email Field is Not Enabled");
		contactnum.clear();
		contactnum.sendKeys("9994994231");
		
		//JobRole
		WebElement jobRole = driver.findElement(By.id("addCandidate_vacancy"));
		Select s = new Select(jobRole);
		s.selectByIndex(2);
		
		
		//KeyWoerds
		WebElement keywords = driver.findElement(By.id("addCandidate_keyWords"));
		soft.assertTrue(keywords.isEnabled(), "KeyWord Field is Not Enabled");
		keywords.clear();
		keywords.sendKeys("Automation Tester");
		
		//comments
		WebElement comment = driver.findElement(By.id("addCandidate_comment"));
		soft.assertTrue(comment.isEnabled(), "comment Field is Not Enabled");
		comment.clear();
		comment.sendKeys("Quality Assurance");
		
		//checkBox
		WebElement checkbox = driver.findElement(By.id("addCandidate_consentToKeepData"));
		soft.assertTrue(checkbox.isEnabled(), "consentToKeepData checkbox Field is Not Enabled");
		checkbox.click();
		
		//Date Of Application
		WebElement DOA = driver.findElement(By.id("addCandidate_appliedDate"));
		soft.assertTrue(DOA.isEnabled(), "comment Field is Not Enabled");
		DOA.clear();
		DOA.sendKeys("2021-05-12");
		   
		
		
		//Save
		WebElement saveBtn = driver.findElement(By.id("btnSave"));	
		soft.assertTrue(saveBtn.isEnabled(), "saveButton Field is Not Enabled");
		saveBtn.click();
		
		//AssertAll
		soft.assertAll();

	}
	
//	@AfterClass
//	public void tearDown() throws Exception {
//		driver.quit();
//	}
//	
	
	

}
