package com.training.testng;

import java.io.File;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ChromeExtensions
{
	public static void main(String[] args) 
	{
		WebDriver driver;
		 
		//WebDriverManager.chromedriver().setup();
		System.setProperty("webdriver.chrome", "/Users/harneetkaur/eclipse-workspace/TestNGAnnotations/mydrivers");
		
		ChromeOptions options = new ChromeOptions();
		
		options.addExtensions(new File("/Users/harneetkaur/Downloads/Screenshot-Screen-Recorder.crx"));
		
		driver = new ChromeDriver(options);
		
		driver.get("https://www.google.com/");
		driver.manage().window().maximize();
		
		driver.quit();
	}

}
