package samplePrograms;

import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
public class LinkedinProblem {
	@Test
	public void managePersonFoodLocation() throws InterruptedException{
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://demo.aspnetawesome.com/GridCheckboxesDemo");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		for(int j=75;j<=75;j++){
			int count=0;
			driver.findElementByXPath("//button[contains(text(),'"+j+"')]").click();
			Thread.sleep(3000);
			int RowLength = driver.findElementByXPath("//*[@id='GridChk']/div[3]/div[2]/div/table").findElements(By.tagName("tr")).size();
			for(int i=9;i<=RowLength;i++){
				WebElement ColumnCount = driver.findElementByXPath("//div[@id='GridChk']/div[3]/div[2]/div/table/tbody/tr["+i+"]");
				List<WebElement> tableData = ColumnCount.findElements(By.tagName("td"));
				count=0;
				for (WebElement td : tableData) {
					String tdata =td.getText();
					if((tdata.equalsIgnoreCase("Michael"))||(tdata.equalsIgnoreCase("Sushi"))||(tdata.equalsIgnoreCase("University"))){
						count++;
					}
				}
				if(count==3){
					for (WebElement td2 : tableData) {
						td2.click();
						break;
					}
					break;	
				}
			}
			driver.findElementById("btnGetSelection1").click();
			if(count==3)break;
		}
	}
}

