package com.training.testng;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class sslCertSeleniumUI 
{
	
	@Test()
	public void sslChrome()
	{
		 
		 //WebDriverManager.chromedriver().setup();
		 System.setProperty("webdriver.chrome.driver","/Users/harneetkaur/eclipse-workspace/TestNGFramework/mydriver/chromedriver");
		 
		 ChromeOptions handlingSSL = new ChromeOptions();
		 handlingSSL.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS, true);
		 
		 WebDriver driver = new ChromeDriver(handlingSSL);
		 driver.get("https://expired.badssl.com/");
		 System.out.println("The page title is : " +driver.getTitle());
		 driver.quit();
	}
	
	@Test()
	public void sslFireFox()
	{
		 
		 System.setProperty("webdriver.firefox.driver","/Users/harneetkaur/eclipse-workspace/TestNGFramework/mydriver/geckodriver");
		 
		 FirefoxOptions  handlingSSL = new FirefoxOptions ();
		 handlingSSL.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS, true);
		 //handlingSSL.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
		 
		 WebDriver driver = new FirefoxDriver(handlingSSL);
		 driver.get("https://expired.badssl.com/");
		 System.out.println("The page title is : " +driver.getTitle());
		 //driver.quit();
	}
	
}
