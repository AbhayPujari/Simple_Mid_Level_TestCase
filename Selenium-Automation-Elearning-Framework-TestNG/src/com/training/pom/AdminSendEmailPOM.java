package com.training.pom;

import java.awt.Desktop.Action;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class AdminSendEmailPOM {
	
public WebDriver driver; 
	
	public AdminSendEmailPOM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(id="input-username")
	private WebElement Username;
	
	@FindBy(id="input-password")
	private WebElement Password;
	
	@FindBy(xpath="//i[@class='fa fa-key']")
	private WebElement Login;
	
	@FindBy(id="input-to")
	private WebElement To;
	
	@FindBy(id="input-subject-1")
	private WebElement Subject;
	
	@FindBy(xpath="//*[@class=\"note-editable panel-body\"]")
     private WebElement Message;
	
	@FindBy(xpath="//*[@class=\"fa fa-envelope\"]")
	private WebElement Send_Mail;
	
/*	@FindBy(xpath="//i[@class=\"fa fa-tags fw\"]")
	private WebElement Product_Icon;*/
	
	public void Username(String Username)
	{
		this.Username.clear();
		this.Username.sendKeys(Username);
	}
	
	public void Password(String Password)
	{
		this.Password.clear();
		this.Password.sendKeys(Password);
	}
	
	public void Login()
	{
		Login.click();
		
	}
	
	public void Marketing()
	{
		Actions Marketing_MO = new Actions(driver);
		WebElement Link = driver.findElement(By.xpath("//i[@class='fa fa-share-alt fw']"));
		Marketing_MO.moveToElement(Link).click().build().perform();
	}
	
	public void Mail()
	{
		Actions Mail_MO = new Actions(driver);
		//Mail_MO.moveToElement((WebElement) By.xpath("//*[@id=\\\"menu-marketing\\\"]/ul/li[4]/a")).click().build().perform();
	/*WebElement Link = driver.findElement(By.xpath("//*[@id=\\\"menu-marketing\\\"]/ul/li[4]/a"));
	Mail_MO.moveToElement(Link).click().build().perform();*/
		Mail_MO.sendKeys(Keys.TAB,Keys.TAB,Keys.TAB,Keys.TAB,Keys.ENTER).perform();
		
	}
	
	public void To()
	{
		
		Select sel_To = new Select(To);
		sel_To.selectByVisibleText("All Customers");
		 
	}
		 
	
	public void Subject(String Subject)
	{
		this.Subject.clear();
		this.Subject.sendKeys(Subject);
	}
	public void Scroll()
	{
		JavascriptExecutor JS = (JavascriptExecutor)driver;
		JS.executeScript("window.scrollTo(0,400)");
		
	}
	
	public void Message(String Message)
	{
		this.Message.clear();
		this.Message.sendKeys(Message);
	}

	public void Send_Mail()
	{
		Send_Mail.click();
	}
	
	public void To_Prd()
	{
		
		Select sel_prd_To = new Select(To);
		sel_prd_To.selectByVisibleText("Products");
			 
	}
	
	public void Send_Mail_prd()
	{
		Send_Mail.click();
	}
	
	public void To_All_Affliate()
	{
		
		Select sel_Affli_To = new Select(To);
		sel_Affli_To.selectByVisibleText("All Affiliates");
		
	}

	
	
	/*public void Product_Icon() {
		
		Actions Product_Icon_MO = new Actions(driver);
		WebElement Link = driver.findElement(By.xpath("//i[@class=\"fa fa-tags fw\"]"));
		Product_Icon_MO.moveToElement(Link).click().build().perform();
	}
	
	
	public void Product()
	{
		Actions Product_MO = new Actions(driver);
		//Mail_MO.moveToElement((WebElement) By.xpath("//*[@id=\\\"menu-marketing\\\"]/ul/li[4]/a")).click().build().perform();
	WebElement Link = driver.findElement(By.xpath("//*[@id=\\\"menu-marketing\\\"]/ul/li[4]/a"));
	Mail_MO.moveToElement(Link).click().build().perform();
		Product_MO.sendKeys(Keys.TAB,Keys.TAB,Keys.ENTER).perform();
		
	}*/
		
	}
	
	
	
	
	


