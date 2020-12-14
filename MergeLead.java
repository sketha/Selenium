package opentaps.lead;

import org.testng.annotations.Test;

import demoTestNG.wrappers.OpentapsWrappers;


public class MergeLead extends OpentapsWrappers {
	
	@Test()
	public void mergeLead() throws Exception{
		clickByLink("Leads");
		clickByLink("Merge Leads");
		clickByXpath("(//img[@alt='Lookup'])[1]");
		switchToLastWindow();
		String sText = getTextByXpath("//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a");
		System.out.println(sText);
		clickByXpath("(//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a)[1]");
		switchToPrimary();
		clickByXpath("(//img[@alt='Lookup'])[2]");
		switchToLastWindow();
		clickByXpath("(//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a)[2]");
		switchToPrimary();
		clickByLink("Merge");
		alertAccept();
		clickByLink("Find Leads");
		enterByXpath("//label[contains(text(),'Lead ID:')]/following::input", sText);
		clickByXpath("//button[contains(text(),'Find Leads')]");
		Thread.sleep(3000);
		verifyTextContainsByXpath("//div[@class='x-paging-info']", "No records to display");
			
	}

}
