package pages;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.TestBase;
import io.github.bonigarcia.wdm.WebDriverManager;
import net.bytebuddy.asm.MemberSubstitution.FieldValue;

public class cart_page extends TestBase
{
	@FindBy(xpath = "//span[text()='Your Cart']") private WebElement cartPageLable;
	@FindBy(xpath = "//button[@id='checkout']") private WebElement checkoutbtn;
	@FindBy(xpath = "//button[@id='continue-shopping']") private WebElement continueShoppingBtn;
	public cart_page()
	{
		PageFactory.initElements(driver,this);
	}
	
	public String verifycartPageURLLable()
	{
		return driver.getCurrentUrl();
	}
	
	public String verifycartPageLable()
	{
		return cartPageLable.getText();
	}
	
	public String verifycheckoutButton()
	{
		checkoutbtn.click();
		return driver.getCurrentUrl();
	}
	public String verifyContinueShoppingBtn()
	{
		continueShoppingBtn.click();
		return driver.getCurrentUrl();
	}
	public void clickoncheckoutBtn()
	{
		checkoutbtn.click();
	}
}
