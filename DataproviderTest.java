package testNG;

import org.testng.annotations.Optional;
import org.testng.annotations.Test;

public class DataproviderTest {
	@Test(dataProvider="datasource",dataProviderClass=DataStation.class)
	public void displayDPData1(@Optional("asfsa")String FirstName){
		System.out.println("The person with first Name: "+FirstName);
	}
	@Test(dataProvider="datasource",dataProviderClass=DataStation.class)
	public void displayDPData2(String FirstName, String LastName){
		System.out.println("The person with first Name: "+FirstName+" LastName: "+LastName);
	}
	@Test(dataProvider="datasource",dataProviderClass=DataStation.class)
	public void displayDPData3(String FirstName, String LastName){
		System.out.println("The person with first Name: "+FirstName+" LastName: "+LastName);
	}
	@Test(dataProvider="datasource",dataProviderClass=DataStation.class)
	public void displayDPData4(String FirstName, String LastName){
		System.out.println("The person with first Name: "+FirstName+" LastName: "+LastName);
	}

}
