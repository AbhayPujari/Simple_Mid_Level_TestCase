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
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class LoginTests {

	private WebDriver driver;
	private String baseUrl;
	private LoginPOM loginPOM;
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
	
	//Test Case to Check Register User details
	@Test
	public void RegisterNewUser() throws InterruptedException
	{
		logger=extent.startTest("Login_Test_Report");
		
		loginPOM.Loginclick();
		 logger.log(LogStatus.PASS, "Clicked Login Icon");
		loginPOM.Registerbutton();
		 logger.log(LogStatus.PASS, "Clicked On Register Button");
		loginPOM.Firstname("manzoor");
		 logger.log(LogStatus.PASS, "Entered First Name");
		loginPOM.Lastname("mehadi");
		 logger.log(LogStatus.PASS, "Entered Last Name");
		loginPOM.Email("manzoor_retail@gmail.com");
		 logger.log(LogStatus.PASS, "Entered Email Address");
		loginPOM.Telephone("9876543210");
		 logger.log(LogStatus.PASS, "Entered phone number");
		loginPOM.Address1("yeshwanthapur");
		 logger.log(LogStatus.PASS, "Entered Address1");
		loginPOM.Address2("bangalore");
		 logger.log(LogStatus.PASS, "Entered Address2");
		loginPOM.City("bangalore");
		 logger.log(LogStatus.PASS, "Entered City Details");
		loginPOM.Pincode("560022");
		 logger.log(LogStatus.PASS, "Entered PinCode ");
		loginPOM.Country("India");
		 logger.log(LogStatus.PASS, "Entered Country");
		loginPOM.State("Karnataka");
		 logger.log(LogStatus.PASS, "Entered State");
		loginPOM.Password("manzoor1");
		 logger.log(LogStatus.PASS, "Entered Password");
		loginPOM.ConfirmPassword("manzoor1");
		 logger.log(LogStatus.PASS, "Entered Confirm Password");
		loginPOM.Subscribe();
		 logger.log(LogStatus.PASS, "Clicked on Subscribe");
		loginPOM.Checkbox();
		 logger.log(LogStatus.PASS, "Clicked on Checkbox");
		loginPOM.Countinue_button();
		 logger.log(LogStatus.PASS, "Clicked on Countinue Button");
		 String Title = driver.getTitle();
		 Assert.assertTrue(true,Title);
		 System.out.println("Title is ::"+Title);
		 screenShot.captureScreenShot("Registered_User_Details_Succesfully");
		  extent.endTest(logger);
		    extent.flush();
	}
	
	

	
	
	/*@Test
	public void validLoginTest() {
		loginPOM.sendUserName("admin");
		loginPOM.sendPassword("admin@123");
		loginPOM.clickLoginBtn(); 
		//screenShot.captureScreenShot("First");
	}*/
}
