package samplePrograms;

import java.io.File;
import java.io.IOException;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.NoSuchWindowException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.Select;

public class GenericWrappers2{
	RemoteWebDriver driver;
	int i=1;
	public void invokeApp(String browser, String url) {
		// TODO Auto-generated method stub
		try {
			if(browser.equalsIgnoreCase("Chrome")){
				System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");	
				driver = new ChromeDriver() ;
			}
			else if(browser.equalsIgnoreCase("Firefox")){
				System.setProperty("webdriver.gecko.driver", "./drivers/geckodriver.exe");	
				driver = new FirefoxDriver() ;
			}
			driver.get(url);
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			takeSnap();
			System.out.println("The browser launched successfully.");
		} catch (WebDriverException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Web Driver Exception");
		}

	}

	 
	public void enterById(String idValue, String data) throws NoSuchElementException {
		// TODO Auto-generated method stub
		
			try {
				driver.findElementById(idValue).sendKeys(data);
				takeSnap();
				System.out.println("The text field is entered with value "+data);
			} catch(NoSuchElementException e)
			{
				e.printStackTrace();
				System.out.println("Element"+idValue+"not found");
			}
			catch (WebDriverException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				System.out.println("Web Driver Exception");
			}
		
		
	}

	 
	public void enterByName(String nameValue, String data) {
		// TODO Auto-generated method stub
		try {
			driver.findElementByName(nameValue).sendKeys(data);
			takeSnap();
			System.out.println("The text field is entered with value "+data);
		} catch (NoSuchElementException e)
		{
			e.printStackTrace();
			System.out.println("Element"+nameValue+"not found");
		}
		catch (WebDriverException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Web Driver Exception");
		}

	}

	 
	public void enterByXpath(String xpathValue, String data) {
		// TODO Auto-generated method stub
		try {
			driver.findElementByXPath(xpathValue).sendKeys(data);
			takeSnap();
			System.out.println("The text field is entered with value "+data);
		} catch (NoSuchElementException e)
		{
			e.printStackTrace();
			System.out.println("Element"+xpathValue+"not found");
		}
		catch (WebDriverException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Web Driver Exception");
		}

	}

	 
	public boolean verifyTitle(String title) {
		// TODO Auto-generated method stub
		boolean flag = false;
		try {
			String title1 = driver.getTitle();
			if (title1.equalsIgnoreCase(title))
				{ 
				flag = true;
				}
				
		} catch (WebDriverException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Web Driver Exception");
		}
		return flag;
		
	}

	 
	public void verifyTextById(String id, String text) {
		// TODO Auto-generated method stub
		try {
			String text1 = driver.findElementById(id).getText();
			if (text1.equalsIgnoreCase(text))
				System.out.println(text+ ": is verified successfully");
			else
				System.out.println(text+ ": is not verified successfully");
		} catch (NoSuchElementException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Element"+id+" not found");
		} catch (WebDriverException e) {
			e.printStackTrace();
			System.out.println("Web Driver not found");
		}
		
		

	}

	 
	public void verifyTextByXpath(String xpath, String text) {
		// TODO Auto-generated method stub
		try {
			String text1 = driver.findElementByXPath(xpath).getText();
			if (text1.equalsIgnoreCase(text))
				System.out.println(text+ ": is verified successfully");
			else
				System.out.println(text+ ": is not verified successfully");
		} catch (NoSuchElementException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Element"+xpath+"not found");
		} catch (WebDriverException e) {
			e.printStackTrace();
			System.out.println("Web Driver not found");
		}

	}

	 
	public void verifyTextContainsByXpath(String xpath, String text) {
		// TODO Auto-generated method stub
		try {
			String text1 = driver.findElementByXPath(xpath).getText();
			if (text1.contains(text))
				System.out.println(text+ ": is verified successfully");
			else
				System.out.println(text+ ": is not verified successfully");
		} catch (NoSuchElementException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Element"+xpath+"not found");
		} catch (WebDriverException e) {
			e.printStackTrace();
			System.out.println("Web Driver not found");
		}

	}

	 
	public void verifyTextContainsById(String id, String text) {
		// TODO Auto-generated method stub
		try {
			String text1 = driver.findElementById(id).getText();
			if (text1.contains(text))
				System.out.println(text+ ": is verified successfully");
			else
				System.out.println(text+ ": is not verified successfully");
		} catch (NoSuchElementException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Element"+id+"not found");
		} catch (WebDriverException e)
		{
			e.printStackTrace();
			System.out.println("Web Driver not found");
		}

	}

	 
	public void clickById(String id) {
		// TODO Auto-generated method stub
		try {
			driver.findElementById(id).click();
			takeSnap();
			System.out.println(id + "is clicked successfully");
		} catch (NoSuchElementException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Element"+id+"not found");
		} catch (WebDriverException e)
		{
			e.printStackTrace();
			System.out.println("Web Driver not found");
		}

	}

	 
	public void clickByClassName(String classVal) {
		// TODO Auto-generated method stub
		try {
			driver.findElementByClassName(classVal).click();
			takeSnap();
			System.out.println(classVal+ "is clicked successfully");
		} catch (NoSuchElementException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Element"+classVal+"not found");
		} catch (WebDriverException e)
		{
			e.printStackTrace();
			System.out.println("Web Driver not found");
		}
	}

	 
	public void clickByName(String name) {
		// TODO Auto-generated method stub
		try {
			driver.findElementByName(name).click();
			takeSnap();
			System.out.println(name+ "is clicked successfully");
		} catch (NoSuchElementException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Element"+name+"not found");
		} catch (WebDriverException e)
		{
			e.printStackTrace();
			System.out.println("Web Driver not found");
		}

	}

	 
	public void clickByLink(String name) {
		// TODO Auto-generated method stub
		try {
			driver.findElementByLinkText(name).click();
			takeSnap();
			System.out.println("Link "+name+" is clicked sucessfully");
		} catch (NoSuchElementException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Element"+name+"not found");
		} catch (WebDriverException e)
		{
			e.printStackTrace();
			System.out.println("Web Driver not found");
		}

	}

	 
	public void clickByXpath(String xpathVal) {
		// TODO Auto-generated method stub
		try {
			driver.findElementByXPath(xpathVal).click();
			takeSnap();
			System.out.println(xpathVal+ "is clicked successfully");
		} catch (NoSuchElementException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Element"+xpathVal+"not found");
		} catch (WebDriverException e)
		{
			e.printStackTrace();
			System.out.println("Web Driver not found");
		}

	}

	 
	public String getTextById(String idVal) {
		// TODO Auto-generated method stub
		try {
			String x = driver.findElementById(idVal).getText();
			takeSnap();
			System.out.println("The value available in the element with id" +idVal+ "is" +x);
			
		} catch (NoSuchElementException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Element"+idVal+"not found");
		} catch (WebDriverException e) {
			e.printStackTrace();
			System.out.println("Web Driver not found");
		}
		return null;
	}

	 
	public String getTextByXpath(String xpathVal) {
		// TODO Auto-generated method stub
		try {
			String y = driver.findElementByXPath(xpathVal).getText();
			takeSnap();
			System.out.println("The value available in the element with xpath" +xpathVal+ "is" +y);
		} catch (NoSuchElementException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Element"+xpathVal+ "not found");
		} catch (WebDriverException e){
			e.printStackTrace();
			System.out.println("Web Driver not found");
		}
		return null;
	}

	 
	public void selectVisibileTextById(String id, String value) {
		// TODO Auto-generated method stub
		try {
			WebElement dropdown1=driver.findElementById(id);
			Select dd1=new Select(dropdown1);
			dd1.selectByVisibleText(value);
			takeSnap();
			System.out.println("The dropdown is selected with value "+value);
		} catch (NoSuchElementException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
			System.out.println("Element"+id+"not found");
		} catch (WebDriverException e)
		{
			e.printStackTrace();
			System.out.println("Web Driver not found");
		}

	}

	 
	public void selectIndexById(String id, int index) {
		// TODO Auto-generated method stub
		try {
			WebElement dropdown2 = driver.findElementById(id);
			Select dd2 = new Select(dropdown2);
			dd2.selectByIndex(index);
			takeSnap();
			System.out.println("The dropdown with index" +index+ "is selected");
		} catch (NoSuchElementException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Element"+id+"not found");
		} catch (WebDriverException e)
		{
			e.printStackTrace();
			System.out.println("Web Driver not found");
		}
	}

	 
	public void switchToParentWindow() {
		// TODO Auto-generated method stub
		try {
			Set<String> winhan = driver.getWindowHandles();	
			for (String winhanname : winhan) {			
				driver.switchTo().window(winhanname);
				System.out.println("Switched to last window with title" + driver.getTitle());
				takeSnap();
				break;
			}
		} catch (NoSuchWindowException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Window not found");
		} catch (WebDriverException e) {
			e.printStackTrace();
			System.out.println("Web Driver not found");
		}

	}

	 
	public void switchToLastWindow() {
		// TODO Auto-generated method stub
		try {
			Set<String> winhan = driver.getWindowHandles();	
			for (String winhanname : winhan) {			
				driver.switchTo().window(winhanname);
				takeSnap();
				System.out.println("Switched to last window with title" + driver.getTitle());
			}
		} catch (NoSuchWindowException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Window not found");
		} catch (WebDriverException e)
		{
			e.printStackTrace();
			System.out.println("Web Driver not found");
		}
	}

	 
	public void acceptAlert() {
		// TODO Auto-generated method stub
		 try {
			Alert alt = driver.switchTo().alert();
			 takeSnap();
			 alt.accept();
			 System.out.println("Alert accepted");
		} catch (NoAlertPresentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Alert not found");
		} catch (WebDriverException e)
		 {
			e.printStackTrace();
			System.out.println("Web Driver not found");
		 }
	}

	 
	public void closeBrowser() {
		// TODO Auto-generated method stub
		try {
			Set<String> winhan = driver.getWindowHandles();
			int n = winhan.size();
			if (n>1)
				driver.quit();
			else
				driver.close();
			System.out.println("Browser closed successfully");
		} catch (WebDriverException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Web Driver not found");
		}
	

	}

	 
	public void takeSnap() {
		// TODO Auto-generated method stub
		File src = driver.getScreenshotAs(OutputType.FILE);
		File dest = new File("./snaps/snap"+i+".jpg");
		try {
			FileUtils.copyFile(src, dest);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		i++;

	}

}







