package com.training.testng;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class EbayBarCodeAutomation 
{
   static WebDriver driver;
 
   @BeforeMethod
	public void beforeMethod()
	{
		WebDriverManager.chromedriver().setup();
		
		driver = new ChromeDriver();
		driver.get("https://www.ebay.com/");
		
	}
   
   @Test
public void clickCategories()
   {
	   driver.findElement(By.id("gh-cat")).click();
   }
   
   @Test
public void clickMusic()
   {
	   driver.findElement(By.id("gh-cat")).click();
	   driver.findElement(By.xpath("//select[@id='gh-cat']/option")).click();
	   driver.findElement(By.xpath("//input[@id='gh-btn']")).click();
   }
   @Test
public void clickShopByCategory()
   {
	   driver.findElement(By.id("gh-shop-ei")).click();
	  List<WebElement> getList = driver.findElements(By.xpath("//a[@class='scnd']"));
	  for(WebElement element : getList) 
	  {
		  System.out.println(element.getText());
		  if (element.getText().equals("Women"))
		  {
			  element.click();
			  break;
		  }
	  }
	  
	   
   }
   
   @AfterMethod
   public void tearDown() throws IOException 
   {
	   TakesScreenshot screenshot = ((TakesScreenshot)driver);
	   File sourceFile= screenshot.getScreenshotAs(OutputType.FILE);
	   
	   
	   Date currentDate = new Date();//import java.util
	   String timeStamp= new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss").format(currentDate);
	   
	   String filePath = "/Users/harneetkaur/eclipse-workspace/maventraining/screenshots//Ebay"+timeStamp+".jpeg";
	   
	   File destinationFile = new File(filePath);
	   
	   FileUtils.copyFile(sourceFile, destinationFile);
	   
	  driver.close(); 
   }
   
	

}
