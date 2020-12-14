package testNG;

import org.testng.annotations.Test;

public class SampleTC1 {
	@Test (dependsOnMethods="testNG.AttributesVerfi.verification")
	public void Testcase(){
		System.out.println("Successfully");
	}

}
