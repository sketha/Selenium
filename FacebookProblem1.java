package samplePrograms;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class FacebookProblem1 {


	public static void main(String[] args) throws InterruptedException {
		//System.setProperty("webdriver.gecko.driver", "./drivers/geckodriver.exe");
		//System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		FirefoxDriver driver = new FirefoxDriver();
		//ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("https://accounts.google.com/SignUp?hl=en-GB");
		WebElement element = driver.findElementByXPath("//div[contains(text(),'Month')]");
		Actions builder = new Actions(driver);
		builder.clickAndHold(element).sendKeys("February").sendKeys(Keys.ENTER).release(element).build().perform();
	}

}


