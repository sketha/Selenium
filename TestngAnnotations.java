package testngExamples;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.BeforeSuite;

public class TestngAnnotations {
 
  @BeforeTest(description = "Before Test")
  public void beforeTest() {
	  System.out.println("I am in Before Test");
	  
  }

  @BeforeSuite(description = "Before Suite")
  public void beforeSuite() {
	  System.out.println("I am in Before Suite");
  }

}
