package genericUtility;

import java.io.File;
import java.io.IOException;
import java.util.Set;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.Select;

public class WebDriverUtility {
	/*public WebDriver driver;//declaring here as global variable instead of  giving as formal argument in every method.
	 public Actions act;
	public WebDriverUtility()
	 {
	 this.driver=driver;
	 act=new Actions(driver);
	 }*/
	/**
	 * This method is used to maximize the window
	 * @param driver
	 */
public void maximizeWindow(WebDriver driver)
{
	driver.manage().window().maximize();
}
/**
 * This method is used to get height and width of the window
 * @param driver
 * @return
 */
public Dimension getSizeOfWindow(WebDriver driver)
{
	return driver.manage().window().getSize();
}
/**
 * This method is used to take screenshot when testScript gets failed
 * @param driver
 * @throws IOException 
 */
public void getScreenshot(WebDriver driver) throws IOException
{
	TakesScreenshot ts=(TakesScreenshot) driver;
	File temp = ts.getScreenshotAs(OutputType.FILE);
	File dest=new File("./Screenshots/FailScreenshot.png");
	FileHandler.copy(temp, dest);
}
/**
 * This method is used to switch from one window to another window
 * @param driver
 */
public void swithToWindow(WebDriver driver)
{
	//Step-1: capture all window ids
	Set<String> allids = driver.getWindowHandles();
	//Step-2: Navigate through all the windows
	for(String id:allids)
	{
		driver.switchTo().window(id);
		String acturl = driver.getCurrentUrl();
		if(acturl.contains(acturl))
			break;
	}
	}
/**
 * This method is used right click on the element
 * @param driver
 */
	
	public void rightClick(WebDriver driver)
	{
		Actions act=new Actions(driver);
		act.contextClick().perform();
	}
	/**
	 * This method is used to click and hold on the webElement
	 * @param driver
	 * @param element
	 */
	public void clickAndHold(WebDriver driver, WebElement element)
	{
		Actions act=new Actions(driver);
		act.clickAndHold(element).perform();
	}
	/**
	 * This method is used to mouseHover on the webElement
	 * @param driver
	 * @param element
	 */
	public void mouseHover(WebDriver driver,WebElement element)
	{
		Actions act=new Actions(driver);
		act.moveToElement(element).perform();
	}
	public void mouseHOver(WebDriver driver,int x,int y)
	{
		Actions act=new Actions(driver);
		act.moveByOffset(x, y).perform();;
	}
	/**
	 * This method is used to drag the element and drop the element
	 * @param element
	 */
	public void dragAndDrop(WebDriver driver,WebElement element)
	{
		Actions act=new Actions(driver);
		act.dragAndDrop(element, element).perform();
	}
	public void doubleClick(WebDriver driver,WebElement element)
	{
		Actions act=new Actions(driver);
		act.doubleClick(element);
	}
	/**
	 * This method is used to switch the frame by index
	 * @param index
	 */
	public void switchToFrame(WebDriver driver,int index)
	{
		driver.switchTo().frame(index);
	}
	/**
	 * This method is used to switch the frame by the framename
	 * @param name
	 */
	public void switchToFrame(WebDriver driver,String name)
	{
		driver.switchTo().frame(name);
	}
	/**
	 * This method is used to switch the frame by using frame element
	 * @param element
	 */
	public void switchToFrame(WebDriver driver,WebElement element)
	{
		driver.switchTo().frame(element);
	}
	/**
	 * This method is used to switch back to the parent frame 
	 */
	public void switchToParentFrame(WebDriver driver)
	{
		driver.switchTo().parentFrame();
	}
	/**
	 * This method is used to select the dropDown or listBox by index
	 * @param element
	 * @param index
	 */
	public void selectByIndex(WebElement element,int index)
	{
		Select s=new Select(element);
		s.selectByIndex(index);
	}
	/**
	 * This method is used to select the dropDown or listBox by value
	 * @param element
	 * @param value
	 */
	public void selectByValue(WebElement element,String value)
	{
		Select s=new Select(element);
		s.selectByValue(value);
	}
	/**
	 * This method is used to select the dropDown or listBox by visiableText
	 * @param element
	 * @param text
	 */
	public void selectByVisibleText(WebElement element,String text)
	{
		Select s=new Select(element);
		s.selectByVisibleText(text);
	}
	/**
	 * This method is used to switch to the alert
	 */
	public void switchToAlert(WebDriver driver) {
	driver.switchTo().alert();
}
	/**
	 * This method is used to switch to the alert and accept the alert or click on OK button on the alert
	 */
	public void switchToAlertAndAccept(WebDriver driver)
	{
		driver.switchTo().alert().accept();
	}
	/**
	 * This method is used to switch to the alert and dismiss the alert or click on cancel button on the alert
	 */
	 
	public void switchToAlertAndDismiss(WebDriver driver)
	{
			driver.switchTo().alert().dismiss();
	 }
	/**
	 * This method is used to switch to the alert and sendData
	 * @param data
	 */
	public void switchToAlertAndSendkeys(WebDriver driver,String data)
	{
		driver.switchTo().alert().sendKeys(data);
	}
	/**
	 * This method is used to switch to the alert and capture the text present on the alert
	 */
	public void switchToAlertAndGetText(WebDriver driver)
	{
		driver.switchTo().alert().getText();
	}
	/**
	 * This method is used to perform click operation on the hidden webElements
	 * @param element
	 */
	public void click(WebDriver driver,WebElement element)
	{
		JavascriptExecutor js=(JavascriptExecutor) driver;
		 js.executeScript("argument[0].click()", element);	
	}
	/**
	 * This method is used to scroll the window by co-ordinates
	 * @param x
	 * @param y
	 */
	public void jsScroll(WebDriver driver,int x,int y)
	{
		JavascriptExecutor js=(JavascriptExecutor) driver;
		js.executeScript("window.scrollBy("+x+","+y+")");
	}
	/**
	 * This method scrolls the window till bottom
	 */
	public void jsScrollTillBottom(WebDriver driver)
	{
		JavascriptExecutor js=(JavascriptExecutor) driver;
		js.executeScript("window.scrollTo(0,document.body.scrollHeight)");
	}
	 }
