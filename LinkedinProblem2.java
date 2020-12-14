package samplePrograms;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;
public class LinkedinProblem2 {
	@Test
	public void managePersonFoodLocation() throws InterruptedException, MalformedURLException{
		DesiredCapabilities dc = new DesiredCapabilities();
		dc.setPlatform(Platform.LINUX);
		dc.setBrowserName("firefox");
		
		RemoteWebDriver driver = new RemoteWebDriver(new URL("http://192.168.99.100:5000/wd/hub"), dc);
		driver.manage().window().maximize();
		driver.get("http://demo.aspnetawesome.com/GridCheckboxesDemo");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		System.out.println("Hello Docker");
		for(int j=1;j<=75;j++){
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
					if((tdata.equalsIgnoreCase("Ben"))||(tdata.equalsIgnoreCase("French toast"))||(tdata.equalsIgnoreCase("Restaurant"))){
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

