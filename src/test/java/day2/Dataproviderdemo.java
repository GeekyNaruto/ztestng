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

public class Dataproviderdemo {
	
	WebDriver driver;
	
	@BeforeMethod
	void openapp() 
	{
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	}
	
	@Test (dataProvider = "dp")
	void login(String email, String passwd) throws InterruptedException
	{
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//input[@placeholder='Username']")).sendKeys(email);
		driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys(passwd);
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		Thread.sleep(2000);
		boolean logo = driver.findElement(By.xpath("//h6[@class='oxd-text oxd-text--h6 oxd-topbar-header-breadcrumb-module']")).isDisplayed();
	    if(logo==true)
	    {
	    	Assert.assertTrue(true);
	    	
	    }
	    else
	    {
	    	Assert.fail();
	    }
		
		
	}
	
	@AfterMethod
	void closeapp()
	{
		driver.close();
	}
	
	@DataProvider(name = "dp")
	Object[][] logindata()
	{
		Object data[][] ={ {"kismis","tototo"},
		                   {"admin","admin123"},
	                  	   {"Admin","admin123"},
		                   {"ADMIN","admin123"},
		                   {"ADMIN","ADMIN123"},
		                 };
		return data;
				
	}
	

}
