package com.AdminProject.PageObjectClass;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import com.AdminProject.Utilities.ReadConfig;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class BaseClass 
{
	ReadConfig readconfig=new ReadConfig();
	public String baseURL=readconfig.getApplicationUrl();
	public String username=readconfig.getUserName();
	public String password=readconfig.getPassword();
	
	public static WebDriver driver;
	public ExtentSparkReporter sparkreport;
	public ExtentReports extent;
	public ExtentTest test;
	
	@BeforeSuite
	public void setReport() {
		sparkreport=new ExtentSparkReporter("C:\\Users\\Ritessh\\eclipse-workspace\\AdminProject\\Reports\\htmlreport"+".html");
	    extent =new ExtentReports();
	    extent.attachReporter(sparkreport);
	    extent.setSystemInfo("Operating System", "Windows OS");
	    extent.setSystemInfo("Environment", "SIT");
	    sparkreport.config().setReportName("Integration Test Excution");
	    sparkreport.config().setDocumentTitle("QA Automation Testing Report");
	    sparkreport.config().setTheme(Theme.STANDARD);
	    
	
	}
	
	@Parameters("browser")

	@BeforeMethod
	
	public void initialize(String str) {
		if(str.equals("Chrome")) {
		System.setProperty("webdriver.chrome.driver", "C:/Users/Ritessh/Downloads/chromedriver_win32/chromedriver.exe");
	   driver=new ChromeDriver();
		}
		else if(str.equals("MicrosoftEdge")) {
			System.setProperty("webdriver.edge.driver", "C:/Users/Ritessh/Downloads/edgedriver_win64/msedgedriver.exe");
			driver=new EdgeDriver();
		}
		
	}
	
	public static String CaptureScreen() throws IOException {
		File source	=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	    String dest="C:\\Users\\Ritessh\\eclipse-workspace\\AdminProject\\ScreenShot\\qwerty"+".png";
	    FileUtils.copyFile(source, new File(dest));
	    return dest;
	}
	
	@AfterMethod
	
	public void CloseBrowser() {
		driver.quit();
	}
@AfterSuite
public void endReport() {
	extent.flush();
}
}
