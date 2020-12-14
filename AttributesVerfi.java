package testNG;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import org.testng.annotations.Test;

public class AttributesVerfi {
	@Test (priority=1,expectedExceptions=ArithmeticException.class)
	public void verification() throws InterruptedException{
		String s1="";
		System.out.println("hello");
		//Thread.sleep(1000);
	}
	
	@Test (alwaysRun=true, expectedExceptions=ArithmeticException.class)
	public void verification2() throws Exception{
		System.out.println("hello");
		throw new ArithmeticException();
	}
	@Test (priority=-1)
	public void verification3() throws InterruptedException{
		System.out.println("hello");
		//Thread.sleep(1000);
		
		
	}
}