package com.training.testng;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class YahooWatchlist
{
	static WebDriver driver;
	
	@BeforeMethod
	public void beforeMethod()
	{
	    WebDriverManager.chromedriver().setup();
	    
	    driver = new ChromeDriver();
	    driver.get("https://finance.yahoo.com/?guccounter=1&guce_referrer=aHR0cHM6Ly93d3cuZ29vZ2xlLmNvbS8&guce_referrer_sig=AQAAALc3D5u7BViRFX02_dKAIq_GImTnZRAy_lx6xlL6wgA2BjEt3sEDyvOoobQgQV_I0C2wOgpV9y619yOvX1ZadyWMIqR1AtfxzmvchXASonLqN1YGI6bUQAlqTMtjrRkqx8Odz6fJmiN9w99DaY8nI2XdaOu5DY7_7d39t61-5L06");
	    driver.manage().window().maximize();
	    System.out.println(driver.getTitle());
	}
	
	@Test
	public void watchList() throws InterruptedException
	{
		WebElement window= driver.findElement(By.xpath("//button[@title='Close modal']"));
		window.click();
		Thread.sleep(500);
		WebElement wl= driver.findElement(By.xpath("//a[contains(text(),'Watchlists')]"));
		wl.click();
		String title=wl.getText();
		System.out.println(title);
		String ev="Watchlists";
		if(title.equalsIgnoreCase(ev))
		{
			System.out.println("Watchlist Validate Successful");
		}
	}
	
	@AfterMethod
	public void tearDown()
	{
		driver.close();
	}
		
	
	
}
