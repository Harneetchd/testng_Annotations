package com.training.testng;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import freemarker.template.SimpleDate;
import io.github.bonigarcia.wdm.WebDriverManager;



public class DynamicTable2 
{
	 WebDriver driver;
	 int num;
	 static int totalRows;
	 static int totalColumns;
	 String text ;
	 static XSSFWorkbook workBook;
	 static XSSFSheet workSheet;
	 static File file;
	@BeforeMethod
	public void setUp()
	{
		WebDriverManager.chromedriver().setup();
		
		driver= new ChromeDriver();
		driver.get("https://demo.guru99.com/test/web-table-element.php");
        driver.manage().window().maximize();
       // driver.manage().window().fullscreen();
        List<WebElement>cols= driver.findElements(By.xpath("//div[@id='wrapper']/div[@id='leftcontainer']/table/thead/tr/th"));
		totalColumns =cols.size(); //5
		System.out.println("Total Colummns: "+cols.size());
		
		List<WebElement>rows = driver.findElements(By.xpath("//div[@id='wrapper']/div[@id='leftcontainer']/table/tbody/tr/td[1]"));
		totalRows = rows.size();//26
		System.out.println("Total Rows: "+rows.size());
		
      
	}
	
	@Test
 	public  void checkCompanyName() throws IOException
	{
		boolean status = true;
		String companyName="IIFL Holdings";
		
		//row = 5;
		//column=3;
		List<WebElement> cellText= driver.findElements(By.xpath("//div[@id='wrapper']/div[@id='leftcontainer']/table/tbody/tr"));
				//div[@id='wrapper']/div[@id='leftcontainer']/table/tbody/tr[1]/td[1]
		        //div[@id='wrapper']/div[@id='leftcontainer']/table/tbody/tr[3]/td[4]
	
	
		for(WebElement ele : cellText)
		{
			text = ele.getText();
			if(text.contains(companyName))
			{
				status=true;
				System.out.println("CompanyFound :"+text);
				break;
			}
			else
			{
				status= false;
			}
		
		}
		
		if(status==false)
		{
			System.out.println("No such Company Exists");
		}
	}
	
	@Test
	public void writeFile() throws InvalidFormatException, IOException
	{
		int r=1;
		int c=0;
		
		String path = "/Users/harneetkaur/eclipse-workspace/TestNGAnnotations/files/Book2.xlsx";
		
		FileInputStream fi = new FileInputStream(path);
		
		workBook = new XSSFWorkbook(fi);
		workSheet = workBook.getSheet("ExcelFile");
		
		List<WebElement> cellText= driver.findElements(By.xpath("//div[@id='wrapper']/div[@id='leftcontainer']/table/tbody/tr/td"));
		
		
		
		Row rown= workSheet.createRow(r);
			
			for(WebElement ele : cellText)
			{
				text = ele.getText();
				System.out.println(text);
				
			 
				
				Cell celln = rown.createCell(c);
				celln.setCellValue(text);
					
				FileOutputStream fo = new FileOutputStream(path);
				workBook.write(fo);
				c++;
				
				if(c%totalColumns==0) //c%5
				{
					rown = workSheet.createRow(r+1);
					r++;
					c=0;
				}
				
			}
	
		currentDate("ExcelFile",path);
		
	}
	
	
	public static void currentDate(String sheet,String path) throws IOException
	{
//        File file= new File(path);
//		
//		FileInputStream fi = new FileInputStream(file);
		
		Date currDate =new Date();
		String timeStamp= new SimpleDateFormat("yyyy-MM-dd/HH:mm:ss").format(currDate);
		
		int r=0;
		Row row = workSheet.createRow(r);
		Cell cellz = row.createCell(0);
		cellz.setCellValue("COMPANY DETAILS_Date/Time_"+timeStamp);
		

		FileOutputStream fo = new FileOutputStream(path);
		workBook.write(fo);
		workBook.close();
		fo.close();
	}
	
	
	@AfterMethod
	public void tearDown()
	{
		//driver.quit();
	}
}
