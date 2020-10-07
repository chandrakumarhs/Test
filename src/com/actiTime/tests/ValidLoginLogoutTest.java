package com.actiTime.tests;

import org.openqa.selenium.WebDriver;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.actiTime.generic.BaseTest;
import com.actiTime.generic.ExcelData;
import com.actiTime.pages.EnterTimeTrackPage;
import com.actiTime.pages.LogInPage;

public class ValidLoginLogoutTest extends BaseTest
{
	//private static final String file_path = null;

	@Test(priority=1)
	public void testValidloginlogout() throws InterruptedException
	{
		//Reading data from excel sheet
		String LoginTitle=ExcelData.getData(file_path, "TC01", 1, 2);
		String un=ExcelData.getData(file_path, "TC01", 1, 0);
		Thread.sleep(3000);
		String pw=ExcelData.getData(file_path, "TC01", 1, 1);
		String enterTitle=ExcelData.getData(file_path, "TC01", 1, 3);
		LogInPage lp=new LogInPage(driver);
		EnterTimeTrackPage ep=new EnterTimeTrackPage(driver);
		
		//verify loginTitle
		lp.verifyPageTitle(LoginTitle);
		
		//Enter UN
		Reporter.log("User name is: "+un,true);
		lp.enterUserName(un);
		
		//Enter password
		Reporter.log("Password is: "+pw,true);
		lp.enterPassword(pw);
		
		//Click on login button
		lp.clickOnLogInBtn();
		
		//verify EnterTime track titles
		lp.verifyPageTitle(enterTitle);
		
		Thread.sleep(4000);
		//Click on logout
		ep.clickonLogout();
		//verify logintitle
		lp.verifyPageTitle(LoginTitle);
	}

	
}
