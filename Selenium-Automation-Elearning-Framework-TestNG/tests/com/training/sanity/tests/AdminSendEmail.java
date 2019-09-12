package com.training.sanity.tests;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.poi.util.SystemOutLogger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import com.training.generics.ScreenShot;
import com.training.pom.LoginPOM;
import com.training.pom.LoginRetailPOM;
import com.training.pom.*;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;
import com.trianing.waits.WaitTypes;

public class AdminSendEmail {

	
	private static final boolean True = false;
	private static final boolean False = false;
	private WebDriver driver;
	private String baseUrl;
	private LoginPOM loginPOM;
	private LoginRetailPOM loginRetailPOM;
	private AdminSendEmailPOM AdminSendEmailPOM;
	private static Properties properties;
	WaitTypes MyWait;
	private ScreenShot screenShot;
	String Actual_Title ;
	String Current_Title;
	ExtentReports extent;
	ExtentTest logger;

	@BeforeSuite(groups= {"smoke"})
	public static void setUpBeforeClass() throws IOException {
		properties = new Properties();
		FileInputStream inStream = new FileInputStream("./resources/others.properties");
		properties.load(inStream);
	}

	@BeforeTest(groups= {"smoke"})
	public void setUp() throws Exception {
		
		driver = DriverFactory.getDriver(DriverNames.CHROME);
		//driver=DriverFactory.getDriver(DriverNames.FIREFOX);
		loginPOM = new LoginPOM(driver); 
		loginRetailPOM= new LoginRetailPOM(driver);
		AdminSendEmailPOM = new AdminSendEmailPOM(driver);
		baseUrl = properties.getProperty("baseURL");
		MyWait = new WaitTypes(driver);
		screenShot = new ScreenShot(driver); 
		// open the browser 
		driver.get(baseUrl);
		extent = new ExtentReports(System.getProperty("user.dir")+"/test-output/log4j.html",true);
		extent.loadConfig(new File(System.getProperty("user.dir")+"extent-config.xml"));
		
	}
	
	@AfterTest(groups= {"smoke"})
	public void tearDown() throws Exception {
		Thread.sleep(1000);
		driver.quit();
	}
		
// Test Case to Verify if Login to Retail as admin is Sucessfull	
  @Test(groups= {"smoke"},priority=1)
  public void Login_Retail() throws InterruptedException {
	  logger=extent.startTest("Login_Page");
	  //String WebElement = "All Customers";
	  //Login to Retail as admin
	  screenShot.captureScreenShot("Retail_Login_Page");
	  logger.log(LogStatus.PASS, "Goto Retail Admin page and login as Admin");
	  
	  AdminSendEmailPOM.Username("admin");
	  logger.log(LogStatus.PASS, "Enter Username is Passed");
	  
	  AdminSendEmailPOM.Password("admin@123");
	  logger.log(LogStatus.PASS, "Enter Password is passed");
	  
	  AdminSendEmailPOM.Login();
	 
	  Assert.assertTrue(true,"Dashboard");
	  System.out.println("Login_Retail"+"::"+driver.getTitle());
	 
	  
	  logger.log(LogStatus.PASS, "Retail page Login is Successful");
	  screenShot.captureScreenShot("Retail_Login_Successful");
	  extent.endTest(logger);
	    extent.flush();
	  
  }
  
  //Test Case to Verify if Markting and Mail Icon is clicked and Email Sent to all Customer 
  @Test (priority=2,dependsOnMethods="Login_Retail",groups= {"smoke"})
  public void Marketing() throws InterruptedException
  {
	  logger=extent.startTest("Marketing");
	  
	  AdminSendEmailPOM.Marketing();
	  logger.log(LogStatus.PASS, "Select Marketing ICON is successful");
	  
	  Thread.sleep(3000);
	  AdminSendEmailPOM.Mail();
	  System.out.println("Marketing"+driver.getTitle());
	  Assert.assertTrue(true, "Mail");
	  logger.log(LogStatus.PASS, "Mail under Marketing is selected");
	  
	  AdminSendEmailPOM.To();
	  logger.log(LogStatus.PASS, "All Customer list is selected in To text box");
	  
	  AdminSendEmailPOM.Subject("Christmas Wish");
	  logger.log(LogStatus.PASS, "Subject is typed as Christmas Wishes");
	  
	  MyWait.presenceElementLocated("input-subject-1", 30);
	  //AdminSendEmailPOM.Scroll();
	  AdminSendEmailPOM.Message("Christmas Wish");
	  logger.log(LogStatus.PASS, "Message is typed as Christmas Wish");
	  
	  AdminSendEmailPOM.Send_Mail();
	  logger.log(LogStatus.PASS, "Clicked send email successful");
	  
	  screenShot.captureScreenShot("Mail_To_All_Customer");
	  extent.endTest(logger);
	    extent.flush();
  }
  
  //Test Case to check if all Mail is sent to Products team
  @Test(priority=3,dependsOnMethods="Marketing",groups= {"smoke"})
  public void Products() throws InterruptedException {
	  logger=extent.startTest("Products");
	  MyWait.presenceElementLocated(By.xpath("//*[@class=\"fa fa-envelope\"]"), 50);
	  
	  AdminSendEmailPOM.To_Prd();
	  logger.log(LogStatus.PASS, "Selected the Products in To list of Mail");
	  
	 MyWait.presenceElementLocated(By.xpath("//*[@class=\"fa fa-envelope\"]"), 50);
	// Thread.sleep(5000);
	 System.out.println("Products"+driver.getTitle());
	 Assert.assertTrue(true, "Mail");
	  AdminSendEmailPOM.Send_Mail_prd();
	  logger.log(LogStatus.PASS, "Clicked send email successful");
	  
	  screenShot.captureScreenShot("Mail_To_Products");
	  extent.endTest(logger);
	    extent.flush();
	  
  }
  
  //TestCase to verify Christmas wishes is sent to all Affliates group
  @Test(priority=4,dependsOnMethods="Products",groups= {"smoke"})
  public void All_Affliates() throws InterruptedException {
	  logger=extent.startTest("All Affliate");
	  MyWait.presenceElementLocated(By.xpath("//*[@class=\"fa fa-envelope\"]"), 50);
	  
	  Thread.sleep(5000);
	  AdminSendEmailPOM.To_All_Affliate();
	  System.out.println("To_All_Affliate"+driver.getTitle());
	  Assert.assertTrue(true, "Mail");
	  logger.log(LogStatus.PASS, "Selected the All Affliates in To list of Mail");
	  
	  AdminSendEmailPOM.Subject("Christmas Wish to all");
	  logger.log(LogStatus.PASS, "Typed Christmas Wishes to All in Subject");
	  
	  AdminSendEmailPOM.Message("Christmas Wish to all");
	  logger.log(LogStatus.PASS, "Typed Christmas Wishes to All in in Message");
	  
	  AdminSendEmailPOM.Send_Mail_prd();
	  logger.log(LogStatus.PASS, "Clicked send email successful");
	  
	  screenShot.captureScreenShot("Mail_To_All_Affliates");
	  extent.endTest(logger);
	    extent.flush();

	  
  }
	  
	  
	  
	  /*AdminSendEmailPOM.Product_Icon();
	  AdminSendEmailPOM.Product();*/
	  
	  
	  }

