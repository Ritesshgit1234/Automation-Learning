package com.AdminProject.TestClass;

import java.io.IOException;

import org.testng.annotations.Test;
import org.testng.annotations.Test;

import com.AdminProject.PageObjectClass.BaseClass;
import com.AdminProject.PageObjectClass.LoginPage_POM;
import com.AdminProject.Utilities.ExcelData;
import com.aventstack.extentreports.Status;

public class LoginTestVerification extends BaseClass
{
	@Test
	
	public void LoginTest() throws InterruptedException, IOException 
	{
		try {
		LoginPage_POM login=new LoginPage_POM (driver);
		test=extent.createTest("verify application login");
		driver.get(baseURL);
        test.log(Status.PASS, "Application URL Open Succesfully");
	
		Thread.sleep(2000);
		
		login.SetUserId(ExcelData.getData(2, 0));
        test.log(Status.PASS, "Username Enter  Succesfully");

		Thread.sleep(2000);

		login.SetPassword(ExcelData.getData(2, 1));
        test.log(Status.PASS, "Password Enter  Succesfully");

		Thread.sleep(2000);

		login.ClickLogginButton();
        test.log(Status.PASS, "Click On LoginBtn  Succesfully");
        
        Thread.sleep(4000);
        String expectedTitle="GTPL Bank Manager HomePag";
		String actualTitle= driver.getTitle();
		
		if(actualTitle.equals(expectedTitle)) 
		{
			test.log(Status.PASS, "titel verify succesfully");
		}
		else 
		{
			test.log(Status.FAIL,"login fail");
			String screenshotpath=BaseClass.CaptureScreen();
			test.addScreenCaptureFromPath(screenshotpath);
		}	}
		catch(Exception e) {
			test.log(Status.FAIL,"login fail");
			String screenshotpath=BaseClass.CaptureScreen();
			test.addScreenCaptureFromPath(screenshotpath);
			
		}
	
	}

}
