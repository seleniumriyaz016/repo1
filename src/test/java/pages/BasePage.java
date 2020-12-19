package pages;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class BasePage {
	
	public static WebDriver driver;
	public static ExtentReports extent;
	public static ExtentTest test;
	
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
		
		String pattern = "yyyy-MM-dd HH:mm:ss";
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);

		String date = simpleDateFormat.format(new Date());
		date=date.replace(":", "-");
		System.out.println(date);
		
		
		File srcDir=new File(System.getProperty("user.dir")+"\\reports");
		
		srcDir.mkdir();
	
		String dirPath=System.getProperty("user.dir")+"\\reports\\";
		
		File path=new File(dirPath+date+".html");
		
		ExtentSparkReporter reporter=new ExtentSparkReporter(path);
		
		reporter.config().setDocumentTitle("Test Regression Results");
		
		reporter.config().setReportName("Adactin Regression Tests");
		
			
		extent=new ExtentReports();
		
		extent.attachReporter(reporter);
		
		extent.setSystemInfo("Tester", "Reyaz Shaik");
		
			
		
	}
	
	
	
	
	@AfterTest
	public void tearDown()
	{
		extent.flush();
		driver.quit();
		
	}

}
