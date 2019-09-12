package com.training.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginRetailPOM extends LoginPOM {
	
	
	public LoginRetailPOM(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	@FindBy(id="input-email")
	public WebElement Emailid;
	
	@FindBy(id="input-password")
	public WebElement Password;
	
	public void emailaddress(String Emailid)
	{
	  this.Emailid.clear();
	  this.Emailid.sendKeys(Emailid);
	}
	
	public void Password(String Password)
	{
	  this.Password.clear();
	  this.Password.sendKeys(Password);
	}
	
	public void Loginbutton()
	{
		driver.findElement(By.xpath("//*[@class='btn btn-primary' and @value='Login']")).click();
	}
	
			

}
