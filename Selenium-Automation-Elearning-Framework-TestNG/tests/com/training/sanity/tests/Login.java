package com.training.sanity.tests;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import com.training.generics.ScreenShot;
import com.training.pom.LoginPOM;
import com.training.pom.LoginRetailPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class Login {
	
	private WebDriver driver;
	private String baseUrl;
	private LoginPOM loginPOM;
	private LoginRetailPOM loginRetailPOM;
	private static Properties properties;
	private ScreenShot screenShot;
	ExtentReports extent;
	ExtentTest logger;
	
	@BeforeClass
	public static void setUpBeforeClass() throws IOException {
		properties = new Properties();
		FileInputStream inStream = new FileInputStream("./resources/others.properties");
		properties.load(inStream);
	}

	@BeforeMethod
	public void setUp() throws Exception {
		
		driver = DriverFactory.getDriver(DriverNames.CHROME);
		//driver=DriverFactory.getDriver(DriverNames.FIREFOX);
		loginPOM = new LoginPOM(driver); 
		loginRetailPOM= new LoginRetailPOM(driver);
		baseUrl = properties.getProperty("baseURL");
		screenShot = new ScreenShot(driver); 
		// open the browser 
		driver.get(baseUrl);
		extent = new ExtentReports(System.getProperty("user.dir")+"/test-output/log4j.html",true);
		extent.loadConfig(new File(System.getProperty("user.dir")+"extent-config.xml"));
		
	}
	
	@AfterMethod
	public void tearDown() throws Exception {
		Thread.sleep(1000);
		driver.quit();
	}
	
	
// Test Case to Login into Retail WebPage	
  @Test
  public void Login_Retail() throws InterruptedException 
  {
	   logger=extent.startTest("Login_Report");
	  //To Login into Retail URL
	  Thread.sleep(3000);
	  loginPOM.Loginclick();
	  logger.log(LogStatus.PASS, "Clicked Login Icon");
	  
	  loginRetailPOM.emailaddress("manzoor_retail@gmail.com");
	  logger.log(LogStatus.PASS, "Entered Email Address");
	  
	  loginRetailPOM.Password("manzoor1");
	 logger.log(LogStatus.PASS, "Entered Email Password");
	  
	  loginRetailPOM.Loginbutton();
	  logger.log(LogStatus.PASS, "clicked on log in");
	  
	  Assert.assertTrue(true,"My Account");
	System.out.println("Title is :: "+driver.getTitle());
	 
	  screenShot.captureScreenShot("Loggedin_Success");
	  extent.endTest(logger);
	    extent.flush();
	  
	  
	  
	  
  }
}
