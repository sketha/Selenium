package testNG;

import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
@Test (groups={"Progression"}, dependsOnGroups="smoke")
public class Verification {

	
	public void testcase(){
		System.out.println("method with zero parameters");
	}

	
	@Parameters({"Name","Name1"})
	public void testcase(@Optional("dummy") String sample,@Optional("dummy") String sample2){
		System.out.println("method with two parameter");
	}

	
	public void test(){
		System.out.println("method with a different name");
	}

	
	@Parameters({"Name"})
	public void testcase(@Optional("dummy") String sample){
		System.out.println(" Method with one parameter");
	}
	
	@Parameters({"Name","Name1","Name3"})
	public void testcase(@Optional("dummy") String sample,@Optional("dummy") String sample2,@Optional("dummy") String sample3){
		System.out.println("method with three parameter");
	}
}
