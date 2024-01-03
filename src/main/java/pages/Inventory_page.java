package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import base.TestBase;
import net.bytebuddy.asm.MemberSubstitution.FieldValue;
import utility.Handle_Dropdown;

public class Inventory_page extends TestBase
{
	//object repository
	//add product
	@FindBy(xpath = "//span[text()='Products']") private WebElement productlable;
	@FindBy(xpath = "//button[@name='add-to-cart-sauce-labs-backpack']") private WebElement backpackproduct;
	@FindBy(xpath = "//button[@name='add-to-cart-sauce-labs-bike-light']") private WebElement bikelightproduct;
	@FindBy(xpath = "//button[@name='add-to-cart-sauce-labs-bolt-t-shirt']") private WebElement bolttshirtproduct;
	@FindBy(xpath = "//button[@name='add-to-cart-sauce-labs-fleece-jacket']") private WebElement jacketproduct;	
	@FindBy(xpath = "//button[@name='add-to-cart-sauce-labs-onesie']") private WebElement onesieproduct;
	@FindBy(xpath = "//button[@name='add-to-cart-test.allthethings()-t-shirt-(red)']") private WebElement tshirtredproduct;
	//remove xpath
	@FindBy(xpath = "//button[@id='remove-sauce-labs-backpack']") private WebElement removeBackpackProduct;
	@FindBy(xpath = "//button[@id='remove-sauce-labs-bike-light']") private WebElement removeBikeLIghtProduct;
	@FindBy(xpath = "//button[@id='remove-sauce-labs-bolt-t-shirt']") private WebElement removeBoltTshirtProduct;
	@FindBy(xpath = "//button[@id='remove-sauce-labs-fleece-jacket']") private WebElement removejacketproduct;
	@FindBy(xpath = "//button[@id='remove-sauce-labs-onesie']") private WebElement removeonesieproduct;
	@FindBy(xpath = "//button[@id='remove-test.allthethings()-t-shirt-(red)']") WebElement removeTshirtREdProduct;
	
	
	@FindBy(xpath = "//span[@class='shopping_cart_badge']") private WebElement cartcount;
	@FindBy(xpath = "//a[@class='shopping_cart_link']") private WebElement carticon;

	@FindBy(xpath = "//a[text()='Twitter']") private WebElement twittericon;
	@FindBy(xpath = "//a[text()='Facebook']") private WebElement facebookicon;
	@FindBy(xpath = "//a[text()='LinkedIn']") private WebElement linkdinlogo;
	
	@FindBy(xpath = "//select[@class='product_sort_container']") private WebElement productDropDown;
	
	public Inventory_page()
	{
		PageFactory.initElements(driver,this);
	}
	public String verifyLableproductLable()
	{
		return productlable.getText();
	}
	public Boolean verifyTwitterlogo()
	{
		return twittericon.isDisplayed();
	}
	public Boolean verifyFacebookicon()
	{
		return facebookicon.isDisplayed();
		
	}
	public Boolean verifyLinkdinicon()
	{
		return linkdinlogo.isDisplayed();
	}
	public String add6Product()
	{
		Handle_Dropdown.handleSelectClass(productDropDown,"Price (low to high)");
		backpackproduct.click();
		bikelightproduct.click();
		bolttshirtproduct.click();
		jacketproduct.click();
		onesieproduct.click();
		tshirtredproduct.click();
		return cartcount.getText();
	}
	public String remove2product()
	{

		add6Product();
		removeBackpackProduct.click();
		removeBikeLIghtProduct.click();
		return cartcount.getText();
	}
	public void clickoncartBtn()
	{
		carticon.click();
		
	}
	
	}
	
	
	
