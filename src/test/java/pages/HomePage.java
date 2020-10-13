package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	
	WebDriver driver;
	
	
	public HomePage(WebDriver driverFromBaseClass)
	{
		
		this.driver=driverFromBaseClass;
		
		PageFactory.initElements(driver, this);
		
	}
	
	
	/*
	WebElement username=driver.findElement(By.xpath("//input[@name='username']"));
	
	WebElement password=driver.findElement(By.xpath("//input[@name='password']"));
	
	WebElement login=driver.findElement(By.xpath("//input[@name='login']"));*/
	
	
	@FindBy(xpath="//input[@name='username']") 
	WebElement username;
	
	@FindBy(xpath="//input[@name='password']") 
	WebElement password;
	
	@FindBy(xpath="//input[@name='login']") 
	WebElement login;
	
	public void login(String un,String pass)
	{
		username.sendKeys(un);
		password.sendKeys(pass);
		login.click();
		
	}
	
	

}
