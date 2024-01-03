package testcases;

import static org.testng.Assert.assertEquals;

import java.io.IOException;

import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.TestBase;
import pages.CheckOut_Page1;
import pages.Inventory_page;
import pages.LoginPage;
import pages.cart_page;
import utility.Screenshot;

public class CheckOut_Page1_Test extends TestBase 
{
	LoginPage Login;
	Inventory_page invent;
	cart_page cart;
	CheckOut_Page1 check1;
	@BeforeMethod
	public void setUp() throws IOException, InterruptedException
{
	initialization();
	Login=new LoginPage();
	invent =new Inventory_page();
	cart=new cart_page();
	check1=new CheckOut_Page1();
	Login.loginToApplication();
	invent.add6Product();
	invent.clickoncartBtn();
	cart.clickoncheckoutBtn();
	
}
	@Test
	public void verifyURLofCheckoutpage1Test()
	{
		 String expURL="https://www.saucedemo.com/checkout-step-one.html";
		String actURL=check1.verifyURLofCheckoutpage1();
		assertEquals(actURL,expURL);
		Reporter.log("URL of the Checkoutpage1 is=" + actURL);
	}
	@Test
	public void verifyLableOfCheckoutPageTest()
	{
		String expLable="Checkout: Your Information";
		String actLable=check1.verifyLableOfCheckoutPage();
		assertEquals(expLable,actLable);
	}
	@Test
	public void inputInfoTest()
	{
		String expurl="https://www.saucedemo.com/checkout-step-two.html";
		String acturl=check1.inputInfo();
		assertEquals(acturl,expurl);
		Reporter.log("after pressing continue button we get=" +acturl);
		
	}
	@Test
	public void verifycancelbuttonTest()
	{
		String expurl="https://www.saucedemo.com/cart.html";
		String acturl=check1.verifycancelbutton();
		assertEquals(acturl, expurl);
		Reporter.log("after pressing cancel button we get ="+ acturl);
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
