package testngExamples;

import org.testng.annotations.Test;



import org.testng.annotations.BeforeMethod;

import java.io.IOException;

import org.testng.annotations.AfterMethod;

public class Edit_Merge_Leads extends CreateLead {
 
	
  @Test(dependsOnMethods = "createLead",timeOut=10000,description = "editLead" )
	public void editLead() throws IOException {

		clickbyXpath("(//a[@href='/crmsfa/control/findLeads'])");
		// Finding lead by entering first name and clicking on FindLeads button
		enterByTextXpath("(//input[@name='firstName'])[3]", "shy");
		clickbyXpath("//button[contains(text(),'Find Leads')]");
		// Selecting the first input in the given list
		clickbyXpath("(//a[@class='linktext'])[4]");
		// Verifying title
		verifyTitle("Find Leads | opentaps CRM");
		// Editing the details of Lead
		clickbyXpath("//a[contains(text(),'Edit')]");
		// Change the source
		selectByValue_UsingId("addDataSourceForm_dataSourceId", "LEAD_EMPLOYEE");
		// Click Add
		clickbyXpath("(//input[@value='Add'])[1]");
		// Change the marketing campaign
		selectbyvisibletext_Byid("addMarketingCampaignForm_marketingCampaignId",
				"Catalog Generating Marketing Campaigns");
		// Click Add
		clickbyXpath("(//input[@value='Add'])[2]");
		// Click Update
		clickbyXpath("(//input[@value='Update'])");
		// Confirm added source
		verifyTextContainsById("viewLead_dataSources_sp", "Employee");
		// Confirm added marketing campaign
		verifyTextContainsById("viewLead_marketingCampaigns_sp", "Catalog Generating Marketing Campaigns");
	}

	@Test(enabled=false,description = "MergeLead")
	public void mergeLead() throws IOException, InterruptedException {

		clickbyLinkText("Merge Leads");
		String window = getParentWindowHandle();
		clickbyXpath("//img[@alt = 'Lookup']");
		switchtowindows();
		enterTextByName("id", "10265");
		clickbyXpath("//button[contains (text(),'Find Leads')]");
		Thread.sleep(3000);
		clickbyXpath("//a[contains (text(),'10265')]");
		Thread.sleep(3000);
		switchWindow(window);
		clickbyXpath("(//img[@alt = 'Lookup'])[2]");
		switchtowindows();
		enterTextByName("id", "10052");
		Thread.sleep(3000);
		clickbyXpath("//button[contains (text(),'Find Leads')]");
		Thread.sleep(3000);
		clickbyXpath("//a[contains (text(),'10052')]");
		switchWindow(window);
		clickbyLinkText("Merge");
		SwitchToAlert();
		AcceptAlert();
		clickbyLinkText("Find Leads");
		enterTextByName("id", "10265");
		clickbyXpath("//button[contains (text(),'Find Leads')]");
		Thread.sleep(10000);
		verifyTextEqualsByXpath("//div[@class='x-paging-info']", "No records to display");
	}


}
