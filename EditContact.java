package opentaps.contact;

import org.testng.annotations.Test;


public class EditContact extends demoTestNG.wrappers.OpentapsWrappers {

	@Test
	public void editContact() throws Exception{
		clickByLink("Contacts");
		clickByLink("Find Contacts");
		enterByXpath("(//label[contains(text(),'First name:')])[3]/following::input[1]", "Gopinath");
		clickByXpath("//button[contains(text(),'Find Contacts')]");
		Thread.sleep(5000);
		clickByXpath("(//a[@class='linktext'])[4]");
		verifyTitle("View Contact | opentaps CRM");
		clickByXpath("//a[contains(text(),'Edit')]");
		enterById("updateContactForm_departmentName", "IT");
		clickByXpath("//input[@class='smallSubmit']");

	}
}
