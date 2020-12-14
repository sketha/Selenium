package testNG;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class CitySelection {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		driver.get("https://www.planyourjourney.com/bus");
		WebElement From = driver.findElement(By.id("busorigin-auto"));
		From.sendKeys("CHE");
		List<WebElement>  autoCompleteList = driver.findElements(By.xpath("(//ul[@class='ui-autocomplete ui-menu ui-widget ui-widget-content ui-corner-all'])[1]/li"));	        
		for (WebElement individualElement: autoCompleteList){
			if(individualElement.getText().contains("Chennai")){  
				individualElement.click();
				break;
			}
		}
	}
}
