package samplePrograms;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Keys;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class IRCTC {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver","./drivers/chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		driver.get("https://www.irctc.co.in/eticketing/userSignUp.jsf");
		Select dp = new Select(driver.findElementById("userRegistrationForm:countries"));
		dp.selectByVisibleText("India");
		
		Thread.sleep(3000);
		driver.findElementById("userRegistrationForm:pincode").sendKeys("600041");
		Thread.sleep(2000);
		driver.findElementById("userRegistrationForm:area").click();
		Thread.sleep(3000);
		
		Select dp1 = new Select(driver.findElementById("userRegistrationForm:cityName"));
		dp1.selectByVisibleText("Chennai");
	}

}
