package com.actiTime.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.actiTime.generic.BasePage;

public class LogInPage extends BasePage
{
	//Declaration
	@FindBy(id="username")
	private WebElement unTb;
	
	@FindBy(name="pwd")
	private WebElement pwTb;
	
	@FindBy(id="loginButton")
	private WebElement loginBtn;
	
	@FindBy(xpath="//span[contains(.,'username or password')]")
	private WebElement errorMsg;
	
	@FindBy(xpath="(//nobr[contains(.,'actiTIME')])[1]")
	private WebElement version;
	
	//intialization
	public LogInPage(WebDriver driver) 
	{
		super(driver);
		PageFactory.initElements(driver, this);
	}
	
	//Utilization
	public void verifyPageTitle(String eTitle)
	{
		verifyTitle(eTitle);
		
	}
	
	public void enterUserName(String un)
	{
		unTb.sendKeys(un);
	}
	
	public void enterPassword(String pw)
	{
		pwTb.sendKeys(pw);
	}
	
	public void clickOnLogInBtn()
	{
		loginBtn.click();
	}
	public String verifyErrorMsg() 
	{
		verifyElement(errorMsg);
		String errorText=errorMsg.getText();
		return errorText;
	}
	
	public String verifyVersion()
	{
		verifyElement(version);
		String versionText=version.getText();
		return versionText;
	}
}
