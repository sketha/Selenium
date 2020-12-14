package testNG;

import org.testng.annotations.Test;

public class Sample2 {
	@Test (dependsOnMethods={"testNG.SampleTC1.Testcase"})
	public void testcase02(){
		System.out.println(" working on");
	}

}
