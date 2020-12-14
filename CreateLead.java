package opentaps.lead;

import org.testng.annotations.Test;

import demoTestNG.wrappers.OpentapsWrappers;

public class CreateLead extends OpentapsWrappers {
	
	@Test()
	public void createLead() throws Exception{
		clickByLink("Leads");
		clickByLink("Create Lead");
		enterById("createLeadForm_companyName","Qeagle");
		enterById("createLeadForm_firstName", "Gopinath");
		enterById("createLeadForm_lastName", "Jayakumar");		
		selectByIndexUsingId("createLeadForm_dataSourceId", 2);
		selectById("createLeadForm_marketingCampaignId", "Demo Marketing Campaign");
		enterById("createLeadForm_primaryEmail", "gopinath@testleaf.com");
		enterById("createLeadForm_primaryPhoneNumber", "9597704568");
		clickByXpath("//input[@name='submitButton']");
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
