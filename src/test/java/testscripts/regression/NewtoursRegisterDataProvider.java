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
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import junit.framework.Assert;

public class NewtoursRegisterDataProvider {
	

WebDriver driver;
	
	@BeforeMethod
	public void setUp() throws InterruptedException
	{
		driver=new ChromeDriver();
		
		//driver.get("http://demo.guru99.com/test/newtours/");
		
		driver.get("http://adactinhotelapp.com/");
		
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		//driver.findElement(By.xpath("//a[text()='REGISTER']")).click();
		
		//Thread.sleep(5000);
		
	}
	
	
	@AfterMethod
	public void teardown()
	{
		driver.quit();
		
	}
	
	
	@Test(dataProvider="getData")
	public void adactinLoginTest(Row row) throws InterruptedException, IOException
	{
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
		
		String expText=" Note: Your user name is "+row.getCell(9).getStringCellValue()+".";
		
		Assert.assertEquals(expText, actText);
				
		
	}

	
	
	@DataProvider
	public Object[][] getData() throws IOException
	{
		
		FileInputStream f=new FileInputStream("E:\\RamaRao\\FrameworkAutomation\\src\\test\\resources\\testdata\\registration.xlsx");
		
		XSSFWorkbook wb=new XSSFWorkbook(f);
		
		XSSFSheet ws=wb.getSheet("Sheet1");
		
			
		Object[][] obj=new Object[ws.getLastRowNum()][1];
		
		for(int i=0,j=1;i<ws.getLastRowNum();i++)
		{
			obj[i][0]=ws.getRow(j);
			j++;
			
		}
		
		
		
		return obj;
		
		
		
		
	}
	
}
