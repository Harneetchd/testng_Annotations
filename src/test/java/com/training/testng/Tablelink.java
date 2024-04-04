package com.training.testng;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Tablelink 
{
	WebDriver driver;
	
	String city ;
	int row;
	String linkText;
	String title;
	String expTitle;
	
	@BeforeMethod
	public void beforeMethod()
	{
		WebDriverManager.chromedriver().setup();
		
		driver = new ChromeDriver();
		driver.get("file:///Users/harneetkaur/Library/Mobile%20Documents/com~apple~TextEdit/Documents/Tables.html");
	}
	
	@Test
	public void clickCity()
	{
		
		city ="Clock Tower Hotel";
		
		if(city=="Burj Khalifa")
		{
			row=7;
			linkText="https://login.salesforce.com/";
			//String expTitle= "Login | Salesforce";
		}
		if(city=="Clock Tower Hotel")
		{
			row=14;
			linkText="https://ctmstaging.cliniops.com/sam/index";
			//expTitle="Sign In - CliniOps";
		}
		//b[text()='Burj Khalifa']
		if(city=="Taipei 101")
		{
			row=21;
			linkText="https://yojanastatus.com/arun-yogiraj/";
			//expTitle="Arun Yogiraj Wikipedia, Wiki, Shilpi, Ram Statue, Age, Work, Wife, Family";
		}
		if(city=="Financial Center")
		{
			row=28;
			linkText="https://www.youtube.com/watch?v=LjRm96Oqvco";
			//expTitle="'Grandfather, Main Pillar Of This Art'|Brother Of Arun Yogiraj, Sculptor Of Ramlala Idol | Exclusive - YouTube";
		}
		
		WebElement link = driver.findElement(By.xpath("//table[' "+row+" ']/tbody/tr/td/p/span/a[@href='"+linkText+"']"));
		//Dynamic webtable: we wrote dynamic xpath by parameterizing it : row and linktext
		link.click();
		title = driver.getTitle();
		expTitle="Sign In - CliniOps";
		Assert.assertEquals(title,expTitle, "Titles Dont Match");
		
	}
	
	@AfterMethod
	public void tearDown()
	{
		TakesScreenshot sc= ((TakesScreenshot)driver);
		File src=sc.getScreenshotAs(OutputType.FILE);
		
		Date currdate= new Date();
		String timestamp= new SimpleDateFormat("yy-MM-dd-HH-mm-ss").format(currdate);
		
		String path = "/Users/harneetkaur/eclipse-workspace/TestNGAnnotations/screenshots/webtable"+timestamp+".jpeg";
		
		File des = new File(path);
		
		try 
		{
			FileUtils.copyFile(src, des);
		} catch (IOException e) 
		{
			e.printStackTrace();
		}
		
		driver.quit();
	}

}
