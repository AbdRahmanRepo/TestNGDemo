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
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class OrangeHRM_Login {
	SoftAssert soft = new SoftAssert(); 
	public static WebDriver driver;
	
	@BeforeClass
	public void setUp() throws Exception {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
//		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
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
	
	
	
	@AfterClass
	public void tearDown() throws Exception {
		driver.quit();
	}
	

}
