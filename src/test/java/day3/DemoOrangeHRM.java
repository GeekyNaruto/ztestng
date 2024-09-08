package day3;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class DemoOrangeHRM {
	
	WebDriver driver;
	
	@BeforeClass
	void setup() throws InterruptedException
	{
		driver=new ChromeDriver();
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		driver.manage().window().maximize();
		Thread.sleep(2000);
		
	}
	
	@Test (priority=1)
	void testlogo()
	{
		boolean logo = driver.findElement(By.xpath("//img[@alt='company-branding']")).isDisplayed();
		Assert.assertEquals(logo, true);
	}
	
	@Test (priority=2)
	void testAppUrl()
	{
		String url = driver.getCurrentUrl();
		Assert.assertEquals(url, "https://orangeHRM.com");
	}
	
	@Test (priority=3, dependsOnMethods= {"testAppUrl"})
	void TestHomePageTitle()
	{
		String title = driver.getTitle();
		Assert.assertEquals(title, "OrangeHRM");
	}
	
	@AfterClass 
	void tearoff()
	{
		driver.quit();
	}

}
