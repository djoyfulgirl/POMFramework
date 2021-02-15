package TestCaseExecution;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import BaseClass.BrowserSetupOne;
import pageobjectory.CreateQuizPage;
import pageobjectory.LoginPage;

public class CreateQuizTest {
	WebDriver driver;
	LoginPage loginpage;
	CreateQuizPage quizpage;
	BrowserSetupOne BS;
	String filepath = System.getProperty("user.dir")+ "\\config\\file.properties";
	File file;
	FileInputStream fileInput;
	Properties prop;


	
	@BeforeMethod
	public void openbrowser() throws InterruptedException, IOException {
		fileInput = new FileInputStream(filepath);
        prop = new Properties();
		prop.load(fileInput);
	    driver = BrowserSetupOne.StartBrowser(prop.getProperty("browserName"),prop.getProperty("url"));

	}
	
	@Test
	public void CreateQuiz() throws InterruptedException, IOException{
		loginpage = new LoginPage(driver);
		Thread.sleep(2000);
		loginpage.loginToPage();
		Thread.sleep(2000);
		quizpage = new CreateQuizPage(driver);
		quizpage.LibraryTab();
		Thread.sleep(2000);
		quizpage.CreateNew();
		Thread.sleep(2000);
	    quizpage.Quiz();
		Thread.sleep(2000);
	}
	
	@AfterMethod
	public void closeBrowser(){
		driver.close();
	}

}
