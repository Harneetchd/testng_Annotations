package com.seleniumgrid;

import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.testng.annotations.Test;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;


public class FirefoxTest 
{
	protected WebDriver driver;

	@Test
	public void homePageCheck() throws MalformedURLException, InterruptedException
	{
		WebDriverManager.firefoxdriver().setup();
		 DesiredCapabilities caps = new DesiredCapabilities();
		 //caps.setCapability(CapabilityType.PLATFORM_NAME, "mac");
		 caps.setCapability(CapabilityType.BROWSER_NAME, "firefox");
		 
		 //caps.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS, true);
		 
		 //caps.setCapability(CapabilityType.BROWSER_VERSION, false);
		 
		 
		 //driver = new RemoteWebDriver(new URL("http://192.168.0.242:4444"),caps);
		 driver = new RemoteWebDriver(new URL("http://18.217.85.90:4445/wd/hub"),caps);
		 
		 
		 driver.get("https://www.google.com/");
		 
		 driver.findElement(By.name("q")).sendKeys("Maven");
		 Thread.sleep(5000);
		 driver.close();
		
	}	

}
