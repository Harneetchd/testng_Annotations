package com.training.testng;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

 public class LoginTest
{
	static WebDriver driver;
	
	@BeforeMethod
	public void beforemethod() throws InterruptedException
	{
		WebDriverManager.chromedriver().setup();
	    driver = new ChromeDriver();
		driver.get("https://selenium-prd.firebaseapp.com/");
		Thread.sleep(1000);
		driver.findElement(By.id("email_field")).sendKeys("admin123@gmail.com"); 
		//driver.manage().timeouts().implicitlyWait(10,TimeUnit.MILLISECONDS);
	}
	@Test
	public void login1() throws InterruptedException
	{	
		Thread.sleep(8000);
		driver.findElement(By.id("email_field")).sendKeys("admin123@gmail.com"); 
		driver.findElement(By.id("password_field")).sendKeys("admin123");
		driver.manage().deleteAllCookies();
		driver.close();
		
	}
	@Test
	public void login()
 	{
		System.out.println("I need to login");
	}
}
