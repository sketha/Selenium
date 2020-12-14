package opentaps.contact;

import org.testng.annotations.Test;

import demoTestNG.wrappers.OpentapsWrappers;


public class MergeContact extends OpentapsWrappers {
	
	@Test
	public void mergeContact() throws Exception{
		clickByLink("Contacts");
		clickByLink("Merge Contacts");
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
		clickByLink("Find Contacts");
		enterByXpath("//label[contains(text(),'Contact ID:')]/following::input", sText);
		clickByXpath("//button[contains(text(),'Find Contacts')]");
		verifyTextContainsByXpath("//div[@class='x-paging-info']", "No records to display");
			
	}

}
