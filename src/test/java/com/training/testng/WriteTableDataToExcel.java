package com.training.testng;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.excel.dataprovider.SetDataToExcel;

import io.github.bonigarcia.wdm.WebDriverManager;

class WriteTableDataToExcel extends SetDataToExcel
{
	static SetDataToExcel set;
	protected WriteTableDataToExcel(String path) {
		super(path);
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) throws InterruptedException, IOException
	{
	WebDriverManager.chromedriver().setup();
	WebDriver driver=new ChromeDriver();
	driver.manage().window().maximize();
	driver.get("https://demo.guru99.com/test/web-table-element.php");

	String path="/Users/harneetkaur/eclipse-workspace/TestNGAnnotations/files/TableData.xlsx";
    set=new SetDataToExcel(path);
	//write headers in excel sheet
	set.setCellData("Sheet1", 0, 0,"Company");
	set.setCellData("Sheet1", 0, 1,"Group");
	set.setCellData("Sheet1", 0, 2,"Prev Close(Rs)");
	set.setCellData("Sheet1", 0, 3,"Current Price(Rs)");
	set.setCellData("Sheet1", 0, 4,"% Change");
	//capture table rows
	
	WebElement baseTable=driver.findElement(By.tagName("table"));
	List<WebElement>rows=baseTable.findElements(By.xpath("//tbody/tr"));
	int noOfRows=rows.size();
	for(int i=1;i<=noOfRows-1;i++)
	{
		//read data from web table
	String Company=baseTable.findElement(By.xpath("//tbody/tr["+i+"]/td[1]")).getText();
	String Group=baseTable.findElement(By.xpath("//tbody/tr["+i+"]/td[2]")).getText();
	String PrevCloseRs=baseTable.findElement(By.xpath("//tbody/tr["+i+"]/td[3]")).getText();
	String CurrentPriceRs=baseTable.findElement(By.xpath("//tbody/tr["+i+"]/td[4]")).getText();
	String Change=baseTable.findElement(By.xpath("//tbody/tr["+i+"]/td[5]")).getText();
	System.out.println(Company + Group + PrevCloseRs + CurrentPriceRs + Change);
	   //write data to excel file
	set.setCellData("Sheet1",i,0,Company);
	set.setCellData("Sheet1",i,1,Group);
	set.setCellData("Sheet1",i,2,PrevCloseRs);
	set.setCellData("Sheet1",i,3,CurrentPriceRs);
	set.setCellData("Sheet1",i,4,Change);
	}
	System.out.println("Web Table copying/scraping is done");
	}
}