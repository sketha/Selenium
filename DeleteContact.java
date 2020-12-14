package opentaps.contact;

import org.testng.annotations.Test;


public class DeleteContact extends demoTestNG.wrappers.OpentapsWrappers {

	
	@Test
	public void deleteContact() throws Exception{
		clickByLink("Contacts");
		clickByLink("Find Contacts");
		enterByXpath("(//input[@name='firstName'])[3]", "Gopinath");
		clickByXpath("//button[contains(text(),'Find Contacts')]");
		String sText = getTextByXpath("//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a[1]");
		clickByXpath("//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a[1]");		
		clickByLink("Deactivate Contact");
		alertAccept();
		clickByLink("Find Contacts");
		enterByXpath("//label[contains(text(),'Lead ID:')]/following::input", sText);
		clickByXpath("//button[contains(text(),'Find Contacts')]");
		Thread.sleep(3000);
		verifyTextContainsByXpath("//div[@class='x-paging-info']", "No records to display");
	}
	

}
