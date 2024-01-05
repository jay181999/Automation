package testcases;

import java.io.IOException;

import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import base.TestBase;
import pages.LoginPage;
import utility.Screenshot;

public class VerifyLoginPageWithMultipleCredential extends TestBase
{
	LoginPage Login;
	@BeforeMethod
	public void setUp() throws IOException, InterruptedException
	{
		initialization();
		Login=new LoginPage();
	}
	@DataProvider(name="credentials")
	public Object[][] getData()
	{
		return new Object[] []
				{
			{"standard_user","secret_sauce"},//ci,cp
		//	{"standard_user","secret_sauce1"},//ci,wp
		//	{"standard_user1","secret_sauce"},//wi,cp
			//{"standard_user1","secret_sauce1"},//wi,wp
				};
		
		
	}
	@Test(dataProvider = "credentials")
	public void loginToApplicationMultiCredsTest(String un,String Pass)
	{
		SoftAssert s=new SoftAssert();
		String expURL="https://www.saucedemo.com/inventory.html";
		String actURl=Login.loginToApplicationMultiCreds(un, Pass);
		s.assertEquals(actURl, expURL);
		s.assertAll();
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
