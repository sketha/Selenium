package opentaps.contact;

import org.testng.annotations.Test;

import demoTestNG.wrappers.OpentapsWrappers;

public class CreateContact extends OpentapsWrappers {

	@Test
	public void createContact() throws Exception{
		clickByLink("Contacts");
		clickByLink("Create Contact");
		enterById("firstNameField", "Gopinath");
		enterById("lastNameField", "Jayakumar");
		clickByName("submitButton");
	}

}
