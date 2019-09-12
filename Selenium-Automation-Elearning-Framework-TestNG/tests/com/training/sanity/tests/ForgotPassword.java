package com.training.sanity.tests;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Wait;
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
import com.trianing.waits.WaitTypes;

public class ForgotPassword {
	private WebDriver driver;
	private String baseUrl;
	private LoginPOM loginPOM;
	private LoginRetailPOM loginRetailPOM;
	private static Properties properties;
	WaitTypes MyWait;
	private ScreenShot screenShot;
	String Actual_Title ;
	String Current_Title;
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
		MyWait = new WaitTypes(driver);
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
	
	
	 // Test Cases to Generate Forgot Password
  @Test
  public void ForgotPassword() throws InterruptedException {
	  logger=extent.startTest("Extent_Report");
	 
	  //To Verify Credentials are not proper and Clicked on Forgot Password for password Recovery
	  loginPOM.Loginclick();
	  logger.log(LogStatus.PASS, "WebPage is opened and Clicked on Login");
	  loginPOM.Email("manzoor_retail@gmail.com");
	  logger.log(LogStatus.PASS, "Entered Email Address");
	  loginPOM.Password("Password1");
	  logger.log(LogStatus.PASS, "Entered Password");
	  loginRetailPOM.Loginbutton(); 
	  logger.log(LogStatus.PASS, "Clicked on Login button");
	  MyWait.presenceElementLocated("input-email", 30);
	  screenShot.captureScreenShot("LoginPage");
	  
	  //To Verify Credentials failed and current page is Forgot password
	  loginPOM.ForgotPassword();
	  logger.log(LogStatus.PASS, "Clicked on Forgot Password Link");
	  Actual_Title = "Forgot Your Password?";
	  Current_Title=driver.getTitle();
	  MyWait.presenceElementLocated("input-email", 30);
	  if (Actual_Title.equals(Current_Title))
	  {
		  logger.log(LogStatus.PASS, "Verified the Page Title");
		  Assert.assertEquals(Actual_Title, Current_Title);
		  System.out.println(Current_Title+"\t"+"page launch is Successful");
		  
	  }

	  else
	  {
		  logger.log(LogStatus.PASS, "Verification of the Page Title is failed");
		  Assert.fail("Expected Forgot Your Password? page launch is not Successful");
		 // System.out.println("Expected Forgot Your Password? page launch is not Successful");
	  }
	  screenShot.captureScreenShot("ForgorPasswordPage");
	  
	  //Send password reset link to email after clicking on forgot password
	  loginPOM.InputEmailid("manzoor_retail@gmail.com");
	  logger.log(LogStatus.PASS, "Entered Email for Password Recovery");
	  loginPOM.Countinue_FP();
	  logger.log(LogStatus.PASS, "Click on Countinue button");
	  Actual_Title = "Account Login";
	  Current_Title=driver.getTitle();
	  MyWait.presenceElementLocated("input-email", 30);
	  if (Actual_Title.equals(Current_Title))
	  {
		  Assert.assertEquals(Actual_Title, Current_Title);
		  System.out.println("Account Login page launch is Successful");
		  System.out.println("Page Title is " +Current_Title);
		  logger.log(LogStatus.PASS, "Account Login page launch is Successful");
		   }

	  else
	  {
		  Assert.fail("Expected Login_Retail page launch is not Successful");
		  logger.log(LogStatus.PASS, "Account Login page launch is Failed");
	  }
	  screenShot.captureScreenShot("ForgotPasswordSentConfirmationPage");
	  extent.endTest(logger);
	    extent.flush();
  }
}
