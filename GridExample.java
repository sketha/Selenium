package apachePOI;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

public class GridExample {
	
	@Test
	public void samplevalidation() throws MalformedURLException{
		//http://10.229.192.73:4444/grid/register/
		//URL url = new URL("http://10.229.192.73:4444/grid/wd/hub");
		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setBrowserName("chrome");
		cap.setPlatform(Platform.ANY);
		RemoteWebDriver driver = new RemoteWebDriver(new URL("http://10.229.192.73:5521/grid/wd/hub"), cap);
		
		
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
