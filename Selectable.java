package advancedUserInteractions;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class Selectable {

	public static void main(String[] args) {
		FirefoxDriver driver = new FirefoxDriver();
		driver.get("http://jqueryui.com/selectable/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		driver.switchTo().frame(driver.findElementByClassName("demo-frame"));
		Actions builder = new Actions(driver);
		List<WebElement> ls = driver.findElementsByXPath("//*[@id='selectable']/li");
		for (WebElement webElement : ls) {
			System.out.println(webElement.getText());
		}
		WebElement Element1 = driver.findElement(By.xpath("//*[@id='selectable']/li[1]"));
		WebElement Element3 = driver.findElement(By.xpath("//*[@id='selectable']/li[3]"));
		WebElement Element4 = driver.findElement(By.xpath("//*[@id='selectable']/li[4]"));
		
		// when performing the action from Keyword using the help of control Key.
		builder.keyDown(Keys.CONTROL).click(Element1).click(Element3).click(Element4).keyUp(Keys.CONTROL).build().perform();  
		
		//When performing using the mouse event by clicking and Holding the element
		
		builder.clickAndHold(Element1).release(Element4).build().perform();
		
		
	}

}
