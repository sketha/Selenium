package projectDay1;

import java.io.File;
import java.io.IOException;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.UnhandledAlertException;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.Select;



public class GenericWrappersMethods implements Wrappers {

	RemoteWebDriver driver;
	int i=1;
	String getText1;
	Alert alt;
	String s,s1;
	String browserTitle;
	
	public void invokeApp(String browser, String url) {
		try {
			if(browser.equalsIgnoreCase("Chrome")){
				System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
				driver = new ChromeDriver();
			}
			else if(browser.equalsIgnoreCase("Firefox")){
				driver=new FirefoxDriver();
			}
			driver.get(url);
			driver.manage().window().maximize();		
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			System.out.println("The browser: "+browser+" launched successfully.");
		} catch (WebDriverException e) {
			// TODO Auto-generated catch block
			System.out.println("The Browser could not be launched");
		}
		finally{
			takeSnap();
		}
	}

	
	public void enterById(String idValue, String data) {
		// TODO Auto-generated method stub
		try{
			driver.findElementById(idValue).clear();
			driver.findElementById(idValue).sendKeys(data);
			System.out.println("The text field "+idValue+" is entered with text "+data+" successfully.");
		}
		catch (NoSuchElementException e)
		{
			System.out.println("The element with id "+idValue+" is not found");
		}
		catch (WebDriverException e)
		{
			System.out.println("The browser "+driver+" is not found");
		}
		finally{
			takeSnap();	
		}

	}

	
	public void enterByName(String nameValue, String data) {
		// TODO Auto-generated method stub
		try {
			driver.findElementByName(nameValue).clear();
			driver.findElementByName(nameValue).sendKeys(data);
			System.out.println("The text field "+nameValue+" is entered with text "+data+" successfully.");
		} catch (NoSuchElementException e)
		{
			System.out.println("The element with name "+nameValue+" is not found");
		}
		catch (WebDriverException e)
		{
			System.out.println("The browser "+driver+" is not found");
		}
		finally{
			takeSnap();	
		}

	}

	
	public void enterByXpath(String xpathValue, String data) {
		// TODO Auto-generated method stub
		try {
			driver.findElementByXPath(xpathValue).clear();
			driver.findElementByXPath(xpathValue).sendKeys(data);
			System.out.println("The Xpath field "+xpathValue+" is entered with text "+data+" successfully.");
		} catch (NoSuchElementException e)
		{
			System.out.println("The element with xpath "+xpathValue+" is not found");
		}
		catch (WebDriverException e)
		{
			System.out.println("The browser "+driver+" is not found");
		}
		finally{
			takeSnap();	
		}
	}

	
	public boolean verifyTitle(String title) {
		// TODO Auto-generated method stub
		try {
			String titlematch  = driver.getTitle();
			System.out.println("The title of the browser is "+titlematch+"");
			if(titlematch.compareTo(title)== 0){
				System.out.println("The browser title "+titlematch+" matches with given title "+title);

			}else{
				System.out.println("The browser title "+titlematch+" not matched with given title "+title);
			}

		}
		catch (WebDriverException e)
		{
			System.out.println("The browser "+driver+" is not found");
		}
		finally{
			takeSnap();	
		}
		return true;
	}

	
	public void verifyTextById(String id, String text) {
		// TODO Auto-generated method stub
		try {
			String verifytxt = driver.findElementById(id).getAttribute("value");

			if(verifytxt.equals(text)){
				System.out.println("Text value "+verifytxt+" is matched with given text "+text);
			}
			else
			{
				System.out.println("Text value "+verifytxt+" is not matching with given text "+text);
			}


		} 
		catch (NoSuchElementException e)
		{
			System.out.println("The element with id "+id+" is not found");
		}
		catch (WebDriverException e)
		{
			System.out.println("The browser "+driver+" is not found");
		}
		finally{
			takeSnap();	
		}


	}

	
	public void verifyTextByXpath(String xpath, String text) {
		// TODO Auto-generated method stub
		try{
			String verifytxt = driver.findElementByXPath(xpath).getText();
			if(verifytxt.equals(text)){
				System.out.println("Text value "+verifytxt+" is matched with given text "+text);
			}
			else
			{
				System.out.println("Text value "+verifytxt+" is not matching with given text "+text);
			}
		}
		catch (NoSuchElementException e)
		{
			System.out.println("The element with xpath "+xpath+" is not found");
		}
		catch (WebDriverException e)
		{
			System.out.println("The browser "+driver+" is not found");
		}
		finally{
			takeSnap();	
		}
	}
	
