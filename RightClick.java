package advancedUserInteractions;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class RightClick {

	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver",".\\drivers\\chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://drive.google.com/drive/my-drive");
		driver.manage().window().maximize();
		driver.findElementById("Email").sendKeys("sunilkumarketha");
		driver.findElementById("next").click();
		Thread.sleep(3000);
		driver.findElementById("Passwd").sendKeys("");
		driver.findElementById("signIn").click();
		Thread.sleep(7000);
		
		WebElement space = driver.findElementByClassName("l-u-o-ja-Dc");
		Actions builder = new Actions(driver);
		builder.contextClick(space)/*sendKeys(Keys.DOWN)
		.sendKeys(Keys.DOWN)
		.sendKeys(Keys.DOWN)
		.sendKeys(Keys.DOWN)
		.sendKeys(Keys.DOWN)
		.sendKeys(Keys.ENTER)*/
		.keyDown(Keys.DOWN)
		.keyUp(Keys.DOWN)
		.keyDown(Keys.DOWN)
		.keyUp(Keys.DOWN)
		.keyDown(Keys.DOWN)
		.keyUp(Keys.DOWN)
		.keyDown(Keys.DOWN)
		.keyUp(Keys.DOWN)
		.keyDown(Keys.DOWN)
		.keyUp(Keys.DOWN)
		.keyDown(Keys.DOWN)
		.keyUp(Keys.DOWN)
		.keyDown(Keys.DOWN)
		.keyUp(Keys.DOWN)
		.keyDown(Keys.ENTER)
		.keyUp(Keys.ENTER)
		.build().perform();

	}

}
