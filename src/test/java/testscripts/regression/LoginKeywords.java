package testscripts.regression;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginKeywords {
	
	WebDriver driver;
	
	public void launchBrowser()
	{
		driver=new ChromeDriver();
		
				
	}
	
	public void navigate()
	{
	
		driver.get("http://adactinhotelapp.com/");
		driver.manage().window().maximize();
	}
	
	public void enterUsername(String locator,String un)
	{
		driver.findElement(By.xpath(locator)).sendKeys(un);
		
	}
	
	public void enterPassword(String locator,String pass)
	{
		driver.findElement(By.xpath(locator)).sendKeys(pass);
		
	}

	public void clickLogin(String locator)
	{
		driver.findElement(By.xpath(locator)).click();
		
	}
	
	public void closeBrowser() throws InterruptedException
	{
		Thread.sleep(5000);
		
		driver.quit();
	}

	




}
