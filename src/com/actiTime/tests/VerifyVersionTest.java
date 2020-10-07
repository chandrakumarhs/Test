package com.actiTime.tests;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.actiTime.generic.BaseTest;
import com.actiTime.generic.ExcelData;
import com.actiTime.pages.EnterTimeTrackPage;
import com.actiTime.pages.LogInPage;


public class VerifyVersionTest extends BaseTest
{
	@Test(priority=3)
	public void testVerifyVersion() 
	{
		String loginTitle = ExcelData.getData(file_path, "TC01", 1, 2);
		String eVersion = ExcelData.getData(file_path, "TC03", 1, 0);
		LogInPage lp=new LogInPage(driver);
		//verify LoginTitle
		lp.verifyPageTitle(loginTitle);
		//Verify version 
		String aVersion = lp.verifyVersion();
		Reporter.log("Expected Version is: "+eVersion,true);
		Reporter.log("Actual Version is: "+aVersion,true);
		SoftAssert sa = new SoftAssert();
		sa.assertEquals(aVersion, eVersion);
		Reporter.log("Version is matching",true);
		sa.assertAll();
		
	}
}
