package com.actiTime.tests;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.actiTime.generic.BaseTest;
import com.actiTime.generic.ExcelData;
import com.actiTime.pages.EnterTimeTrackPage;
import com.actiTime.pages.LogInPage;

public class InvalidLoginTest  extends BaseTest
{
	@Test(priority = 2)
	public void testInvalidLogin() throws InterruptedException
	{
		//Reading data from excel sheet
		String loginTitle = ExcelData.getData(file_path, "TC01", 1, 2);
		//String expectedErrorMsg = ExcelData.getData(file_path, "TC02", 1, 2);
		int rc = ExcelData.getLastRowCount(file_path, "TC02");
		
		LogInPage lp = new LogInPage(driver);
		
		for (int i = 1; i <= rc; i++) 
		{
		String un = ExcelData.getData(file_path, "TC02", i, 0);
		String pw = ExcelData.getData(file_path, "TC02", i, 1);
		String expectedErrorMsg = ExcelData.getData(file_path, "TC02", i, 2);
		
		 //verify LoginTitle
		 lp.verifyPageTitle(loginTitle);
		 
		 //Enter invalid un
		 Reporter.log("UserName is : "+un,true);
		 lp.enterUserName(un);
		 
		 //Enter invalid pw
		 Reporter.log("Password is : "+pw,true);
		 lp.enterPassword(pw);
		 
		 //Click on LoginBtn
		 lp.clickOnLogInBtn();
		 Thread.sleep(3000);
		 //verify Error msg
		 String actualErrorMsg = lp.verifyErrorMsg();
		 Reporter.log("Actual Error Msg is :"+actualErrorMsg,true);
		 Reporter.log("Expected Error Msg is :"+expectedErrorMsg,true);
		 
		 Assert.assertEquals(actualErrorMsg, expectedErrorMsg);
		 Reporter.log("Both error msg are matching.",true);	
		 Reporter.log("-----------------------------------------------",true);
		 Thread.sleep(6000);
		}
	}

}

