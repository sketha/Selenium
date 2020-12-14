package advancedUserInteractions;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class SelectDropDown {

	public static void main(String[] args) {
		//System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		FirefoxDriver driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("https://accounts.google.com/SignUp?hl=en-GB");
		WebElement month = driver.findElementByXPath("//span[@id='BirthMonth']/div");
		Actions builder = new Actions(driver);
		builder.clickAndHold(month).moveByOffset(0, 10).release(month).build().perform();
		
	}

}
