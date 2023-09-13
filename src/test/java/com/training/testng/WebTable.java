package com.training.testng;


import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WebTable
{
	static WebDriver driver;
	public static void main(String[] args)
	{
		//WebDriverManager.chromedriver().setup();
		//System.out.println(System.getProperty("user.dir"));
		
		//String userdir = System.getProperty("user.dir")+"//resources//chromedriver";
		System.setProperty("webdriver.chrome.driver","/Users/harneetkaur/eclipse-workspace/TestNGAnnotations/resources/chromedriver");
		
		driver = new ChromeDriver();
		driver.get("https://www.selenium.dev/downloads/");
		driver.manage().window().maximize();
		clickJava();
		tearDown();
	}
	public static void clickJava()
	{
		List<WebElement> versionList = driver.findElements(By.xpath("//div[3][@class='col-sm-4 p-3']//a"));
		for(WebElement ele:versionList)
		{
			if(ele.getText().equals("Changelog"))
			{
				ele.click();
				String ev="selenium/java/CHANGELOG at trunk · SeleniumHQ/selenium · GitHub";
				String av=driver.getTitle();
				//System.out.println(av);
				if(ev.equals(av))
				{
					System.out.println("ValidationPassed");
				}
				break;
			}
		}
	}
	public static void validateClick()
	{
		clickJava();
		String ev ="selenium/java/CHANGELOG at trunk · SeleniumHQ/selenium · GitHub";
		
	}
	public static void explicitWait(int time, WebElement element)
	{
		//WebDriverWait wait = new WebDriverWait(driver,time);
		//wait.until(ExpectedConditions.visibilityOf(element));
	}
	public static void tearDown()
	{
		driver.quit();
	}
	
}
