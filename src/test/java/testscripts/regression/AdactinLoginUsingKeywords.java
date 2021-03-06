package testscripts.regression;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class AdactinLoginUsingKeywords  {
	
	
	@Test(dataProvider="getData")
	public void loginTest(String un,String pass) throws IOException, InterruptedException
	{
		LoginKeywords keys=new LoginKeywords();
		
		FileInputStream f=new FileInputStream("E:\\RamaRao\\FrameworkAutomation\\src\\test\\resources\\testdata\\LoginKeywords.xlsx");
		
		XSSFWorkbook wb=new XSSFWorkbook(f);
		
		XSSFSheet ws=wb.getSheet("Sheet1");
		
		FileInputStream propertiesFile=new FileInputStream("Properties\\elementLocators.properties");
		Properties pr=new Properties();
		pr.load(propertiesFile);
		
		
		Iterator<Row>  rows=ws.iterator();
		
		Row row=null;
		Cell cell=null;
		
		rows.next();
		
		while(rows.hasNext())
		{
			row=rows.next();
			
			String action=row.getCell(3).getStringCellValue();
			
			if(action.equals("launchBrowser"))
			{
				keys.launchBrowser();
			}
			else if(action.equals("navigate"))
			{
				keys.navigate();
			}
			else if(action.equals("enterUsername"))
			{
				keys.enterUsername(pr.getProperty("username_txt"),un);
			}
			else if(action.equals("enterPassword"))
			{
				keys.enterPassword(pr.getProperty("password_txt"),pass);
			}
			else if(action.equals("clickLogin"))
			{
				keys.clickLogin(pr.getProperty("login_button"));
			}
			else if(action.equals("closeBrowser"))
			{
				keys.closeBrowser();
			}
			
			
			
		}
		
		
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
