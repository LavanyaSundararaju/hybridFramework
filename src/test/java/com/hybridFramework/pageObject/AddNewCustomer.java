package com.hybridFramework.pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class AddNewCustomer {
	
	WebDriver driver;
	
	public AddNewCustomer(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//a[.=\"New Customer\"]")
	private WebElement LnkNewCustomer;
	
	@FindBy(xpath="//input[@name='name' and @type='text']")
	private WebElement CustomerName;
	
	@FindBy(xpath="//input[@value='m' and @type='radio']")
	private WebElement RadiobuttonMale;
	
	@FindBy(xpath="//input[@value='f' and @type='radio']")
	private WebElement RadiobuttonFemale;
	
	@FindBy(xpath="//input[@id='dob' and @type='date']")
	private WebElement DOB;
	
	@FindBy(how=How.XPATH, using="//textarea[@name='addr']")
	private WebElement Address;
	
	@FindBy(xpath="//input[@name='city']")
	private WebElement City;
	
	@FindBy(xpath="//input[@name='state']")
	private WebElement State;
	
	@FindBy(xpath="//input[@name='pinno']")
	private WebElement Pin;
	
	@FindBy(xpath="//input[@name='telephoneno']")
	private WebElement MobileNo;
	
	@FindBy(xpath="//input[@name='emailid']")
	private WebElement EmailID;
	
	@FindBy(xpath="//input[@name='password']")
	private WebElement Password;
	
	@FindBy(xpath="//input[@value='Submit']")
	private WebElement Submit;
	
	@FindBy(xpath="//input[@value='Reset']")
	private WebElement Reset;
	
	@FindBy(xpath="//p[.='Customer Registered Successfully!']")
	private WebElement SuccessMessage;
	
	public void clickNewCustomer()
	{
		LnkNewCustomer.click();
	}
		
	public void setCustomerName(String name)
	{
		CustomerName.sendKeys(name);
	}
	
	public void setGenderMale()
	{
		RadiobuttonMale.click();
	}
	
	public void setGenderFM()
	{
		RadiobuttonFemale.click();
	}
	
	
	public void setDOB(String dd, String mm, String yyyy)
	{
		DOB.sendKeys(dd);
		DOB.sendKeys(mm);
		DOB.sendKeys(yyyy);
	}
	
	public void setAddress(String address)
	{
		Address.sendKeys(address);
	}
	
	public void setCity(String city)
	{
		City.sendKeys(city);
	}
	
	public void setState(String state)
	{
		State.sendKeys(state);
	}
	
	public void setPin(String pin)
	{
		Pin.sendKeys(pin);
	}
	
	public void setMobileNo(String mobNo)
	{
		MobileNo.sendKeys(mobNo);
	}
	
	public void setEmailID(String email)
	{
		EmailID.sendKeys(email);
	}
	
	public void setPassword(String pwd)
	{
		Password.sendKeys(pwd);
	}
	
	public void clickSubmit()
	{
		Submit.click();
	}
	
	public void clickReset()
	{
		Reset.click();
	}
	
	public WebElement getSuccessMessage()
	{
		return SuccessMessage;
	}
	
	
	

}
