package samplePrograms;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebTableDemo {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://demo.aspnetawesome.com/GridCheckboxesDemo");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		WebElement table = driver.findElementByXPath("(//table[@class='awe-table'])[6]");
		List <WebElement> tableRows = table.findElements(By.tagName("tr"));
		int rowCount = tableRows.size();
		
		for(int i=1;i<=rowCount;i++){
				WebElement trCount =driver.findElementByXPath("(//table[@class='awe-table'])[6]/tbody/tr["+i+"]");
				List <WebElement> colCount = trCount.findElements(By.tagName("td"));
				for (WebElement tdElement : colCount) {
					System.out.print(tdElement.getText()+"   ");
				}
				System.out.println();
		}

	}

}
