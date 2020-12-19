package listners;


import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import pages.BasePage;

public class MyTestNGListners extends BasePage implements ITestListener {

	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		
	}
		

	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		
		
		
		
		
	}

	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		
		String testName=result.getMethod().getMethodName();
		
		test=extent.createTest(testName);
		
		String pattern = "yyyy-MM-dd HH:mm:ss";
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);

		String date = simpleDateFormat.format(new Date());
		date=date.replace(":", "-");
		System.out.println(date);
		
		
		test.fail(result.getThrowable());
		
		System.out.println(testName);
		
		File srcDir=new File(System.getProperty("user.dir")+"\\screenshots");
		
		srcDir.mkdir();
		
		
		File srcFile= ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		
		String dirPath=System.getProperty("user.dir")+"\\screenshots\\";
		
		String imgPath=dirPath+testName+date+".png";
		
		File destFile=new File(imgPath);
		
		
		test.addScreenCaptureFromPath(imgPath);
		
		try {
			FileUtils.copyFile(srcFile, destFile);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
				
	}

	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onTestFailedWithTimeout(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

	

	
}
