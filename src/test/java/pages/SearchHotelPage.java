package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class SearchHotelPage {
	
	WebDriver driver;
	
	public SearchHotelPage(WebDriver driverFromBaseClass)
	{
		
		this.driver=driverFromBaseClass;
		
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(xpath="//td[text()='Welcome to Adactin Group of Hotels']")
	WebElement welcomeLabel;
	
	
	public void verifyTitle(WebDriver driver,String expTitle)
	{
		
		Assert.assertEquals(driver.getTitle(), expTitle);
	}

}
