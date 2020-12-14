package testngExamples;

import org.testng.annotations.Test;



import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;

public class OpenTaps extends WrapperMethods {

	@Test( description = "CreateLead with two diff data", dataProvider = "createlead")
	//invocationCount = 2, threadPoolSize = 2,
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
		// getTextByclassName("tabletext");

		String rt = getTextById("viewLead_companyName_sp").substring(12, 17);

		System.out.println(rt);

	}
	
	@BeforeMethod(description = "Launch the browser")
	public void launchbrowser() {
		launchDriver("http://demo1.opentaps.org/opentaps/control/main", "chrome");
	}

	@BeforeMethod(description = "Login to OpenTaps and Click CRM/SFA")
	public void logins(){
		login_opentaps();

	}

	/*@Test(enabled = false, description = "MergeLead")
	public void mergeLead() {
		System.out.println("Firefox: Clicked on Leads tab and Merge lead is performed");
	}

	@Test(dependsOnMethods = "createLead", timeOut = 1000, description = "editLead")
	public void editLead() {
		System.out.println("Firefox: Clicked on Leads tab and edit lead is performed");
	}

	

	@AfterMethod(alwaysRun = true, description = "Logout Close Browser")
	public void afterMethod() {
		System.out.println("Loggedout and browser is closed");

	}*/

	@DataProvider(name = "createlead")
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
}
