package OrageHRM;

import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TestCAse {

	WebDriver driver;
	PageOBjectClass obj;
	
	@BeforeMethod
	void setup()
	{
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(6));
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		driver.manage().window().maximize();

	}
	
	@Test (priority=1, dataProvider = "dp")
	void login(String name, String password) throws InterruptedException
	{	
		obj = new PageOBjectClass(driver);
		obj.inputusername(name);
		obj.inputpassword(password);
		obj.clickbutton();
		Thread.sleep(2000);
		
	    if(obj.logodisplay()==true)
	    {
	    	Assert.assertTrue(true);
	    	
	    }
	    else
	    {
	    	Assert.fail();
	    }
	}
	
	@AfterMethod
	void tearout()
	{
		driver.quit();
	}
	
	@DataProvider(name="dp")
	Object[][] logindata()
	{
		Object[][] data = {
				
				{"Admin","admin12"},
				{"Admin","admin123"},
				{"admin","ADMIN123"}
				};
		return data;
	}
}
