package testscripts.regression;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.concurrent.TimeUnit;

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

public class DBTestingDataProvider {
	

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
	public Object[][] getData() throws IOException, SQLException
	{
		
Connection conn=null;
		
		String url="jdbc:mysql://localhost:3306/";
		String dbName="testdb";
		String username="root";
		String password="reyaz123";
		
		String DBdriver="com.mysql.jdbc.Driver";
		
		conn=DriverManager.getConnection(url+dbName, username, password);
		
		PreparedStatement psmt=conn.prepareStatement("SELECT * FROM adactintable;");
		
		ResultSet rs=psmt.executeQuery();
		
		rs.last();
		
		int noOfRows=rs.getRow();
		
		rs.beforeFirst();
		
		
		Object[][] obj=new Object[noOfRows][2];
		
		
		for(int i=0;i<noOfRows;i++)
		{
			rs.next();
			
			obj[i][0]=rs.getString("username");
			obj[i][1]=rs.getString("password");
		}
		
		return obj;
		
		
		
		
	}

}
