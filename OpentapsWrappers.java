package demoTestNG.wrappers;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;


public class OpentapsWrappers extends GenericWrappers {

	@BeforeSuite
	public void connectToDatabase(){
	}

	@BeforeTest
	public void startReport(){
	}

	@BeforeClass
	public void beforeClass(){
	}

	
	@BeforeMethod()
	public void login() throws Exception{
		invokeApp("chrome", "http://demo1.opentaps.org/");
		enterById("username", "DemoSalesManager");
		enterById("password", "crmsfa");
		clickByClassName("decorativeSubmit");	
		clickByLink("CRM/SFA");	
	}

	@AfterMethod()
	public void closeBrowser(){		
		quitBrowser();
	}

	@AfterClass
	public void afterClass(){
	}

	@AfterTest
	public void endReport(){

	}

	@AfterSuite
	public void disconnectDb(){

	}

}
