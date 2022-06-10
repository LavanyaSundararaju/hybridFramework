package com.hybridFramework.testCases;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import com.hybridFramework.utilities.ReadConfig;

public class BaseClass {
	
	ReadConfig rc=new ReadConfig();
	
	public String baseURL=rc.getURL();
	public String username=rc.getUsername();
	public String password=rc.getPassword();
	public static WebDriver driver;
	public static Logger logger;
	
	@Parameters("browser")
	@BeforeClass
	public void setUp(String br) {
		
		logger=Logger.getLogger("HybridFramework");
		PropertyConfigurator.configure("log4j.properties");
		
		if(br.equals("chrome"))
		{
		System.setProperty("webdriver.chrome.driver", rc.getChromePath());
		driver=new ChromeDriver();
		}
		else if(br.equals("firefox"))
		{
			System.setProperty("webdriver.gecko.driver", rc.getFirefoxPath());
			driver=new FirefoxDriver();
		}
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		driver.get(baseURL);
				
	}
	
	@AfterClass
	public void tearDown()
	{
		driver.quit();
	}
	
	public static void takeScreenShotOnFailure(WebDriver driver, String tname) throws IOException
	{
		TakesScreenshot ts=(TakesScreenshot) driver;
		File src=ts.getScreenshotAs(OutputType.FILE);
		File target=new File("./Screenshots/"+tname+".png");
		FileUtils.copyFile(src,target);
		Reporter.log("Screenshot taken",true);
		
	}

}
