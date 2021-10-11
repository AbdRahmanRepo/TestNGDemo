package com.AllPages.com;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class RecruitmentTest {
	SoftAssert soft = new SoftAssert(); 
	public static WebDriver driver;
	
	

	@Parameters({"browserName", "url" })
	@BeforeTest
	public void setUp(@Optional("Chrome") String browserName, String Url) throws Exception {
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
	@Test(priority = 1, groups = "login")
	private void TC_004() {

		driver.findElement(By.id("txtUsername")).sendKeys("Admin");
		driver.findElement(By.id("txtPassword")).sendKeys("admin123");
		driver.findElement(By.id("btnLogin")).click();
		System.out.println(driver.getCurrentUrl());
		String actURL = driver.getCurrentUrl();
		String expURL = "https://opensource-demo.orangehrmlive.com/index.php/dashboard";
		Assert.assertEquals(actURL, expURL);

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
		//		WebElement saveBtn = driver.findElement(By.id("btnSave"));	
		//		soft.assertTrue(saveBtn.isEnabled(), "saveButton Field is Not Enabled");
		//		saveBtn.click();

		//AssertAll
		soft.assertAll();

	}
	
	@AfterClass
	public void tearDown(Long sleepTime) throws Exception {
		Thread.sleep(sleepTime);
		driver.quit();
	}

}
