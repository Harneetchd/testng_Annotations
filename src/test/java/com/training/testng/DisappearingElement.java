package com.training.testng;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DisappearingElement
{
	WebDriver driver;
	String text;
	String color;
	@BeforeMethod
	public void setUp()
	{
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.get("https://demoqa.com/auto-complete");
		driver.manage().window().maximize();
	}
	
	@Test
	public void enterMultipleColors() throws InterruptedException
	{
        int i=0;
		Map<String,String>colorMap=new LinkedHashMap<String,String>();
		colorMap.put("R", "Red");
		colorMap.put("G","Green");
		colorMap.put("P", "Purple");
		colorMap.put("I","Indigo" );
		
		WebElement colors = driver.findElement(By.xpath("//div[@class='auto-complete__control css-yk16xz-control']/div[1]//input[@id='autoCompleteMultipleInput']"));
		
		
		  for(Map.Entry<String, String>dis:colorMap.entrySet())
			{
				System.out.println("Entering");
				colors.sendKeys(dis.getKey()); 
				Thread.sleep(2000);
				// colors.sendKeys("R");

				String color = dis.getValue();
				System.out.println("Color "+color);
				
				List<WebElement> dropdown = driver.findElements(By.xpath("//div[starts-with(@id,'react-select-2-option-')]"));
					if(dropdown.get(i).getText().contains(color))
					{
						WebElement ele=dropdown.get(i);
						System.out.println(ele.getText());
						Thread.sleep(3000);
						ele.click();
					}
					i++;
					System.out.println(i);
				/*
				 * for (WebElement word : dropdown) {
				 * 
				 * String probColor = word.getText(); Thread.sleep(2000); if
				 * (probColor.contains(color)) { word.click(); } break; }
				 */

			}
		 
		
		
//		WebElement dropd = driver.findElement(By.id("react-select-2-option-0"));
//		dropd.click();
		
		
//		colors.sendKeys("G");
//		WebElement dropd2 = driver.findElement(By.id("react-select-2-option-0"));
//		dropd2.click();
//		
//		
//		colors.sendKeys("P");
//		WebElement dropd3 = driver.findElement(By.id("react-select-2-option-0"));
//		dropd3.click();
//		
//		
//		colors.sendKeys("I");
//		WebElement dropd4 = driver.findElement(By.id("react-select-2-option-2"));
//		dropd4.click();
//		
//		
//		WebElement colorAlp= driver.findElement(By.xpath("//div[@class='body-height']//div[@id='autoCompleteSingle']//div[@class='auto-complete__control css-yk16xz-control']/div[1]//input"));
//		colorAlp.sendKeys("Y");
//		
//		 WebElement drop=driver.findElement(By.id("react-select-3-option-0"));
//		 drop.click();
		 
	}
	@Test
	public void enterSingleColor()
	{
		
		//JavascriptExecutor js = (JavascriptExecutor)driver;
		
		WebElement colorAlp= driver.findElement(By.xpath("//div[@class='body-height']//div[@id='autoCompleteSingle']//div[@class='auto-complete__control css-yk16xz-control']/div[1]//input"));
		colorAlp.sendKeys("Re");
		//js.executeScript("arguments[0].value='Re' ", colorAlp);
		
		//String text = (String) js.executeScript("return arguments[0].value", colorAlp);  
		//System.out.println(text);
		
		
		 // Actions action = new Actions(driver); //
		  WebElement dropd=driver.findElement(By.id("react-select-3-option-0"));
		  dropd.click();
		  //action.moveToElement(dropd).build().perform();	
	  }
	
	@AfterMethod
	public void tearDown() throws InterruptedException
	{
		Thread.sleep(1000);
		driver.close();
	}

	
}
