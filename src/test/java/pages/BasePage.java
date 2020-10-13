package pages;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class BasePage {
	
	public WebDriver driver;
	
	@BeforeTest
	public void setUP() throws IOException
	{
		
		FileInputStream propertiesFile=new FileInputStream("Properties\\EnvironmentDetails.properties");
		Properties pr=new Properties();
		pr.load(propertiesFile);
		
		String browser=pr.getProperty("browser");
		
		if(browser.equalsIgnoreCase("chrome"))
		{
			
			driver=new ChromeDriver();
		}
		else if(browser.equalsIgnoreCase("firefox"))
		{
			driver=new FirefoxDriver();
		}
		
		
		driver.get(pr.getProperty("url"));
		
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
			
		
	}
	
	
	
	
	@AfterTest
	public void tearDown()
	{
		
		driver.quit();
		
	}

}
