package getMethodFunctionalities;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.firefox.FirefoxDriver;

public class GetMethodFunction {

	public static void main(String[] args) {
		FirefoxDriver driver = new FirefoxDriver();
		driver.get("https://www.google.co.in");
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		driver.manage().window().maximize();
		
		
		// .getCapabilities function
		System.out.println(driver.getCapabilities().getBrowserName());
		System.out.println(driver.getCapabilities().getPlatform());
		System.out.println(driver.getCapabilities().getVersion());
		System.out.println(driver.getCapabilities().isJavascriptEnabled());
		System.out.println(driver.getCapabilities().is("firefox"));
		
		//get attribute
		System.out.println(driver.findElementById("lst-ib").getAttribute("aria-autocomplete"));
		
		driver.findElementById("lst-ib").sendKeys("Sunil");
		
		//get css value
		String ele = driver.findElementById("sblsbb").getCssValue("background-color");
		System.out.println(driver.findElementById("sblsbb").getCssValue("background-color"));
		System.out.println(driver.findElementById("sblsbb").getCssValue("min-width"));
		System.out.println(driver.findElementById("sblsbb").getTagName());
		System.out.println(driver.findElementById("sblsbb").getLocation());
		System.out.println(driver.findElementById("sblsbb").getSize());
	}

}
