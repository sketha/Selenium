package testNG;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DummyMethod2 {
//@Parameters({"SN","FN"})
	@Test (dataProvider="DataSource")
	public void callerMethod3(String FN, String SN){
		System.out.println("First Name:" +FN);
		System.out.println("Second Name:" +SN);

	}
	@DataProvider(name="DataSource")
	public Object[][] dataUtilis(){
		Object[][] data = new Object[2][2];
		
		data [0][0]="Sunil";
		data[0][1]="Kumar";
		
		data [1][0]="Gopinath";
		data[1][1]="Kumar";
		
		
		return data;
		
	}
}
