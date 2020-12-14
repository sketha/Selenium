package stalereference;

import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class StaleReferenceHandling {

	public void waitForTheElement(WebDriver driver, WebElement element, int maxAttempts){
		boolean visibilityFlag = false;
		int attempt=0;
		while(attempt<=maxAttempts)
		{
			try {
				visibilityFlag= element.isDisplayed();
				if(visibilityFlag){
					break;
				}
			} catch (StaleElementReferenceException e) {

				System.out.println(attempt+" : Failed");
			}
			attempt++;
		}
	}
}
