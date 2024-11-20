package genericUtility;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import objectRepository.HomePage;
import objectRepository.LoginPage;
import objectRepository.WelcomePage;

public class BaseClass {
	public static ExtentReports extreport;
	public static ExtentTest test;
	
	public WebDriver driver;
	public static WebDriver sdriver;
	
	public Javautility jUtil=new Javautility();
	public WebDriverUtility wUtil=new WebDriverUtility();
	public FileUtility fUtil=new FileUtility();
	public ExcelUtility eUtil=new ExcelUtility();
	
	public HomePage hp;
	public LoginPage lp;
	public WelcomePage wp;
	@BeforeSuite
	public void reportConfig()
	{
		ExtentSparkReporter spark=new ExtentSparkReporter("./HTML_report/extentReport"+jUtil.getSystemTime()+".png");
		ExtentReports extreport=new ExtentReports();
		extreport.attachReporter(spark);	
	}
	@Parameters("Browser")
	@BeforeClass
	public void launchBrowser(@Optional("chrome") String browserName) throws IOException
	{
		if(browserName.equalsIgnoreCase("chrome"))
			driver=new ChromeDriver();
		else if(browserName.equalsIgnoreCase("firedox"))
			driver=new FirefoxDriver();
		else if(browserName.equalsIgnoreCase("edge"))
			driver=new EdgeDriver();
		sdriver=driver;
		wUtil.maximizeWindow(driver);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
			driver.get(fUtil.getDataFromProperty("url"));			
	}
	@BeforeMethod
	public void login() throws IOException
	{
		wp=new WelcomePage(driver);
		wp.getLoginLink();
		lp=new LoginPage(driver);
		lp.getEmailTextField().sendKeys(fUtil.getDataFromProperty("email"));
		lp.getPasswordTextField().sendKeys(fUtil.getDataFromProperty("password"));
		lp.getLoginButton().click();
	}
	@AfterMethod
	public void logout()
	{
		hp=new HomePage(driver);
		hp.getLogoutLink().click();
	}
	@AfterClass
	public void closeBrowser()
	{
		driver.quit();
	}
@AfterSuite
public void reportBackup()
{
	extreport.flush();
}
}
