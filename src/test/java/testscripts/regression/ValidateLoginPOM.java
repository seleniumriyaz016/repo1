package testscripts.regression;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pages.BasePage;
import pages.HomePage;
import pages.SearchHotelPage;

public class ValidateLoginPOM extends BasePage{
	
	
	@Test(dataProvider="getData")
	public void validateLoginPOMTest(String un,String pass)
	{
		//test=extent.createTest("validateLoginPOMTest");
				
		//HomePage homePage=new HomePage(driver);
		
		HomePage hp=PageFactory.initElements(driver, HomePage.class);
		
		hp.login(un, pass);
		
		//SearchHotelPage searchHotelPage=new SearchHotelPage(driver);
		
		SearchHotelPage shp=PageFactory.initElements(driver, SearchHotelPage.class);
		
		//homePage.login("reyaz009", "reyaz133");
		
		shp.verifyTitle(driver,"Adactin.com - Search Hotel");
		
		
		
	}
	
	@DataProvider
	public Object[][] getData() throws IOException
	{
		
		
		FileInputStream f=new FileInputStream("E:\\RamaRao\\FrameworkAutomation\\src\\test\\resources\\testdata\\registration.xlsx");
		
		XSSFWorkbook wb=new XSSFWorkbook(f);
		
		XSSFSheet ws=wb.getSheet("Sheet2");
		
		Object[][] obj=new Object[ws.getLastRowNum()][2];
		
		
		for(int i=0,j=1;i<ws.getLastRowNum();i++)
		{
			obj[i][0]=ws.getRow(j).getCell(0).getStringCellValue();
			obj[i][1]=ws.getRow(j).getCell(1).getStringCellValue();
			j++;
			
		}
		
		
		return obj;
		
		
		
		
	}

}
