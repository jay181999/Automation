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
import pages.Inventory_page;
import pages.LoginPage;
import pages.cart_page;
import utility.ReadData;
import utility.Screenshot;

public class cart_Page_Test extends TestBase
{
	LoginPage Login;
	Inventory_page invent;
	cart_page cart;
	@BeforeMethod
	public void setUp() throws IOException, InterruptedException
{
	initialization();
	Login=new LoginPage();
	invent =new Inventory_page();
	cart=new cart_page();
	Login.loginToApplication();
	invent.add6Product();
	invent.clickoncartBtn();
}
	@Test
	public void verifycartPageURLLableTest() throws EncryptedDocumentException, IOException
	{
		String expURL=ReadData.readexcel(1,0);
		String actURL=cart.verifycartPageURLLable();
		assertEquals(actURL,expURL);
		Reporter.log("Current PAge URL Of The CArt_Page" +actURL);
		
	}
	@Test
	public void verifycartPageLableTest() throws EncryptedDocumentException, IOException
	{
		String ExpLable=ReadData.readexcel(1,1);
		String actLable=cart.verifycartPageLable();
		assertEquals(ExpLable,actLable);
		Reporter.log("Cart Page Lable="+actLable);
	}
	@Test
	public void verifycheckoutButtonTest() throws EncryptedDocumentException, IOException
	{
		String expURL=ReadData.readexcel(1,2);
		String actURL=cart.verifycheckoutButton();
		assertEquals(actURL,expURL);
		Reporter.log("After Clicking Cheakout Button we get ="+actURL);
	}
	@Test
	public void verifyContinueShoppingBtnTest() throws EncryptedDocumentException, IOException
	{
		String ExpURL=ReadData.readexcel(1,3);
		String actURl=cart.verifyContinueShoppingBtn();
		assertEquals(actURl,ExpURL);
		Reporter.log("After Clicking ContinueShopping button we get ="+ actURl);
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
