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

public class AdactinLoginDataProvider {
	

WebDriver driver;
	
	@BeforeMethod
	public void setUp()
	{
		driver=new ChromeDriver();
		
		driver.get("http://adactinhotelapp.com/");
		
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
	}
	
	
	@AfterMethod
	public void teardown()
	{
		driver.quit();
		
	}
	
	
	@Test(dataProvider="getData")
	public void adactinLoginTest(String username,String password) throws InterruptedException, IOException
	{
		
		driver.findElement(By.xpath("//input[@name='username']")).sendKeys(username);
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys(password);
		driver.findElement(By.xpath("//input[@name='login']")).click();
		
		String expTitle="Adactin.com - Search Hotel";
		String actTitle=driver.getTitle();
		
		Assert.assertEquals(expTitle, actTitle);
		
				
		
	}

	
	
	@DataProvider
	public Object[][] getData() throws IOException
	{
		
		
		FileInputStream f=new FileInputStream("E:\\RamaRao\\FrameworkAutomation\\src\\test\\resources\\testdata\\registration.xlsx");
		
		XSSFWorkbook wb=new XSSFWorkbook(f);
		
		XSSFSheet ws=wb.getSheet("Sheet2");
		
		Object[][] obj=new Object[ws.getLastRowNum()][2];
		
		
		for(int i=0,j=1;i<ws.getLastRowNum();i++)
		{
			obj[i][0]=ws.getRow(j).getCell(0).getStringCellValue();
			obj[i][1]=ws.getRow(j).getCell(1).getStringCellValue();
			j++;
			
		}
		
		
		return obj;
		
		
		
		
	}
	
}
