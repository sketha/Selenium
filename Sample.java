package advancedUserInteractions;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class Sample {

	public static void main(String[] args) throws MalformedURLException{
		DesiredCapabilities dc = new DesiredCapabilities();
		dc.setPlatform(Platform.WINDOWS);
		dc.setBrowserName("chrome");
		
		RemoteWebDriver driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), dc);
		
	
		driver.get("http://jqueryui.com/selectable/");
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);

		// Maximize the browser
		driver.manage().window().maximize();


		driver.switchTo().frame(driver.findElementByClassName("demo-frame"));

		// find the first element
		WebElement List1 = driver.findElement(By
				.xpath("//ol[@id='selectable']/li[1]"));

		// find the fourth element
		WebElement List4 = driver.findElement(By
				.xpath("//ol[@id='selectable']/li[4]"));

		Actions builder = new Actions(driver);

		// build() make it single action, when there are more than one action;
		// perform execute the action, so it must
		builder.clickAndHold(List1).clickAndHold(List4).release().build()
		.perform();

	}

}
