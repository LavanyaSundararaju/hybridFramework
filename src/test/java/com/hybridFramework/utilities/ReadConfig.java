package com.hybridFramework.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ReadConfig {
	
	Properties pro;
	
	public ReadConfig()
	{
		File src=new File("./Configuration/config.properties");
		
		try {
			FileInputStream fis=new FileInputStream(src);
			
			pro=new Properties();
			pro.load(fis);
		}
		catch(Exception e)
		{
			System.out.println("Exception: "+e.getMessage());
			
		}
	}
	
	public String getURL()
	{
		String baseURL=pro.getProperty("baseURL");
		return baseURL;
	}
	
	public String getUsername()
	{
		String userName=pro.getProperty("username");
		return userName;
	}
	
	public String getPassword()
	{
		String password=pro.getProperty("password");
		return password;
	}
	
	public String getChromePath()
	{
		String chromePath=pro.getProperty("chromePath");
		return chromePath;
	}
	
	public String getFirefoxPath()
	{
		String firefoxPath=pro.getProperty("firefoxPath");
		return firefoxPath;
	}
	

}
