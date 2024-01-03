package utility;



import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.io.FileHandler;

import base.TestBase;


public class Screenshot extends TestBase
{
	public static String getDate()
	{
	return new SimpleDateFormat("dd-mm-yyy ss-mm-hh").format(new Date());
	}
	public static void screenshot(String nameofMethod) throws IOException
	{
		File source = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		File dest = new File("C:\\Users\\hp\\eclipse-workspace\\Project_Selenium_FrameWork\\Screenshot\\"+nameofMethod+"--------"+getDate()+".jpeg");
		FileHandler.copy(source,dest);
	}
}