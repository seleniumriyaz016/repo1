package testscripts.regression;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import pages.BasePage;
import pages.HomePage;
import pages.SearchHotelPage;

public class ValidateLoginPOM extends BasePage{
	
	
	@Test
	public void validateLoginPOMTest()
	{
				
		HomePage homePage=new HomePage(driver);
		SearchHotelPage searchHotelPage=new SearchHotelPage(driver);
		
		homePage.login("reyaz009", "reyaz123");
		
		searchHotelPage.verifyTitle(driver,"Adactin.com - Search Hotel");
		
	}

}
