package com.actiTime.generic;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class GenericUtils
{
	public static void takeScreenShot(WebDriver driver, String name) throws IOException
	{
		TakesScreenshot ts=(TakesScreenshot) driver;
		File src=ts.getScreenshotAs(OutputType.FILE);
		File dst= new File("./screenshoots/"+name+".png");
		FileUtils.copyFile(src,dst);
	}
	public static void selectByIndex(WebElement ele, int index)
	{
		Select sel=new Select(ele);
		sel.selectByIndex(index);
		
	}
	
	public static void selectedByValue(WebElement ele, String value)
	{
		Select sel=new Select(ele);
		sel.selectByValue(value);
		
	}
	public static void selectByVisibleTest(WebElement ele, String text)
	{
		Select sel=new Select(ele);
		sel.selectByVisibleText(text);
		
	}
}
