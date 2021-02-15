package pageobjectory;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class CreateQuizPage {
	WebDriver driver;
	
	public CreateQuizPage(WebDriver driver){
	     this.driver = driver;
	     PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//header/nav[1]/section[1]/ul[1]/li[3]/a[1]")
	private WebElement LibraryTab;
	
	public void LibraryTab(){
		LibraryTab.click();
	}
	
	@FindBy(xpath="//a[@id='dropdown-create']")
	private WebElement CreateNew;
	
	public void CreateNew(){
		CreateNew.click();
	}
	
	@FindBy(xpath="//ul[@id='drop1']/li[4]/a")
	private WebElement Quiz;
	
	public void Quiz(){
		Quiz.click();
	}

	public void iframehandle(String value){
		 List<WebElement> iframeCount = driver.findElements(By.tagName("iframe")); 
		    int str = iframeCount.size();
		    System.out.println("Count of Iframe :" + str);
		    
		    for(int i=0;i<str;i++)
		    {
		    	driver.switchTo().frame(i);
		    	WebElement autoOptions= driver.findElement(By.xpath("//input[@id='testTitle']"));
			    autoOptions.sendKeys(value);
		    	break;
		    }
	}
	
	@FindBy(xpath="//body[1]/section[2]/div[2]/div[1]/div[1]/div[2]/div[2]/textarea[1]")
	private WebElement Description;
	
	public void Description(String value){
		Description.sendKeys(value);
		}
	
	@FindBy(xpath="//body[1]/section[2]/div[2]/div[1]/div[2]/ul[1]/form[1]/li[1]/div[2]/div[1]/a[1]")
	private WebElement NoOfAttempts;

	public void NoOfAttempts(){
		NoOfAttempts.click();
	}
	
	@FindBy(xpath="//div[@class='custom dropdown open']/ul/li")
	private List<WebElement> dropdownelement;
	
	public List<WebElement> dropdownelement(){
		return dropdownelement;
	}
	
	public void dropdownlist( List<WebElement> element , String value){
		List<WebElement> dropdownvalues = element;
		int count = dropdownvalues.size();
		System.out.println("count : " +  count);
		
		for(int i=0;i<count;i++){
			System.out.println(dropdownvalues.get(i).getText());
			if(dropdownvalues.get(i).getText().equals(value)){
				dropdownvalues.get(i).click();
				break;
			}
		}
	}
	
	@FindBy(xpath="//body[1]/section[2]/div[2]/div[1]/div[2]/ul[1]/form[1]/li[2]/div[2]/div[1]/div[2]/div[1]/a[2]")
	private WebElement Timelimit;

	public void Timelimit(){
		Timelimit.click();
	}
	
	@FindBy(xpath="//div[@class='custom dropdown test-time-limite open']/ul/li")
	private List<WebElement> timelimitdropdown;
	
	public List<WebElement> timelimitdropdown(){
		return timelimitdropdown;
	}
	
	public void timelimit( List<WebElement> element , String value){
		List<WebElement> dropdownvalues = element;
		int count = dropdownvalues.size();
		System.out.println("count : " +  count);
		
		for(int i=0;i<count;i++){
			System.out.println(dropdownvalues.get(i).getText());
			if(dropdownvalues.get(i).getText().equals(value)){
				dropdownvalues.get(i).click();
				break;
				
				
			}
		}
	}
}

      
      