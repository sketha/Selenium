package advancedUserInteractions;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class HoverActions {

	public static void main(String[] args) throws InterruptedException {
		FirefoxDriver driver = new FirefoxDriver();
		driver.get("https://www.flipkart.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		WebElement element = driver.findElementByXPath("//*[@id='container']/div/header/div[2]/div/ul/li[1]/a/span");
		Actions builder = new Actions(driver);
		
		builder.moveToElement(element).perform();
		Thread.sleep(3000);
		WebElement element2 = driver.findElementByXPath("//*[@id='container']/div/header/div[2]/div/ul/li[1]/ul/li/ul/li[2]/ul/li[12]/a/span");
		builder.click(element2).perform();
		System.out.println("The title of the page:" + driver.getTitle());
	}

}
