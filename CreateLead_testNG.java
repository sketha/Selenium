package testngExamples;

import org.testng.annotations.Test;



import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import java.io.IOException;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;

public class CreateLead extends WrapperMethods {

	@Test( description = "CreateLead with two diff data", dataProvider = "createlead",timeOut=70000)
	// , threadPoolSize = 2,,invocationCount = 2, ,, invocationTimeOut=70000, 
	public void createLead(String CompName, String firstname, String Lastname, String phoneno, String email) {
		
		clickbyLinkText("Create Lead");
		enterTextById("createLeadForm_companyName", CompName);

		enterTextById("createLeadForm_firstName", firstname);
		enterTextById("createLeadForm_lastName", Lastname);
		selectbyvisibletext_Byid("createLeadForm_dataSourceId", "Conference");
		selectbyindex_Byid("createLeadForm_marketingCampaignId", 2);
		enterTextById("createLeadForm_primaryPhoneNumber", phoneno);

		enterTextById("createLeadForm_primaryEmail", email);

		clickByClassName("smallSubmit");
		

		String rt = getTextById("viewLead_companyName_sp").substring(12, 17);

		System.out.println(rt);
		System.out.println(Thread.currentThread().getId());
		

	}
	
	@DataProvider(name = "createlead" )
	//,  parallel = true
	public Object[][] getData() {
		Object[][] data = new Object[2][5];
		data[0][0] = "Cafefills";
		data[0][1] = "Govindaraja";
		data[0][2] = "J";
		data[0][3] = "9841777788";
		data[0][4] = "Test@gmail.com";
		data[1][0] = "Alphencafefills";
		data[1][1] = "Raj";
		data[1][2] = "J";
		data[1][3] = "9841555666";
		data[1][4] = "test1@gmail.com";
		return data;

	}
	@Parameters("browser")
	@BeforeMethod(description = "Launch the browser")
	
	public void launchbrowser(String browser) throws Exception {
		launchDriver("http://demo1.opentaps.org/opentaps/control/main",browser );
		
		login_opentaps();
	
	}

	
	@AfterMethod(description = "Close browser" )
	public void closebrowser() {
		closeBrowser();
	}

	

	
}

