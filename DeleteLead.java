package opentaps.lead;

import org.testng.annotations.Test;

import demoTestNG.wrappers.OpentapsWrappers;


public class DeleteLead extends OpentapsWrappers {

	@Test()
	public void deleteLead() throws Exception{
		clickByLink("Leads");
		clickByLink("Find Leads");
		clickByXpath("//span[contains(text(),'Phone')]");
		enterByName("phoneNumber", "9597704568");
		clickByXpath("//button[contains(text(),'Find Leads')]");
		String sText = getTextByXpath("//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a[1]");
		clickByXpath("//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a[1]");
		clickByLink("Delete");
		clickByLink("Find Leads");
		enterByXpath("//label[contains(text(),'Lead ID:')]/following::input", sText);
		clickByXpath("//button[contains(text(),'Find Leads')]");
		Thread.sleep(3000);
		verifyTextContainsByXpath("//div[@class='x-paging-info']", "No records to display");
	}
	

}
