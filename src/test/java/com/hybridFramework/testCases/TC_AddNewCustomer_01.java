package com.hybridFramework.testCases;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.hybridFramework.pageObject.AddNewCustomer;
import com.hybridFramework.pageObject.LoginPage;
import org.apache.commons.lang3.RandomStringUtils;

public class TC_AddNewCustomer_01 extends BaseClass{

	
	
		
	@Test
	public void addNewCustomer() throws InterruptedException
	{
		LoginPage lp=new LoginPage(driver);
		AddNewCustomer adc=new AddNewCustomer(driver);
		Reporter.log(username, true);
		Reporter.log(password, true);
		lp.setUserName(username);
		logger.info("Username is provided");
		lp.setPassword(password);
		logger.info("Password is provided");
		lp.clickLogin();
		logger.info("Clicked on Login");
		
		adc.clickNewCustomer();
		Thread.sleep(1000);
		logger.info("Providing customer details...");
		adc.setCustomerName("abc");
		adc.setGenderMale();
		adc.setDOB("01", "02", "1990");
		Thread.sleep(1000);
		adc.setAddress("HSR Layout");
		adc.setCity("Bangalore");
		adc.setState("Karnataka");
		adc.setPin("560102");
		adc.setMobileNo("9876543210");
		String email=randomString()+"@gmail.com";
		Reporter.log(email, true);
		adc.setEmailID(email);
		adc.setPassword("1234");
		adc.clickSubmit();
		logger.info("Submitted Customer details");
		Thread.sleep(3000);
		//adc.getSuccessMessage().isDisplayed()
		if(driver.getPageSource().contains("Customer Registered Successfully!!!"))
		{
			Assert.assertTrue(true);
		}
		else
		{
			Assert.assertTrue(false);
		}
	}
	
	public String randomString()
	{
		String random=RandomStringUtils.randomAlphabetic(5);
		return random;
	}
}
