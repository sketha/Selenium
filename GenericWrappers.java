package demoTestNG.wrappers;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GenericWrappers {

	public RemoteWebDriver driver;
	protected static Properties prop;
	public String sUrl,primaryWindowHandle,sHubUrl,sHubPort;

	public boolean invokeApp(String browser, String Url) {
		boolean bReturn = false;
		try {

			if(browser.equalsIgnoreCase("chrome")){
				System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
				driver = new ChromeDriver();
			}else
				driver = new FirefoxDriver();

			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			driver.get(Url);

			primaryWindowHandle = driver.getWindowHandle();	
			System.out.println("The browser:" + browser + " launched successfully");
			bReturn = true;

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("The browser:" + browser + " could not be launched");
		}
		return bReturn;
	}

	/**
	 * This method will launch only firefox and maximise the browser and set the
	 * wait for 30 seconds and load the url
	 * @author Babu - TestLeaf
	 * @param url - The url with http or https
	 * 
	 */
	public boolean invokeApp(String browser) {
		boolean bReturn = false;
		try {

			DesiredCapabilities dc = new DesiredCapabilities();
			dc.setBrowserName(browser);
			dc.setPlatform(Platform.WINDOWS);
			if(browser.equalsIgnoreCase("chrome")){
				System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
				driver = new ChromeDriver();
			}else
				driver = new FirefoxDriver();

			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			driver.get(sUrl);

			//			primaryWindowHandle = driver.getWindowHandle();		
			System.out.println("The browser:" + browser + " launched successfully");
			bReturn = true;

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("The browser:" + browser + " could not be launched");
		}
		return bReturn;
	}

	/**
	 * This method will enter the value to the text field using id attribute to locate
	 * 
	 * @param idValue - id of the webelement
	 * @param data - The data to be sent to the webelement
	 * @author Babu - TestLeaf
	 * @throws Exception 
	 * @throws IOException 
	 * @throws COSVisitorException 
	 */
	public boolean enterById(String idValue, String data) throws Exception {
		boolean bReturn = false;
		try {
			driver.findElement(By.id(idValue)).clear();
			driver.findElement(By.id(idValue)).sendKeys(data);	
			System.out.println("The data: "+data+" entered successfully in field :"+idValue);
			bReturn = true;

		} catch (Exception e) {
			System.out.println("The data: "+data+" could not be entered in the field :"+idValue);
			throw new Exception("TC fails");
		}
		return bReturn;
	}


	/**
	 * This method will enter the value to the text field using name attribute to locate
	 * 
	 * @param nameValue - name of the webelement
	 * @param data - The data to be sent to the webelement
	 * @author Babu - TestLeaf
	 * @throws IOException 
	 * @throws COSVisitorException 
	 */
	public boolean enterByName(String nameValue, String data) {
		boolean bReturn = false;
		try {
			driver.findElement(By.name(nameValue)).clear();
			driver.findElement(By.name(nameValue)).sendKeys(data);	
			System.out.println("The data: "+data+" entered successfully in field :");
			bReturn = true;

		} catch (Exception e) {
			System.out.println("The data: "+data+" could not be entered in the field :");
		}
		return bReturn;
	}

	/**
	 * This method will enter the value to the text field using Xpath attribute to locate
	 * 
	 * @param XpathValue - Xpath of the webelement
	 * @param data - The data to be sent to the webelement
	 * @author Babu - TestLeaf
	 * @throws IOException 
	 * @throws COSVisitorException 
	 */
	public boolean enterByXpath(String XpathValue, String data) {
		boolean bReturn = false;
		try {
			driver.findElement(By.xpath(XpathValue)).clear();
			driver.findElement(By.xpath(XpathValue)).sendKeys(data);	
			System.out.println("The data: "+data+" entered successfully in field :"+XpathValue);
			bReturn = true;

		} catch (Exception e) {
			System.out.println("The data: "+data+" could not be entered in the field :"+XpathValue);
		}
		return bReturn;
	}

	/**
	 * This method will verify the title of the browser 
	 * @param title - The expected title of the browser
	 * @author Babu - TestLeaf
	 */
	public boolean verifyTitle(String title){
		boolean bReturn = false;
		try{
			if (driver.getTitle().equalsIgnoreCase(title)){
				System.out.println("The title of the page matches with the value :"+title);
				bReturn = true;
			}else
				System.out.println("The title of the page:"+driver.getTitle()+" did not match with the value :"+title);

		}catch (Exception e) {
			System.out.println("The title did not match");
		}

		return bReturn;
	}

	/**
	 * This method will verify the given text
	 * @param xpath - The locator of the object in xpath
	 * @param text  - The text to be verified
	 * @author Babu - TestLeaf
	 */
	public boolean verifyTextByXpath(String xpath, String text){
		boolean bReturn = false;
		String sText = driver.findElementByXPath(xpath).getText();
		if (driver.findElementByXPath(xpath).getText().trim().equalsIgnoreCase(text)){
			System.out.println("The text: "+sText+" matches with the value :"+text);
			bReturn = true;
		}else{
			System.out.println("The text: "+sText+" did not match with the value :"+text);
		}


		return bReturn;
	}

	/**
	 * This method will verify the given text
	 * @param xpath - The locator of the object in xpath
	 * @param text  - The text to be verified
	 * @author Babu - TestLeaf
	 */
	public boolean verifyTextContainsByXpath(String xpath, String text){
		boolean bReturn = false;
		String sText = driver.findElementByXPath(xpath).getText();
		if (driver.findElementByXPath(xpath).getText().trim().contains(text)){
			System.out.println("The text: "+sText+" contains the value :"+text);
			bReturn = true;
		}else{
			System.out.println("The text: "+sText+" did not contain the value :"+text);
		}


		return bReturn;
	}

	public boolean verifyTextContainsById(String idValue, String text){
		boolean bReturn = false;
		String sText = driver.findElementById(idValue).getText();
		if (driver.findElementById(idValue).getText().trim().contains(text)){
			System.out.println("The text: "+sText+" contains the value :"+text);
			bReturn = true;
		}else{
			System.out.println("The text: "+sText+" did not contain the value :"+text);
		}


		return bReturn;
	}


	/**
	 * This method will close all the browsers
	 * @author Babu - TestLeaf
	 */
	public void quitBrowser() {
		try {
			driver.quit();
		} catch (Exception e) {
			System.out.println("The browser:"+driver.getCapabilities().getBrowserName()+" could not be closed.");
		}

	}

	/**
	 * This method will click the element using id as locator
	 * @param id  The id (locator) of the element to be clicked
	 * @author Babu - TestLeaf
	 */
	public boolean clickById(String id) {
		boolean bReturn = false;
		try{
			driver.findElement(By.id(id)).click();
			System.out.println("The element with id: "+id+" is clicked.");

			bReturn = true;

		} catch (Exception e) {
			System.out.println("The element with id: "+id+" could not be clicked.");
		}
		return bReturn;
	}

	/**
	 * This method will click the element using id as locator
	 * @param id  The id (locator) of the element to be clicked
	 * @author Babu - TestLeaf
	 */
	public boolean clickByClassName(String classVal) {
		boolean bReturn = false;
		try{
			driver.findElement(By.className(classVal)).click();
			System.out.println("The element with class Name: "+classVal+" is clicked.");
			bReturn = true;

		} catch (Exception e) {
			System.out.println("The element with class Name: "+classVal+" could not be clicked.");
		}
		return bReturn;
	}
	/**
	 * This method will click the element using name as locator
	 * @param name  The name (locator) of the element to be clicked
	 * @author Babu - TestLeaf
	 */
	public boolean clickByName(String name) {
		boolean bReturn = false;
		try{
			new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(By.name(name)));

			driver.findElement(By.name(name)).click();
			System.out.println("The element with name: "+name+" is clicked.");

			bReturn = true;

		} catch (Exception e) {
			System.out.println("The element with name: "+name+" could not be clicked.");
		}
		return bReturn;
	}

	/**
	 * This method will click the element using link name as locator
	 * @param name  The link name (locator) of the element to be clicked
	 * @author Babu - TestLeaf
	 * @throws Exception 
	 */
	public boolean clickByLink(String name) throws Exception {
		boolean bReturn = false;
		try{
			new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(By.linkText(name)));
			driver.findElement(By.linkText(name)).click();
			System.out.println("The element with link name: "+name+" is clicked.");

			bReturn = true;

		} catch (Exception e) {
			System.out.println("The element with link name: "+name+" could not be clicked.");
			throw new Exception("Stop the TESt");
		}
		return bReturn;
	}

	/**
	 * This method will click the element using xpath as locator
	 * @param xpathVal  The xpath (locator) of the element to be clicked
	 * @author Babu - TestLeaf
	 */
	public boolean clickByXpath(String xpathVal) {
		boolean bReturn = false;
		try{
			new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(By.xpath(xpathVal)));
			driver.findElement(By.xpath(xpathVal)).click();
			System.out.println("The element : "+xpathVal+" is clicked.");

			bReturn = true;

		} catch (Exception e) {
			System.out.println("The element with xpath: "+xpathVal+" could not be clicked.");
		}
		return bReturn;
	}

	/**
	 * This method will mouse over on the element using xpath as locator
	 * @param xpathVal  The xpath (locator) of the element to be moused over
	 * @author Babu - TestLeaf
	 */
	public boolean mouseOverByXpath(String xpathVal) {
		boolean bReturn = false;
		try{
			new Actions(driver).moveToElement(driver.findElement(By.xpath(xpathVal))).build().perform();
			System.out.println("The mouse over by xpath : "+xpathVal+" is performed.");

			bReturn = true;

		} catch (Exception e) {
			System.out.println("The mouse over by xpath : "+xpathVal+" could not be performed.");
		}
		return bReturn;
	}

	/**
	 * This method will mouse over on the element using link name as locator
	 * @param xpathVal  The link name (locator) of the element to be moused over
	 * @author Babu - TestLeaf
	 */
	public boolean mouseOverByLinkText(String linkName) {
		boolean bReturn = false;
		try{
			new Actions(driver).moveToElement(driver.findElement(By.linkText(linkName))).build().perform();
			System.out.println("The mouse over by link : "+linkName+" is performed.");

			bReturn = true;

		} catch (Exception e) {
			System.out.println("The mouse over by link : "+linkName+" could not be performed.");
		}
		return bReturn;
	}

	public String getTextByXpath(String xpathVal){
		String bReturn = "";
		try{
			bReturn = driver.findElement(By.xpath(xpathVal)).getText();
		} catch (Exception e) {
			System.out.println("The element with xpath: "+xpathVal+" could not be found.");
		}
		return bReturn; 
	}

	/**
	 * This method will select the drop down value using id as locator
	 * @param id The id (locator) of the drop down element
	 * @param value The value to be selected (visibletext) from the dropdown 
	 * @author Babu - TestLeaf
	 */
	public boolean selectById(String id, String value) {
		boolean bReturn = false;
		try{
			new Select(driver.findElement(By.id(id))).selectByVisibleText(value);;
			System.out.println("The element with id: "+id+" is selected with value :"+value);

			bReturn = true;

		} catch (Exception e) {
			System.out.println("The value: "+value+" could not be selected.");
		}
		return bReturn;
	}

	public void loadObjects() throws FileNotFoundException, IOException{
		prop = new Properties();
		prop.load(new FileInputStream(new File("./object.properties")));

	}

	//@Indhu	
	public boolean switchToFrame(String nameOrId) {
		boolean bReturn = false;
		try {
			driver.switchTo().defaultContent();

			bReturn = true;
		} catch (WebDriverException e1) {
		}
		return bReturn;
	}

	public boolean alertAccept(){
		boolean bReturn = false;

		try {
			driver.switchTo().alert().accept();
			bReturn = true;
		} catch (Exception e) {

		}
		return bReturn;

	}

	public String getTextAndAcceptAlert(){
		String sText = "";
		try{
			sText = driver.switchTo().alert().getText();
			alertAccept();
		} catch(Exception e){

		}

		return sText;
	}

	public boolean switchToDefault() {
		boolean bReturn = false;
		try {
			driver.switchTo().defaultContent(); 
			bReturn = true;
		} catch (WebDriverException e1) {
		}
		return bReturn;
	}

	public boolean switchToLastWindow() {


		boolean bReturn = false;
		try {

			Set<String> wHandles = driver.getWindowHandles();
			for (String wHandle : wHandles) {
				driver.switchTo().window(wHandle);				
			}
			bReturn = true;
		} catch (Exception e) {

		}

		return bReturn;

	}

	public boolean switchToPrimary() {
		boolean bReturn = false;
		try {

			driver.switchTo().window(primaryWindowHandle);

			bReturn = true;

		} catch (Exception e) {

		}
		return bReturn;
	}

	public boolean waitUseThread() {
		boolean bReturn = false;
		try {

			Thread.sleep(5000);

			bReturn = true;

		} catch (Exception e) {

		}
		return bReturn;
	}

	public boolean selectByIndexUsingId(String id, int value) {
		boolean bReturn = false;
		try{
			new Select(driver.findElement(By.id(id))).selectByIndex(value);;
			System.out.println("The element with id: "+id+" is selected with value :"+value);

			bReturn = true;

		} catch (Exception e) {
			System.out.println("The value: "+value+" could not be selected.");
		}
		return bReturn;
	}
}

