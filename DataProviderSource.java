package testNG;

import org.testng.annotations.DataProvider;

public class DataProviderSource {
	@DataProvider(name="DataSource")
	public static Object[][] dataUtilis(){
		Object[][] data = new Object[2][2];
		
		data [0][0]="Sunil";
		data[0][1]="Kumar";
		
		data [1][0]="Gopinath";
		data[1][1]="Kumar";
		
		
		return data;
		
	}

}
