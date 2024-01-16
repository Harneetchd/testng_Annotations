package com.training.testng;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FindButtons
{
	WebDriver driver;
	
	@BeforeMethod
	public void beforeMethod()
	{
		WebDriverManager.chromedriver().setup();
		
		driver = new ChromeDriver();
		
		driver.get("https://www.amazon.com/");	
	}
	
	@Test
	public void buttons()
	{
		List<WebElement> buttons = driver.findElements(By.xpath("//button"));
		
		System.out.println(buttons.equals("submit"));
		/*
		 * for(WebElement button:buttons) { System.out.println(button); }
		 */
		
	}
	
	
}
