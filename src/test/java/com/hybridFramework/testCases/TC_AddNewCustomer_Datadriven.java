package com.hybridFramework.testCases;

import java.io.IOException;

import org.testng.Reporter;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.hybridFramework.pageObject.AddNewCustomer;
import com.hybridFramework.pageObject.LoginPage;
import com.hybridFramework.utilities.ExcelUtils;


public class TC_AddNewCustomer_Datadriven extends BaseClass{
	


@Test(dataProvider="NewCustomer")
public void addCustomer(String customerName, String gender,String DD,String MM, String YYYY, String address, String city, String state, String pin,String mobileNumber, String email, String pwd) throws InterruptedException
{
	LoginPage lp=new LoginPage(driver);
	AddNewCustomer adc=new AddNewCustomer(driver);
	Reporter.log(username, true);
	Reporter.log(password, true);
	lp.setUserName(username);
	lp.setPassword(password);
	lp.clickLogin();
	
	adc.clickNewCustomer();
	Thread.sleep(1000);
	Reporter.log(customerName, true);
	Reporter.log(gender, true);
	Reporter.log(address, true);
	adc.setCustomerName(customerName); 	 
	if(gender.equals("male"))
	{
	adc.setGenderMale();
	}
	else
	{
		adc.setGenderFM();
	}
	adc.setDOB(DD, MM, String.valueOf(YYYY));
	adc.setAddress(address);
	adc.setCity(city);
	adc.setState(state);
	adc.setPin(String.valueOf(pin));
	adc.setMobileNo(mobileNumber);
	adc.setEmailID(email);
	adc.setPassword(pwd);
	adc.clickSubmit();
	
}

	




@DataProvider(name="NewCustomer")
public static String[][] customerDetails() throws IOException
{
	String excelPath=System.getProperty("user.dir")+"/src/test/java/com/hybridFramework/testData/LoginTestData.xlsx";
	int rowNum=ExcelUtils.rowCount(excelPath, "Sheet2");
	int cellCount=ExcelUtils.cellCount(excelPath, "Sheet2", rowNum);
	
	String[][] custDetails=new String[rowNum][cellCount];
	
	for(int i=1;i<=rowNum;i++)
	{
		for(int j=0;j<cellCount;j++)
		{
			custDetails[i-1][j]=ExcelUtils.getCellData(excelPath, "Sheet2", i, j);
		}
	}
	
	
	return custDetails;
}
}