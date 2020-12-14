package testNG;

import org.testng.annotations.Test;

public class Preverification {
	@Test (groups={"smoke", "broken"})
	public void testcase001(){
		System.out.println("test case 001 executed");
	}
	@Test(groups="Progression")
	public void testcase002(){
		System.out.println("test case 002 executed");
	}
	@Test(groups={"smoke", "broken"})
	public void testcase003(){
		System.out.println("test case 003 executed");
	}
	@Test(groups="Progression")
	public void testcase004(){
		System.out.println("test case 004 executed");
	}
	@Test(groups="smoke")
	public void testcase005(){
		System.out.println("test case 005 executed");
	}
	@Test(groups="Progression")
	public void testcase006(){
		System.out.println("test case 006 executed");
	}

}
