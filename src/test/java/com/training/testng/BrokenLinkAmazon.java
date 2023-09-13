package com.training.testng;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BrokenLinkAmazon 
{
	static WebDriver driver;
	
	public static void main(String[] args) throws MalformedURLException 
	{
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://www.amazon.com/");
		//driver.navigate().to("https://www.amazon.com/");
		
		List<WebElement> listOfLinks=driver.findElements(By.tagName("a"));
		int brokenCount=0;
		
		for(WebElement ele:listOfLinks)
		{
			String url = ele.getAttribute("href");
			
			if(url==null || url.isEmpty())
			{
				System.out.println("The URL is Empty");
				continue;
			}
			else
			{
				URL links = new URL(url);//convert string url to URL
				
			
				try 
				{
					HttpURLConnection huc = (HttpURLConnection) links.openConnection();
					huc.connect();
					
					if(huc.getResponseCode()>=400)
					{
						System.out.println(huc.getResponseCode()+url+" is "+" BrokenLink");
						brokenCount++;
					}
					else
					{
						System.out.println(huc.getResponseCode()+url+" is "+" ValidLink");
					}
					
				} 
				catch (Exception e) 
				{
				
				}
					
			}
		}
		System.out.println("The Broken link Count is: "+brokenCount);
	}
}
