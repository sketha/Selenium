package samplePrograms;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FacebookProblem {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("http://www.jobserve.com/in/en/changecountry.aspx");
		Thread.sleep(2000);				
		List<WebElement> countryList = driver.findElementsByXPath("//div[@id='CountryContainer']/div");
		int i=1;
		for (WebElement country : countryList) {
			if(i%2==0){
				List<WebElement> continentWiseCountry = driver.findElementsByXPath("//div[@id='CountryContainer']/div["+i+"]/ul/li");
				for (WebElement webElement : continentWiseCountry) {
					System.out.println(webElement.getText());
				}
				System.out.println("The number of countries are :"+continentWiseCountry.size());
			}
			else{
				System.out.println("The name of the Continent is :"+country.getText());
			}
			i++;
		}}}
