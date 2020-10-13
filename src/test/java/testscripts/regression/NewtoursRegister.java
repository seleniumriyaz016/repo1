package testscripts.regression;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Iterator;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import junit.framework.Assert;

public class NewtoursRegister {
	

WebDriver driver;
	
	@BeforeMethod
	public void setUp()
	{
		driver=new ChromeDriver();
		
		//driver.get("http://demo.guru99.com/test/newtours/");
		
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
	}
	
	
	@AfterMethod
	public void teardown()
	{
		driver.quit();
		
	}
	
	
	@Test
	public void newtoursRegisterTest() throws InterruptedException, IOException
	{
		
		driver.findElement(By.xpath("//a[text()='REGISTER']")).click();
		
		
		FileInputStream f=new FileInputStream("E:\\RamaRao\\FrameworkAutomation\\src\\test\\resources\\testdata\\registration.xlsx");
		
		XSSFWorkbook wb=new XSSFWorkbook(f);
		
		XSSFSheet ws=wb.getSheet("Sheet1");
		
		Iterator<Row>  rows=ws.iterator();
		
		Row row=null;
		Cell cell=null;
		
		rows.next();
		
		while(rows.hasNext())
		{
			row=rows.next();
			driver.findElement(By.xpath("//input[@name='firstName']")).clear();
			driver.findElement(By.xpath("//input[@name='firstName']")).sendKeys(row.getCell(0).getStringCellValue());
			driver.findElement(By.xpath("//input[@name='lastName']")).clear();
			driver.findElement(By.xpath("//input[@name='lastName']")).sendKeys(row.getCell(1).getStringCellValue());
			driver.findElement(By.xpath("//input[@name='phone']")).clear();
			driver.findElement(By.xpath("//input[@name='phone']")).sendKeys(row.getCell(2).getStringCellValue());
			driver.findElement(By.xpath("//input[@name='userName']")).clear();
			driver.findElement(By.xpath("//input[@name='userName']")).sendKeys(row.getCell(3).getStringCellValue());
			driver.findElement(By.xpath("//input[@name='address1']")).clear();
			driver.findElement(By.xpath("//input[@name='address1']")).sendKeys(row.getCell(4).getStringCellValue());
			driver.findElement(By.xpath("//input[@name='city']")).clear();
			driver.findElement(By.xpath("//input[@name='city']")).sendKeys(row.getCell(5).getStringCellValue());
			driver.findElement(By.xpath("//input[@name='state']")).clear();
			driver.findElement(By.xpath("//input[@name='state']")).sendKeys(row.getCell(6).getStringCellValue());
			driver.findElement(By.xpath("//input[@name='postalCode']")).clear();
			driver.findElement(By.xpath("//input[@name='postalCode']")).sendKeys(row.getCell(7).getStringCellValue());
			driver.findElement(By.xpath("//select[@name='country']")).sendKeys(row.getCell(8).getStringCellValue());
			driver.findElement(By.xpath("//input[@name='email']")).clear();
			driver.findElement(By.xpath("//input[@name='email']")).sendKeys(row.getCell(9).getStringCellValue());
			driver.findElement(By.xpath("//input[@name='password']")).clear();
			driver.findElement(By.xpath("//input[@name='password']")).sendKeys(row.getCell(10).getStringCellValue());
			driver.findElement(By.xpath("//input[@name='confirmPassword']")).clear();
			driver.findElement(By.xpath("//input[@name='confirmPassword']")).sendKeys(row.getCell(11).getStringCellValue());
			driver.findElement(By.xpath("//input[@name='submit']")).click();
			
			String actText=driver.findElement(By.xpath("(//font/b)[2]")).getText();
			
			String expText=row.getCell(9).getStringCellValue();
			boolean b;
			if(actText.contains(expText))
			{
				b=true;
				
				row.createCell(12).setCellValue("Passed");
			}
			else
			{
				b=false;
				row.createCell(12).setCellValue("Failed");
			}
			
			
			
			
			driver.navigate().back();
			
		}
		
		FileOutputStream f1=new FileOutputStream("E:\\RamaRao\\FrameworkAutomation\\src\\test\\resources\\testdata\\registration.xlsx");
		
		wb.write(f1);
		
		f1.close();
		
	}

}
