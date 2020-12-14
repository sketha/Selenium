package opentaps.lead;

import org.testng.annotations.Test;

@Test (groups ={"RegTest"})
public class Excercise {
	  @Test(groups = { "functest", "checkintest" })
	  public void testMethod1() {
		  System.out.println("method 1");
	  }
	 
	  @Test(groups = {"functest", "checkintest"} )
	  public void testMethod2() {
		  System.out.println("method2");
	  }
	 
	  @Test(groups = { "Rfunctest" })
	  public void testMethod3() {
		  System.out.println("method3");
	  }
	}
