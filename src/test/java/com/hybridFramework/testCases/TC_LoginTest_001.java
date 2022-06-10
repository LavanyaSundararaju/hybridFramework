package com.hybridFramework.testCases;
import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.hybridFramework.pageObject.LoginPage;


public class TC_LoginTest_001 extends BaseClass {
	
	
	@Test
	public void loginTest() throws IOException
	{
		driver.get(baseURL);
		
		logger.info("Launched the URL");
		LoginPage lp=new LoginPage(driver);
		
		lp.setUserName(username);
		logger.info("Entered Username");
		
		lp.setPassword(password);
		logger.info("Entered passwod");
		
		lp.clickLogin();
		logger.info("Clicked on Login button");
		
		if(driver.getTitle().equals("Guru99 Bank Manager HomePage"))
		{
			Assert.assertTrue(true);
			logger.info("Passed");
		}
		else
		{
			takeScreenShotOnFailure(driver,"loginTest");
			Assert.assertTrue(false);
			logger.info("Failed");
		}
	}

}
