package day1;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class A {

	ExtentReports extentReports;
	ExtentTest test;
	String path = "C:\\Users\\Arvind singh\\eclipse-workspace\\TestNG\\src\\test\\java\\day1\\";
	WebDriver driver;
	
	@BeforeTest
	 void OpenBrowser()
	 {
		extentReports = new ExtentReports(path + "first_test.html");
		test = extentReports.startTest("Test1");
		
		driver = new ChromeDriver();
		driver.get("https://www.google.com");
		driver.manage().window().maximize();
	 }
	
	@Test
	void Verifypage()
	{
		if(driver.getTitle().equals("Google"))
		{
			test.log(LogStatus.PASS, "Test Case Passed");
		}
		else
		{
			test.log(LogStatus.FAIL, "Test Case Failed");
		}
	}
	
	@AfterTest
	void Close()
	{
		extentReports.endTest(test);
		extentReports.flush();
	}
}
