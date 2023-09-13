package com.training.testng;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AmazoniPhone 
{
	static WebDriver driver;
	
	@BeforeMethod
	public void beforeMethod()
	{
		WebDriverManager.chromedriver().setup();
		
		//we getproperty: path to testNg.... we are not hardcoding to chrome
		/*
		 * System.out.println("Printing userdir......"+System.getProperty("user.dir"));
		 * 
		 * //we create another variable to give complete path to chrome and pass it to
		 * setProperty String userdir=
		 * System.getProperty("user.dir")+"//resources//chromedriver";
		 * 
		 * userdir = userdir.replace("//","////");
		 * System.out.println("user dir...."+userdir);
		 * 
		 * // setproperty(key(),value()):we pass the complete path to driver in
		 * resources. System.setProperty("webdriver.chrome.driver", (userdir));
		 */
		driver = new ChromeDriver();
		driver.get("https://www.amazon.com/");
		driver.manage().window().maximize();
	}
	
	@Test
	public void logIn() throws InterruptedException
	{
		WebElement clickAcc=driver.findElement(By.xpath("//div//span[@id='nav-link-accountList-nav-line-1']"));
		clickAcc.click();
		
		WebElement emailId=driver.findElement(By.id("ap_email"));
		waitExplicit(10,emailId);
		emailId.sendKeys("chdniti@gmail.com");
		
		WebElement clickContinue= driver.findElement(By.id("continue"));
		clickContinue.click();
		
		WebElement password= driver.findElement(By.id("ap_password"));
		password.sendKeys("benihina1018");
		
		WebElement signIn= driver.findElement(By.xpath("//input[@id='signInSubmit']"));
		signIn.click();
		
		Thread.sleep(8000);
		WebElement enterText= driver.findElement(By.xpath("//div[@id='nav-belt']//input[@id='twotabsearchtextbox']"));
		waitExplicit(100,enterText);
		enterText.sendKeys("iPhone 14 256 gb");
	
        
		driver.findElement(By.xpath("//div[@id='nav-belt']//div[@class='nav-right']//input[@id='nav-search-submit-button']")).click();
		
		//WebElement iphoneLink0= driver.findElement(By.xpath("//div[@data-asin='B0BN72MLT2']//div//h2//a"));
		//waitExplicit(10,iphoneLink0);
		//iphoneLink0.click();
		WebElement iphoneLink= driver.findElement(By.xpath("//div[@data-asin='B0BN71T1J7']//div//h2//a"));
		waitExplicit(10,iphoneLink);
		iphoneLink.click();
		
		WebElement addToCart=driver.findElement(By.xpath("(//input[@id='add-to-cart-button'])[1]"));
		////div//span/input[@type='button']
		////div[@id='ppd']/div[@id='rightCol']//div[@id='renewedTier2AccordionRow']//form//div//input[@type='button']
		//waitExplicit(25,addToCart);
		Thread.sleep(2500);
		addToCart.click();
		
		
		/*
		 * WebElement noThanks = driver.findElement(By.xpath(
		 * "//input[@aria-labelledby='attachSiNoCoverage-announce']")); waitExplicit(25,
		 * noThanks); noThanks.click();
		 */
		   Thread.sleep(3000);
		 
		  WebElement goToCart= driver.findElement(By.xpath("//a[@href='/cart?ref_=sw_gtc']"));
		  goToCart.click();
		  
		  WebElement delete= driver.findElement(By.xpath("(//input[@value='Delete'])[1]"));
		  delete.click();
	}
	
	
	@Test
	public void waitExplicit(int time, WebElement element)
	{
		//WebDriverWait wait= new WebDriverWait(driver,time);
		//wait.until(ExpectedConditions.visibilityOf(element));
	}
	@AfterMethod
	public void tearDown()
	{
		driver.close();
	}

	
}
