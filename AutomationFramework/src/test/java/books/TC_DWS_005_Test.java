package books;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import genericUtility.BaseClass;
import genericUtility.ListenerUtility;
import objectRepository.HomePage;
@Listeners(ListenerUtility.class)
public class TC_DWS_005_Test extends BaseClass {
	@Test
	public void clickOnBooks() throws EncryptedDocumentException, IOException
	{
		extreport.createTest("clickOnBooks");
		hp=new HomePage(driver);
		hp.getBooksLink().click();
		Assert.assertNotEquals(driver.getTitle(), eUtil.getStringDataFromExcel("Books",1, 0),"Books page is not displayed");
		test.log(Status.PASS, "Books page is displayed");
	}
	
	/*@Test
	public void clickOnElectronics() throws EncryptedDocumentException, IOException
	{
		extreport.createTest("clickOnElectronics");
		hp=new HomePage(driver);
		hp.getElectronicsLink();
		Assert.assertEquals(driver.getTitle(), eUtil.getStringDataFromExcel("Electronics", 1, 0), "Electronics page is not displayed");
		test.log(Status.PASS, "Electronics page is Displayed");
	}
	@Test
	public void clickOnGiftCardLink() throws EncryptedDocumentException, IOException
	{
		extreport.createTest("clickOnGiftCardLink");
		hp=new HomePage(driver);
		hp.getElectronicsLink();
		Assert.assertEquals(driver.getTitle(), eUtil.getStringDataFromExcel("Electronics", 1, 0), "GiftCard page is not displayed");
		test.log(Status.PASS, "GiftCard page is Displayed");
	}*/
}
