package testNG;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class LookupField {

	public static void main(String[] args) {
		 WebDriver driver = new FirefoxDriver();
	        driver.get("http://www.cleartrip.com/");
	        driver.manage().window().maximize();
	        WebElement From = driver.findElement(By.id("FromTag"));
	        From.sendKeys("CHE");
	        WebElement autoComplete = driver.findElement(By.id("ui-id-1"));
	        
	        List<WebElement> autoCompleteList = autoComplete.findElements(By.className("list"));
	        for (WebElement individualElement: autoCompleteList){
	            if(individualElement.getText().contains("Chennai")){  
	            	individualElement.click();
	                break;
	            }
	        }
	        

	}

}
