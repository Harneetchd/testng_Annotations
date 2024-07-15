package com.training.testng;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ShadowDOM 
{
	WebDriver driver;
	@BeforeMethod
	public void setUp()
	{
		System.setProperty("webdriver.chrome.driver", "/Users/harneetkaur/eclipse-workspace/TestNGFramework/mydriver/chromedriver");
	    driver = new ChromeDriver();
	    driver.get("https://selectorshub.com/xpath-practice-page/");
		
	}
	
	@Test
	public void inputTextUsingLocators()
	{
		WebElement input = driver.findElement(By.xpath("//input[@id='kils']"));
		input.sendKeys("Testing"); 
		//OR
		WebElement inputText = driver.findElement(By.cssSelector("input#kils"));
		inputText.sendKeys("Testing");
	}
	
	@Test
	public void enterTextUsingJavaScript() //without typeCasting WebElement:API changes-directly use SearchContext
	{
		WebElement rootElement= driver.findElement(By.cssSelector("#userName"));
		
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		
		SearchContext shadowDom1=(SearchContext)jse.executeScript("return arguments[0].shadowRoot", rootElement);
		
		
		WebElement inputText= shadowDom1.findElement(By.cssSelector("input#kils"));
		inputText.sendKeys("Testing");
	}
	
	@Test
	public void enterTextUsingSearchContextSelenium4() 
	{
		//To access Shadow DOM elements in Selenium 4 with Chromium browsers (Microsoft Edge and Google Chrome) version 96 or greater, use the new shadow root method:
		SearchContext shadowDom1 = driver.findElement(By.cssSelector("#userName")).getShadowRoot();
		 
		
		WebElement inputText= shadowDom1.findElement(By.cssSelector("#kils"));
		inputText.sendKeys("Testing");
	}
	
	@AfterMethod
	public void tearDown() throws InterruptedException
	{
		Thread.sleep(5000);
		driver.close();
	}
}
