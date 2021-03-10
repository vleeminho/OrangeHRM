package Utility;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestListener;
import org.testng.ITestResult;

import Pages.TestBase;
import io.qameta.allure.Attachment;

public class TestNGListener implements ITestListener {
	
	public static String getTestMethodName(ITestResult result) {
		return result.getMethod().getConstructorOrMethod().getName();
	}
	
	@Attachment
	public byte[] saveScreenshot(WebDriver driver) {
		return (byte[]) ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
	}
	
	@Attachment(value= "{0}",type="text/plain")
	public static String saveTextLog(String message) {
		return message;
	}
	
	 @Override
	 public void onTestFailure(ITestResult result) {
		 
	  
	 }

	 @Override
	 public void onTestSkipped(ITestResult result) {
	  
	  
	 }

	 @Override
	 public void onTestStart(ITestResult result) {
	  
	  
	 }

	 @Override
	 public void onTestSuccess(ITestResult result) {
		 //saveScreenshot(result.getName(),TestBase.driver);
		 Object testClass=result.getInstance();
		 WebDriver driver=TestBase.getDriverInstance();
		 if(driver instanceof WebDriver) {
			 saveScreenshot(driver);
		 }
	  
		 saveTextLog(getTestMethodName(result)+"Passed and screenshot taken!");
	 }
}
