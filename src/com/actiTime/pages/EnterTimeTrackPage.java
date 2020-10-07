package com.actiTime.pages;

import javax.swing.Action;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.actiTime.generic.BasePage;

public class EnterTimeTrackPage extends BasePage
{
	//Declaration
	//@FindBy(xpath="//a[contains(.,'Logout')]")
	@FindBy(linkText="Logout")
	private WebElement Logoutlk;
	
	//initialization
	public EnterTimeTrackPage(WebDriver driver)
	{
		super(driver);
		PageFactory.initElements(driver, this);// TODO Auto-generated constructor stub
	}
	
	//utilization
	public void clickonLogout()
	{
		Logoutlk.sendKeys(Keys.ENTER);
	}
}
