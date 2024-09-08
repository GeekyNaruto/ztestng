package day3;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ReportMaker implements ITestListener
{
 
	public ExtentSparkReporter sparkreporter;   //UI of the report
	public ExtentReports extent;                //populate common info to the report
	public ExtentTest test;     // creating test case entries in the report and u[date status of the test methods
	
	public void onStart(ITestContext context) {
	 
	 sparkreporter = new ExtentSparkReporter(System.getProperty("user.dir")+"/reports/myreport1.html");
	
	 sparkreporter.config().setDocumentTitle("Automation Testing"); 
	 sparkreporter.config().setReportName("OrangeHRM"); 
	 sparkreporter.config().setTheme(Theme.DARK); //
	
     extent = new ExtentReports();
     extent.attachReporter(sparkreporter);
     
     extent.setSystemInfo("Computer Name", "Arvind");
     extent.setSystemInfo("Environment", "QA");
     extent.setSystemInfo("Tester Name", "Arvind");
     extent.setSystemInfo("OS", "Windows10");
     extent.setSystemInfo("Browser Name", "Chrome");
	}
	
	
	public void onTestSuccess(ITestResult result) {
	    
		test = extent.createTest(result.getName());  //create an entry in the report
		test.log(Status.PASS, "Test Case Passed is: "+result.getName());
		
	  }
	
	
	public void onTestFailure(ITestResult result) {
		test = extent.createTest(result.getName());
		test.log(Status.FAIL, "Test Case Failed is: "+result.getName());
		test.log(Status.FAIL, "Test Case Failed casuse is : "+result.getThrowable());
	  }
	
	public void onTestSkipped(ITestResult result) {
		test = extent.createTest(result.getName());    
		test.log(Status.SKIP, "Test Case Skipped: "+result.getName());
	  }
	
	public void onFinish(ITestContext context) {
	    extent.flush();
	  }	
	
}
