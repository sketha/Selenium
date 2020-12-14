package samplePrograms;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.firefox.FirefoxDriver;

public class Validation {

	public static void main(String[] args) throws InterruptedException {
		FirefoxDriver driver = new FirefoxDriver();
		driver.get("https://www.flipkart.com/footwear/~mens-and-womens-footwear-/pr?p%5B%5D=facets.discount_range%255B%255D%3D40%2525%2B-%2B50%2525&p%5B%5D=facets.discount_range%255B%255D%3DMore%2Bthan%2B50%2525&sid=osp&otracker=hp_banner_widget_0");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		Thread.sleep(3000);
		System.out.println(driver.findElementByXPath("//*[contains(text(),'Oricum CAMRO-397 Running Shoes')]/ancestor::div[1]").getAttribute("class"));

	}

}
