package testNG;

import org.testng.annotations.DataProvider;

public class DataStation {
	@DataProvider(name="datasource", parallel=true)
	public static Object[][] testDataSource(){
		Object[][] data = new Object[3][2];
		data[0][0]="Sunil"; 	data[0][1]="ketha";
		data[1][0]="Gopinath";  data[1][1]="Jayakumar";
		data[2][0]="Babu"; 		data[2][1]="Manickam";
		return data;
		
	}
}
