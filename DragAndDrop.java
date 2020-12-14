package advancedUserInteractions;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class DragAndDrop {

	public static void main(String[] args) {
		
		FirefoxDriver driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.get("https://jqueryui.com/droppable/");
		driver.switchTo().frame(driver.findElementByClassName("demo-frame"));
		WebElement draggable=driver.findElementById("draggable");
		WebElement droppable=driver.findElementById("droppable");
		Actions builder = new Actions(driver);
		builder.dragAndDrop(draggable, droppable).build().perform();
		if(droppable.getText().equalsIgnoreCase("Dropped!")){
			System.out.println("Moved Successfully");
		}
		driver.close();
				
	}

}
