package practise;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class MouseHover {
	
	
WebDriver driver;
	
	@BeforeMethod
	public void setUp()
	{
		driver=new ChromeDriver();
		
		driver.get("https://www.stepchange.org/");
		
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
	}
	
	
	@AfterMethod
	public void teardown()
	{
		driver.quit();
		
	}
	
	@Test
	public void mouseHoverTest() throws InterruptedException
	{
		
		
		driver.findElement(By.xpath("//a[@id='CybotCookiebotDialogBodyButtonAccept']")).click();
		
		
		Actions action=new Actions(driver);
		
		action.moveToElement(driver.findElement(By.xpath("//a[text()='How we help']"))).perform();
		
		driver.findElement(By.xpath("//a[text()='Money advice']")).click();
		
		
		
		
		
		
		
	}
	
	
	

}
