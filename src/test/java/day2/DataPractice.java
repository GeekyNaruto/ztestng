package day2;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataPractice {

	WebDriver driver;
	
	@BeforeMethod
	void setup()
	{
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://practicetestautomation.com/practice-test-login/");
		driver.manage().window().maximize();
	}
	
	@Test (dataProvider ="dpe")
	void login(String email, String paswd) throws InterruptedException
	{
	 try {
		driver.findElement(By.xpath("//input[@id='username']")).sendKeys(email);
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys(paswd);
		driver.findElement(By.xpath("//button[@id='submit']")).click();
		Thread.sleep(2500);
		
		boolean status = driver.findElement(By.xpath("//strong[contains(text(),'Congratulations student. You successfully logged i')]")).isDisplayed();
		System.out.println(status);
		
			Assert.assertTrue(status);
			System.out.println("Test Case Passed");
		} catch (Exception e) {
		
		       	Assert.fail("Test Case Failedd");
	
	   }	
	}
	
	@AfterMethod 
	void logout()
	{
		driver.quit();
	}
	
	@DataProvider(name="dpe")
	Object[][] logindata()
	{
		Object data[][] = { {"student","password123"},
				{"STUDENT","Password123"},
				{"student","Password123"},
				{"stUDEnt","Password123"},
				{"student","PASSWORD123"},
		        };
		return data;
	}
	
}
