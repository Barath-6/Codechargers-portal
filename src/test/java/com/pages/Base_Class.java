package com.pages;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.google.common.io.Files;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;




public class Base_Class {
	
	public static WebDriver driver;
	
	public static Logger log;
	public static int i=1;
	
	public static ExtentReports report=new ExtentReports("extentreport.html");

	public static ExtentTest test;
	
	public void launchBrowser(String url) {
		
		System.setProperty("webdriver.chrome.driver", "F:\\bharath\\Project\\src\\test\\resources\\drivers\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get(url);
	}
	public  static void Logger(String msg) {
		log=Logger.getLogger(Base_Class.class.getName());
		log.setLevel(Level.ALL);
		log.info(msg);
	}
	
	public  void takeSnap() throws IOException
	{ 

		File srcFile; 
		srcFile =((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		Files.copy(srcFile, new File("src\\test\\resources\\com\\screenshots\\screenshot- " + i + ".jpeg")); 
		i++;


	}
	



}
