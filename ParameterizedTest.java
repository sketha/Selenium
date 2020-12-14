package testNG;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class ParameterizedTest {
	@Test(dataProvider = "Name")
	public void parameterIntTest(String UserName, String pwd) {
		System.out.println("UserName: " + UserName+", Password: "+pwd);
	}

	@DataProvider(name = "Name")
	public Object[][] parameterIntArrayTestProvider1() {

		Object[][] data = new Object[3][2];

		data[0][0] = "Bharath";
		data[0][1] = "Karthik";
		data[1][0] = "Thanga";
		data[1][1] = "Senthil";
		data[2][0] = "Thanga";
		data[2][1] = "Senthil";
		return data;
	}

}















