package advancedUserInteractions;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class Resizable {

	public static void main(String[] args) {
		FirefoxDriver driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.get("http://jqueryui.com/resizable/");
		driver.switchTo().frame(driver.findElementByClassName("demo-frame"));
		WebElement element = driver.findElementByXPath("//*[@id='resizable']/div[3]");
		Actions builder =new Actions(driver);
		builder.clickAndHold(element).moveByOffset(100, 100).release(element).build().perform();

	}

}
