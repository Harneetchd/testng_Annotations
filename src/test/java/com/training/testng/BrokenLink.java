package com.training.testng;

import java.io.File;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BrokenLink 
{
	static WebDriver driver;
	//String url = "";
	HttpURLConnection huc = null; // to start the procedure if url isnt empty, we use the special httpURLConnnection class
	int respCode = 200;
	
	@BeforeMethod
	public static void beforeMethod()
	{
		WebDriverManager.chromedriver().setup();
		
		driver = new ChromeDriver();
		driver.get("https://www.amazon.com/");
		
	}
	
	@Test
	public static void brokenLink()
	{
		List<WebElement> links = driver.findElements(By.tagName("a"));// all anchor tags start with a
		
		Iterator<WebElement> itr = links.iterator();
		
		while(itr.hasNext())
		{
			String url = itr.next().getAttribute("href");
			System.out.println(url);
			
			if(url == null || url.isEmpty())
			{
				System.out.println("URL is either not configured for anchor tag or it is empty");
				continue;
			}
			
			if(!url.startsWith("https://www.amazon.com/"))
			{
				System.out.println("URL belongs to another domain, skipping it.");
				continue;
			}
			
			
		}
		
	}
	
	@AfterMethod
	public static void tearDown() throws IOException
	{
		TakesScreenshot screenShot= ((TakesScreenshot)driver);
		File sourceFile =screenShot.getScreenshotAs(OutputType.FILE);
		
		Date currentDate= new Date();
		String timeStamp = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss").format(currentDate);
		
		String filePath= "/Users/harneetkaur/eclipse-workspace/TestNGAnnotations/screenshots//amazon"+timeStamp+".jpeg";
		
		File destinationFile = new File(filePath);
		
		FileUtils.copyFile(sourceFile, destinationFile);
		
		
		driver.close();
	}
	
  
}
