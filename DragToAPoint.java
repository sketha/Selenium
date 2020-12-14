package advancedUserInteractions;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

public class DragToAPoint {
	@Test
	public void draggable() throws MalformedURLException{
		DesiredCapabilities dp = new DesiredCapabilities();
		dp.setBrowserName("chrome");
		dp.setPlatform(Platform.WINDOWS);
		
		RemoteWebDriver driver = new RemoteWebDriver(new URL("http://192.168.1.6:4444/wd/hd"),dp);
		
		driver.get("http://jqueryui.com/draggable/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		driver.switchTo().frame(driver.findElementByClassName("demo-frame"));
		WebElement draggable = driver.findElementById("draggable");
		Actions builder = new Actions(driver);
		System.out.println("The old position is: "+draggable.getLocation());
		builder.dragAndDropBy(draggable, 100, 100).build().perform();
		System.out.println("The latest position is: "+draggable.getLocation());
	}
}
