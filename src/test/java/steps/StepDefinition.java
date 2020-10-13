package steps;

import java.util.concurrent.TimeUnit;

import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.junit.Cucumber;
import junit.framework.Assert;

public class StepDefinition {
	WebDriver driver;
	
	
		@Given("I launch bowser and naviagte to application using url {string}")
		public void i_launch_bowser_and_naviagte_to_application_using_url(String url) {
			
	
		driver= new ChromeDriver();
		driver.get(url);
		
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

		@Then("I enter text {string} in textbox using xpath {string}")
		public void i_enter_text_in_textbox_using_xpath(String text, String xpath) {   
    	
    	driver.findElement(By.xpath(xpath)).sendKeys(text);
    	
    	
    }

		@Then("I click on button using xpath for {string}")
		public void i_click_on_button_using_xpath_for(String xpath) {
    
    	driver.findElement(By.xpath(xpath)).click();
    }

		@Then("I verify the title of the page to be {string}")
		public void i_verify_the_title_of_the_page_to_be(String expTitle) {
    
    	Assert.assertEquals(expTitle, driver.getTitle());
    }
		
	
		@Then("I close the browser")
		public void closeBrowser()
		{
			
			driver.quit();
		}

    

}

