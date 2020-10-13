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

public class AdactinLogin {
	

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
	public Object[][] getData()
	{
		
		Object[][] obj=new Object[3][2];
		
		obj[0][0]="reyaz009";
		obj[0][1]="reyaz123";
		
		obj[1][0]="reyaz009";
		obj[1][1]="reyaz423";
		
		obj[2][0]="reyaz019";
		obj[2][1]="reyaz123";
		
		
		return obj;
		
		
		
		
	}
	
}
