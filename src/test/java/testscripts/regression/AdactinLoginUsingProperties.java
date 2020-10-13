package testscripts.regression;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AdactinLoginUsingProperties {
	

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
	public void teardown() throws InterruptedException
	{
		Thread.sleep(5000);
		driver.quit();
		
	}
	
	@Test
	public void loginTest() throws IOException
	{
		FileInputStream propertiesFile=new FileInputStream("Properties\\elementLocators.properties");
		Properties pr=new Properties();
		pr.load(propertiesFile);
		
		
		driver.findElement(By.xpath(pr.getProperty("username_txt"))).sendKeys("reyaz009");
		driver.findElement(By.xpath(pr.getProperty("password_txt"))).sendKeys("reyaz123");
		driver.findElement(By.xpath(pr.getProperty("login_button"))).click();
		
		
		
		
	}

}
