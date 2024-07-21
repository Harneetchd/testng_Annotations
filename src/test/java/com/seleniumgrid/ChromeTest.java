package com.seleniumgrid;

import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.testng.annotations.Test;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;


public class ChromeTest 
{
	protected WebDriver driver;

	@Test
	public void homePageCheck() throws MalformedURLException, InterruptedException
	{
		WebDriverManager.chromedriver().setup();
//		ChromeOptions chromeOptions = new ChromeOptions();
//		chromeOptions.setCapability(CapabilityType.BROWSER_NAME, "chrome");
		 DesiredCapabilities caps = new DesiredCapabilities();
		 caps.setCapability(CapabilityType.BROWSER_NAME, "chrome");
		 
		 //caps.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS, true);
		 //caps.setCapability(CapabilityType.PLATFORM_NAME, "mac");
		 //caps.setCapability(CapabilityType.BROWSER_VERSION, false);
	
		 
		 //driver = new RemoteWebDriver(new URL("http://192.168.0.242:4444"),caps);
		 driver = new RemoteWebDriver(new URL("http://3.145.124.67:4444/"),caps);
		 
		 driver.get("https://www.google.com/");
		 
		 driver.findElement(By.name("q")).sendKeys("Selenium");
		 Thread.sleep(5000);
		 driver.close();
		
	}
	

}
