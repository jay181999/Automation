package testcases;

import static org.testng.Assert.assertEquals;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.TestBase;
import dev.failsafe.internal.util.Assert;
import pages.LoginPage;
import utility.ReadData;
import utility.Screenshot;

public class LoginPageTest extends TestBase

{
	LoginPage Login;
	@BeforeMethod
	public void setUp() throws IOException, InterruptedException
	{
		initialization();
		Login=new LoginPage();
	}
	@Test
	public void verifyTitleOfApplicationTest() throws EncryptedDocumentException, IOException
	{
		String exptTitle=ReadData.readexcel(0,0);
		String ActTitle=Login.verifyTitleOfApplication();
		assertEquals(exptTitle, ActTitle);		
	}
		
	@Test
	public void verifyURLOfApplicationTest() throws EncryptedDocumentException, IOException
	{
		String expURL=ReadData.readexcel(0,1);
		String actURL=Login.verifyURLOfApplication();
		assertEquals(expURL, actURL);
		}
	
	
	
	@Test
	public void loginToApplicationTest() throws IOException
	{
		String expURL=ReadData.readexcel(0,3);
		String actURl=Login.loginToApplication();
		assertEquals(actURl, expURL);
		Reporter.log("After Login Inventory Page Should Be Come="+ actURl);
	}
	
	
	@AfterMethod
	public void closeBrowser(ITestResult it) throws IOException
	{
		if(it.FAILURE==it.getStatus())
		{
			Screenshot.screenshot(it.getName());
		}
		driver.close();
	}

}
