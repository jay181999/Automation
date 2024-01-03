package pages;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.TestBase;

public class CheckOut_Page1 extends TestBase 
{
@FindBy(xpath = "//input[@id='first-name']") private WebElement firstNameBTN;
@FindBy(xpath = "//input[@id='last-name']") private WebElement lastNameBTN;
@FindBy(xpath = "//input[@id='postal-code']") private WebElement postalCodeBTN;
@FindBy(xpath ="//span[text()='Checkout: Your Information']") private WebElement chechoutLable;
@FindBy(xpath = "//button[@id='cancel']") private WebElement cancelBTN;
@FindBy(xpath = "//input[@id='continue']") private WebElement continueBTN;
public CheckOut_Page1()
{
	PageFactory.initElements(driver,this);
}

public String verifyURLofCheckoutpage1()
{
	return driver.getCurrentUrl();
}
public String verifyLableOfCheckoutPage()
{
	return chechoutLable.getText();
	
}
public String inputInfo()
{
	firstNameBTN.sendKeys("harry");
	lastNameBTN.sendKeys("potter");
	postalCodeBTN.sendKeys("410201");
	continueBTN.click();
	return driver.getCurrentUrl();
}
public String verifycancelbutton()
{
	cancelBTN.click();
	return driver.getCurrentUrl();
}

















}
