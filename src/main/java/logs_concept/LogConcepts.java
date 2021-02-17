package logs_concept;

import org.apache.log4j.xml.DOMConfigurator;
import org.testng.annotations.*;


public class LogConcepts {

	
	
	@BeforeMethod
	public void OpenBrowser() throws InterruptedException {
		
		//DOMConfigurator is Used: this class is used for reading configuration files.
		//configure(Element element)
        //Configure log4j using a configuration element as defined in the log4j.dtd.
		//to read log4j.xml
		
		DOMConfigurator.configure("C:\\Users\\hp\\workspace\\POMFramework_Concepts\\src\\main\\java\\logs_concept\\log4j.xml");
		log.startTestCase("Starting Execution");
		log.info("Chrome Opened"); 
	}
	
	@Test(priority = 1, enabled = true )
	public void testcaseone() throws InterruptedException {
		log.info("testcaseone");
	}

	@Test(priority = 2, enabled = true )
	public void testcasetwo() throws InterruptedException {
		log.info("testcasetwo");
	}
	
	@AfterMethod
	public void TearDown() {
		log.info("Closing the Browser");
	}
}