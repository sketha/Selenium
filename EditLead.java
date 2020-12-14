package opentaps.lead;

import org.testng.annotations.Test;

import demoTestNG.wrappers.OpentapsWrappers;


public class EditLead extends OpentapsWrappers {	

	@Test()
	public void editLead() throws Exception{
		clickByLink("Leads");
		clickByLink("Find Leads");
		enterByXpath("(//input[@name='firstName'])[3]", "Gopinath");
		clickByXpath("//button[contains(text(),'Find Leads')]");
		Thread.sleep(5000);
		clickByXpath("(//a[@class='linktext'])[4]");
		verifyTitle("View Lead | opentaps CRM");
		clickByXpath("//a[contains(text(),'Edit')]");
		selectById("updateLeadForm_industryEnumId", "Computer Software");
		clickByXpath("//input[@class='smallSubmit']");
	}
}
