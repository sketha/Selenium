package testNG;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class ParameterTags {
	@BeforeMethod
	public void gama(){
		System.out.println("write");
	}
	@BeforeMethod
	public void gama2(){
		System.out.println("write2");
	}
	@Test
	@Parameters({"Name","LName"})
	public void validation(@Optional("mysql")String personFirstName, @Optional("DB") String PLastName){
		System.out.println("The name of the person is: "+personFirstName);
		System.out.println("The Last name of the person is: "+PLastName);
		
	}
	
	@Test
	@Parameters({"Name","LName"})
	public void validation1(@Optional("mysql")String personFirstName, @Optional("DB") String PLastName){
		System.out.println("The name of the person is: "+personFirstName);
		System.out.println("The Last name of the person is: "+PLastName);
		
	}

}
