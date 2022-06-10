package com.hybridFramework.testCases;

import java.io.IOException;

import org.openqa.selenium.NoAlertPresentException;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.hybridFramework.pageObject.LoginPage;
import com.hybridFramework.utilities.ExcelUtils;

public class TC_LoginTest_002 extends BaseClass{
	
	@Test(dataProvider="LoginData")
	public static void LoginTest_002(String username, String password) throws IOException
	{
		LoginPage lp=new LoginPage(driver);
		lp.setUserName(username);
		lp.setPassword(password);
		lp.clickLogin();
		
		if(isAlertPresent()==true)
		{
			
			driver.switchTo().alert().accept();
			driver.switchTo().defaultContent();
			logger.info("User name is "+username);
			logger.info("pwd is "+password);
			logger.info("Login Failed");
			takeScreenShotOnFailure(driver,"LoginTest_002");
			Assert.assertTrue(false);
			
		}
		
		else
		{
			Assert.assertTrue(true);
			lp.clickLogout();
			logger.info("User name is "+username);
			logger.info("pwd is "+password);
			logger.info("Login passed");
			driver.switchTo().alert().accept();
			driver.switchTo().defaultContent();
			
		}
		
	}
	
	public static boolean isAlertPresent()
	{
		try
		{
			driver.switchTo().alert();
			return true;
		}
		catch(NoAlertPresentException e)
		{
			return false;
		}
		
		
	}
	
	@DataProvider(name="LoginData")
	public static Object[][] getData() throws IOException
	{
		String excelPath=System.getProperty("user.dir")+"/src/test/java/com/hybridFramework/testData/LoginTestData.xlsx";
		int rowNum=ExcelUtils.rowCount(excelPath, "Sheet1");
		int cellcount=ExcelUtils.cellCount(excelPath, "Sheet1", rowNum);
		
		Object loginData[][]=new String[rowNum][cellcount];
		
		for(int i=1;i<=rowNum;i++)
		{
			for(int j=0;j<cellcount;j++)
			{
				loginData[i-1][j]=ExcelUtils.getCellData(excelPath, "Sheet1", i, j);
				//Reporter.log(loginData[i-1][j], true);
				
			}
		}
		
		
		return loginData;
	}

}
