package testcases;


import static org.testng.Assert.assertEquals;

import java.io.IOException;

import org.apache.hc.core5.util.Asserts;
import org.apache.poi.EncryptedDocumentException;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.TestBase;
import dev.failsafe.internal.util.Assert;
import pages.Inventory_page;
import pages.LoginPage;
import utility.ReadData;
import utility.Screenshot;

public class Inventory_Page_Test extends TestBase
{
	LoginPage Login;
	Inventory_page invent;
	@BeforeMethod
	public void setUp() throws IOException, InterruptedException
	{
		initialization();
		Login=new LoginPage();
		invent =new Inventory_page();
		Login.loginToApplication();
	}
	
	
	@Test
	public void verifyLableproductLableTest() throws EncryptedDocumentException, IOException
	{
		String expLable=ReadData.readexcel(0,3);
		String actLable=invent.verifyLableproductLable();
		assertEquals(expLable,actLable);
	}
	@Test
	public void verifyTwitterlogoTest()
	{
		Boolean result=invent.verifyTwitterlogo();
		assertEquals(result,true);
		Reporter.log("visibility of twitter logo"+result);
	
	}
	@Test
	public void verifyFacebookiconTest() 
	{
		Boolean result=invent.verifyFacebookicon();
		assertEquals(result,true);
		Reporter.log("visibility of facebooklogo"+result);
	}
	@Test
	public void verifyLinkdiniconTest()
	{
		Boolean result=invent.verifyLinkdinicon();
		assertEquals(result,true);
	}
	
	@Test
	public void add6ProductTest() throws EncryptedDocumentException, IOException
	{
		String Expcount=ReadData.readexcel(0,4);
		String actcount=invent.add6Product();
		assertEquals(Expcount,actcount);
		Reporter.log("total product in cart "+actcount);
		
	}
	@Test
	public void remove2productTest() throws EncryptedDocumentException, IOException
	{
		String Expcount=ReadData.readexcel(0,5);
		String Actcount=invent.remove2product();
	assertEquals(Expcount,Actcount);
	Reporter.log("number of product after removing=" +Actcount);
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