	public void verifyTextContainsByXpath(String xpath, String text) {
		// TODO Auto-generated method stub
		// need to modify
		try{
			String verifytxt = driver.findElementByXPath(xpath).getAttribute("value");
			if(verifytxt.equals(text)){
				System.out.println("Text value "+verifytxt+" is matched with given text "+text);
			}
			else
			{
				System.out.println("Text value "+verifytxt+" is not matching with given text "+text);
			}
		}
		catch (NoSuchElementException e)
		{
			System.out.println("The element with xpath "+xpath+" is not found");
		}
		catch (WebDriverException e)
		{
			System.out.println("The browser "+driver+" is not found");
		}
		finally{
			takeSnap();	
		}
	}

	
	public void verifyTextContainsById(String id, String text) {
		// TODO Auto-generated method stub
		try {
			String verifytxt = driver.findElementByXPath(id).getAttribute("value");
			if(verifytxt.equals(text)){
				System.out.println("Text value "+verifytxt+" is matched with given text "+text);
			}
			else
			{
				System.out.println("Text value "+verifytxt+" is not matching with given text "+text);
			}
		}
		catch (NoSuchElementException e)
		{
			System.out.println("The element with id "+id+" is not found");
		}
		catch (WebDriverException e)
		{
			System.out.println("The browser "+driver+" is not found");
		}
		finally{
			takeSnap();	
		}
	}

	
	public void clickById(String id) {
		// TODO Auto-generated method stub
		try{
			driver.findElementById(id).click();
			System.out.println("The element with "+id+" is clicked successfully");
		}
		catch (NoSuchElementException e)
		{
			System.out.println("The element with id "+id+" is not found");
		}
		catch (WebDriverException e)
		{
			System.out.println("The browser "+driver+" is not found");
		}
		finally{
			takeSnap();	
		}
	}

	
	public void clickByClassName(String classVal) {
		// TODO Auto-generated method stub
		try{
			driver.findElementByClassName(classVal).click();
			System.out.println("The element with Classname "+classVal+" is clicked successfully.");
		}
		catch (NoSuchElementException e)
		{
			System.out.println("The element with classname "+classVal+" is not found");
		}
		catch (WebDriverException e)
		{
			System.out.println("The browser "+driver+" is not found");
		}
		finally{
			takeSnap();	
		}
	}

	
	public void clickByName(String name) {
		// TODO Auto-generated method stub
		try{
			driver.findElementByName(name).click();
			System.out.println("The element with name "+name+" is clicked successfully.");
		}
		catch (NoSuchElementException e)
		{
			System.out.println("The element with name "+name+" is not found");
		}
		catch (WebDriverException e)
		{
			System.out.println("The browser "+driver+" is not found");
		}
		finally{
			takeSnap();	
		}
	}

	
	public void clickByLink(String name) {
		// TODO Auto-generated method stub
		try {
			driver.findElementByLinkText(name).click();
			System.out.println("The element with LinkText "+name+" is clicked successfully.");
		}
		catch (NoSuchElementException e)
		{
			System.out.println("The element with linktext "+name+" is not found");
		}
		catch (WebDriverException e)
		{
			System.out.println("The browser "+driver+" is not found");
		}
		finally{
			takeSnap();	
		}

	}
	public void clickByLinkSpecial(String name) {
		// TODO Auto-generated method stub
		try {
			driver.findElementByLinkText(name).click();
			System.out.println("The element with Linktext "+name+" is clicked successfully.");
		}
		catch (NoSuchElementException e)
		{
			System.out.println("The element with linktext "+name+" is not found");
		}
		catch (WebDriverException e)
		{
			System.out.println("The browser "+driver+" is not found");
		}
		finally{
			//takeSnap();	
		}

	}


	
	public void clickByXpath(String xpathVal) {
		// TODO Auto-generated method stub
		try
		{
			driver.findElementByXPath(xpathVal).click();
			System.out.println("The element with Xpath "+xpathVal+" is clicked successfully.");
		}
		catch (NoSuchElementException e)
		{
			System.out.println("The element with xpath "+xpathVal+" is not found");
		}
		catch (WebDriverException e)
		{
			System.out.println("The browser "+driver+" is not found");
		}
		finally{
			takeSnap();	
		}

	}
	public void clickByXpathSpecial(String xpathVal) {
		// TODO Auto-generated method stub
		try
		{
			driver.findElementByXPath(xpathVal).click();
			System.out.println("The element with Xpath "+xpathVal+" is clicked successfully.");
		}
		catch (NoSuchElementException e)
		{
			System.out.println("The element with xpath "+xpathVal+" is not found");
		}
		catch (WebDriverException e)
		{
			System.out.println("The browser "+driver+" is not found");
		}
		

	}

	
	public String getTextById(String idVal) {
		// TODO Auto-generated method stub

		try{
			getText1 = driver.findElementById(idVal).getAttribute("value");
			System.out.println("The Text in element with id "+idVal+ " is "+getText1);

		}
		catch (NoSuchElementException e)
		{
			System.out.println("The element with id "+idVal+" is not found");
		}
		catch (WebDriverException e)
		{
			System.out.println("The browser "+driver+" is not found");
		}
		finally{
			takeSnap();	
		}
		return getText1;
	}
	public String getTextByIdSpecial(String idVal) {
		// TODO Auto-generated method stub

		try{
			getText1 = driver.findElementById(idVal).getText();
			s = getText1;
			System.out.println("The Text in element with id "+idVal+ " is "+s);
			//System.out.println(idVal+ " text value is "+s);

		}
		catch (NoSuchElementException e)
		{
			System.out.println("The element with id "+idVal+" is not found");
		}
		catch (WebDriverException e)
		{
			System.out.println("The browser "+driver+" is not found");
		}
		finally{
			//takeSnap();	
		}
		return s;
	}

	
	public String getTextByXpath(String xpathVal) {
		// TODO Auto-generated method stub
		try{
			String getText1 = driver.findElementByXPath(xpathVal).getText();
			s1 = getText1;
			System.out.println("The Text in element with Xpath "+xpathVal+ " is "+getText1);
			//System.out.println(xpathVal+ "text value is "+getText1);

		}
		catch (NoSuchElementException e)
		{
			System.out.println("The element with xpath "+xpathVal+" is not found");
		}
		catch (WebDriverException e)
		{
			System.out.println("The browser "+driver+" is not found");
		}
		finally{
			takeSnap();	
		}
		return s1;
	}

	
	public void selectVisibileTextById(String id, String value) {
		// TODO Auto-generated method stub
		try {
			WebElement visibletxt = driver.findElementById(id);
			Select txtid = new Select(visibletxt);
			txtid.selectByVisibleText(value);
		}
		catch (NoSuchElementException e)
		{
			System.out.println("The element with id "+id+" is not found");
		}
		catch (WebDriverException e)
		{
			System.out.println("The browser "+driver+" is not found");
		}
		finally{
			takeSnap();	
		}
	}

	
	public void selectIndexById(String id, String value) {
		// TODO Auto-generated method stub
		try {
			WebElement indexbyid = driver.findElementById(id);
			Select indexid = new Select(indexbyid);
			indexid.selectByValue(value);
		}
		catch (NoSuchElementException e)
		{
			System.out.println("The element with id "+id+" is not found");
		}
		catch (WebDriverException e)
		{
			System.out.println("The browser "+driver+" is not found");
		}
		finally{
			takeSnap();	
		}

	}

	
	public void switchToParentWindow() {
		// TODO Auto-generated method stub
		try{
			Set <String> winHandle = driver.getWindowHandles();
			System.out.println("The number of windows open are"+winHandle.size()+"");

			for (String winHandle1 : winHandle) {
				driver.switchTo().window(winHandle1);
				break;
			}
			System.out.println("The control is in parent window");
		}
		catch (NoSuchElementException e)
		{
			System.out.println("The window is not found");
		}
		catch (WebDriverException e)
		{
			System.out.println("The browser "+driver+" is not found");
		}
		finally{
			takeSnap();	
		}
	}

	
	public void switchToLastWindow() {
		// TODO Auto-generated method stub
		try{
			Set <String> winHandle = driver.getWindowHandles();
			System.out.println("The number of windows open are"+winHandle.size()+"");

			for (String winHandle1 : winHandle) {
				driver.switchTo().window(winHandle1);

			}
			System.out.println("The control is in recently opened window");
		}
		catch (NoSuchElementException e)
		{
			System.out.println("The window is not found");
		}
		catch (WebDriverException e)
		{
			System.out.println("The browser "+driver+" is not found");
		}
		finally{
			takeSnap();	
		}

	}

	
	public void acceptAlert() {
		// TODO Auto-generated method stub
		try{
			alt = driver.switchTo().alert();
			alt.accept();
			System.out.println("the alert"+alt+"is accepted");
		}
		catch (NoAlertPresentException e)
		{
			System.out.println("The element "+alt+" is not found");
		}
		catch (UnhandledAlertException e)
		{
			System.out.println("The element "+alt+" is unhandled");
		}
		catch (WebDriverException e)
		{
			System.out.println("The browser "+driver+" is not found");
		}
		finally{
			//takeSnap();	
		}

	}

	
	public void quitBrowser() {
		// TODO Auto-generated method stub
		try
		{
			driver.quit();
			System.out.println("Browser is closed");
		}
		catch (WebDriverException e)
		{
			System.out.println("The browser "+driver+" is not found");
		}
		finally{
			//takeSnap();	
		}


	}


	
	public void takeSnap(){
		// TODO Auto-generated method stub

		File src=driver.getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(src, new File("./snaps/Screenshots"+i+".jpg"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		i++;

	}
	
	public String getBrowserTiltle() {
		try
		{
			browserTitle = driver.getTitle();
			System.out.println("The title of browser is "+browserTitle+"");
		}
		catch (WebDriverException e)
		{
			System.out.println("The browser "+driver+" is not found");
		}
		finally{
			takeSnap();	
		}
		return browserTitle;

	}

}

















