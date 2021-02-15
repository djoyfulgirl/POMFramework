package TestCaseExecution;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import BaseClass.BrowserSetupOne;
import junit.framework.Assert;
import pageobjectory.LoginPage;

public class LoginTest {
	WebDriver driver;
	LoginPage loginpage;
	BrowserSetupOne BS;
	String filepath = System.getProperty("user.dir")+ "\\config\\file.properties";
	File file;
	FileInputStream fileInput;
	Properties prop;
	public ExtentHtmlReporter htmlreporter;
	public ExtentReports extent;
	public ExtentTest test;

	@BeforeTest
	public void setextentreport(){
		htmlreporter = new ExtentHtmlReporter(System.getProperty("user.dir")+"\\target\\extendedreport.html");
		htmlreporter.config().setDocumentTitle("Automation Report");
		htmlreporter.config().setReportName("Functionality Report");
		htmlreporter.config().setTheme(Theme.DARK);
		
		extent = new ExtentReports();
		extent.attachReporter(htmlreporter);
		extent.setSystemInfo("OS", "WINDOWS 10");
		extent.setSystemInfo("Test Name", "TAWA");
		extent.setSystemInfo("Browser Name", "Chrome");
		
	}
	
	@AfterTest
	public void endreport(){
		extent.flush();
	}
	
	
	
	
	@BeforeMethod
	public void openbrowser() throws InterruptedException, IOException {
		fileInput = new FileInputStream(filepath);
        prop = new Properties();
		prop.load(fileInput);
	    driver = BrowserSetupOne.StartBrowser(prop.getProperty("browserName"),prop.getProperty("url"));

	}
	
	@Test
	public void TestCase_One() throws InterruptedException, IOException{
		test = extent.createTest("TestCase_One");
		loginpage = new LoginPage(driver);	
		loginpage.loginToPage();
		Assert.assertFalse(true);
		Thread.sleep(2000);
	}
	
	@AfterMethod
	public void tearDown(ITestResult result) throws Exception {
		
		 if (result.getStatus() == ITestResult.FAILURE) {
			   test.log(Status.FAIL, "TEST CASE FAILED IS " + result.getName()); // to add name in extent report
			   test.log(Status.FAIL, "TEST CASE FAILED IS " + result.getThrowable()); // to add error/exception in extent report
			   String screenshotPath = LoginTest.getScreenshot(driver, result.getName());
			   test.addScreenCaptureFromPath(screenshotPath);// adding screen shot
			  } else if (result.getStatus() == ITestResult.SKIP) {
			   test.log(Status.SKIP, "Test Case SKIPPED IS " + result.getName());
			  }
			  else if (result.getStatus() == ITestResult.SUCCESS) {
			   test.log(Status.PASS, "Test Case PASSED IS " + result.getName());
			  }
		    driver.close();
			 }
	
	
	
	public static String getScreenshot(WebDriver driver, String screenshotName) throws IOException {
		  String dateName = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
		  TakesScreenshot ts = (TakesScreenshot) driver;
		  File source = ts.getScreenshotAs(OutputType.FILE);
		  
		  // after execution, you could see a folder "FailedTestsScreenshots" under src folder
		  String destination = System.getProperty("user.dir") + "/Screenshots/" + screenshotName + dateName + ".png";
		  File finalDestination = new File(destination);
		  FileUtils.copyFile(source, finalDestination);
		  return destination;
}
}
