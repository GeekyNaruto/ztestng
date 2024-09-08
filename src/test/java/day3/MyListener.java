package day3;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class MyListener implements ITestListener
{

	public void onStart(ITestContext context) { 
		System.out.println("Test Exuecution started: ");
	  }
	
	
	public void onTestStart(ITestResult result) {
	    System.out.println("Test case started:");
	  }
	
	public void onTestSuccess(ITestResult result) {
	    System.out.println("Test case succeeded");
	  }
	
	public void onTestFailure(ITestResult result) {
		    System.out.println("Test Case Failed");
		  }
	 
	public void onTestSkipped(ITestResult result) {
		    System.out.println("Test Case Skipped");
		  }
	
	public void onFinish(ITestContext context) {
	    System.out.println("Test Execution finished!!");
	  }
}
