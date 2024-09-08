package OrageHRM;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ReportClass implements ITestListener
{

	ExtentSparkReporter sparkreporter;
	ExtentReports extent;
	ExtentTest test;
	
	public void onStart(ITestContext context) {
		
		sparkreporter = new ExtentSparkReporter("C:\\Users\\Arvind singh\\eclipse-workspace\\TestNG\\src\\test\\java\\OrageHRM\\reporting1.html");
		
		sparkreporter.config().setDocumentTitle("Automation-Testing");
		sparkreporter.config().setReportName("Project-HRM");
		sparkreporter.config().setTheme(Theme.STANDARD);
		
		extent = new ExtentReports();
		extent.attachReporter(sparkreporter);
		
		extent.setSystemInfo("Computer Name", "Arvind");
	    extent.setSystemInfo("Environment", "QA");
	    extent.setSystemInfo("Tester Name", "Arvind");
	    extent.setSystemInfo("OS", "Windows10");
	    extent.setSystemInfo("Browser Name", "Chrome");
				
	  }
	
	 
	public void onTestSuccess(ITestResult result) {
               
		test = extent.createTest(result.getName());
		test.log(Status.PASS, "Passed: "+result.getName());
            
		 }
	 
	public void onTestFailure(ITestResult result) {
		test = extent.createTest(result.getName());
		test.log(Status.FAIL, "Failed: "+result.getName());
		test.log(Status.FAIL, "Failed: "+result.getThrowable());
		  }
	 
	public void onTestSkipped(ITestResult result) {
		test = extent.createTest(result.getName());
		test.log(Status.SKIP, "Skipped: "+result.getName());
		  }
	
	public void onFinish(ITestContext context) {
	    extent.flush();
	  }
	
}
