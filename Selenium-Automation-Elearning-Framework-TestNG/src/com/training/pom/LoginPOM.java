package com.training.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class LoginPOM {
	public WebDriver driver; 
	
	public LoginPOM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//i[@class='fa fa-user-o']")
	private WebElement Loginclick;
	
	@FindBy(xpath="//a[@class='btn btn-primary']")
	private WebElement Regbutton;
	
	@FindBy(id="input-firstname")
	private WebElement Firstname;
	
	@FindBy(id="input-lastname")
	private WebElement Lastname;
	
	
	
	@FindBy(id="input-email")
	private WebElement Email;
	
	@FindBy(id="input-telephone")
	private WebElement Telephone;
	
	@FindBy(id="input-address-1")
	private WebElement Address1;
	
	@FindBy(id="input-address-2")
	private WebElement Address2;
	
	@FindBy(id="input-city")
	private WebElement City;
	
	@FindBy(id="input-postcode")
	private WebElement Pincode;
	
	@FindBy(id="input-password")
	private WebElement Password;
	
	@FindBy(id="input-confirm")
	private WebElement ConfirmPassword;
	
	@FindBy(name="agree")
	private WebElement Sel_Checkbox;
	
	@FindBy(xpath="//*[@class='btn btn-primary']")
	private WebElement Countinue;
	
	@FindBy(xpath="//*[contains(text(),'Forgotten Password')]")
	private WebElement ForgotPassword;
	
	@FindBy(id="input-email")
	private WebElement InputEmailid;
	
	@FindBy(xpath="//*[@class='btn btn-primary' and @value='Continue']")
	private WebElement Countinue_FP;
	
	
	
	
	//@FindBy(id="input-country")
	//private WebElement Country;
    //Select sel = new Select(Country);
    
    //@FindBy(id="input-zone")
  //  private WebElement State;
    
	
	public void Loginclick() {
		this.Loginclick.click();
	//	Actions Marketing_MO = new Actions(driver);
		//Marketing_MO.moveToElement(Loginclick).click().build().perform();
	}
	
	public void Registerbutton() {
		this.Regbutton.click();
	}
	
	public void Firstname(String Firstname) {
		this.Firstname.clear();
		this.Firstname.sendKeys(Firstname);
	}
	
	public void Lastname(String Lastname) {
		this.Lastname.clear();
		this.Lastname.sendKeys(Lastname);
		
	}
	
	public void Email(String Email)
	{
		this.Email.clear();
		this.Email.sendKeys(Email);
	}
	
	public void Telephone(String Telephone)
	{
		this.Telephone.clear();
		this.Telephone.sendKeys(Telephone);
	}
	
	public void Address1(String Address1)
	{
		this.Address1.clear();
		this.Address1.sendKeys(Address1);
	}
	
	public void Address2(String Address2)
	{
		this.Address2.clear();
		this.Address2.sendKeys(Address2);
	}
	
	public void City(String City)
	{
		this.City.clear();
		this.City.sendKeys(City);;
	}
	
	public void Pincode(String Pincode)
	{
		this.Pincode.clear();
		this.Pincode.sendKeys(Pincode);
		
	}
	
	public void Country(String Country) throws InterruptedException
	{
		Thread.sleep(3000);
		//driver.findElement(By.id("input-country")).clear();
		
		//@FindBy(id="input-country")
		//private WebElement Country;
	    //Select sel = new Select(Country);
	    WebElement Ele = driver.findElement(By.id("input-country"));
	    Select sel_Country = new Select(Ele);
		sel_Country.selectByVisibleText(Country);
      
	}
	
    public void State(String State)
	{
	 WebElement Ele1 = driver.findElement(By.id("input-zone"));
	    Select sel_State = new Select(Ele1);
       sel_State.selectByVisibleText(State);
      
	}
    
    public void Password(String Password)
    {
    	this.Password.clear();
    	this.Password.sendKeys(Password);
    }
    
    public void ConfirmPassword(String ConfirmPassword)
    {
    	this.ConfirmPassword.clear();
    	this.ConfirmPassword.sendKeys(ConfirmPassword);
    }
    
    public void Subscribe()
    {
    	if (driver.findElement(By.xpath("//*[@name='newsletter' and @value='0']")).isSelected() != true)
    	{
    		driver.findElement(By.xpath("//*[@name='newsletter' and @value='0']")).click();
    	}	
    	
    }
    
    public void Checkbox()
    {
    	this.Sel_Checkbox.click();
    }
    
    public void Countinue_button()
    {
    	Countinue.click();
    }
    
    public void ForgotPassword()
    {
    	this.ForgotPassword.click();
    }
    
    public void InputEmailid(String InputEmailid)
    {
    	this.InputEmailid.clear();
    	this.InputEmailid.sendKeys(InputEmailid);
    }
    
    public void Countinue_FP()
    {
    	this.Countinue_FP.click();
    }
    
    @FindBy(id="login")
	private WebElement userName; 
	
	@FindBy(id="password")
	private WebElement password;
	
	@FindBy(id="form-login_submitAuth")
	private WebElement loginBtn; 
	
	public void sendUserName(String userName) {
		this.userName.clear();
		this.userName.sendKeys(userName);
	}
	
	public void sendPassword(String password) {
		this.password.clear(); 
		this.password.sendKeys(password); 
	}
	
	public void clickLoginBtn() {
		this.loginBtn.click(); 
	}

	
	
}
