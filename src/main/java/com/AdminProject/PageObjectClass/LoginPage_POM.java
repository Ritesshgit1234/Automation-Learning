package com.AdminProject.PageObjectClass;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage_POM 
{
	public WebDriver ldriver;
	@FindBy(xpath=  "//input[@name='uid']")
	WebElement UserId;
	
	@FindBy(xpath= "//input[@name='password']")
	WebElement Password;
	
	@FindBy(xpath= "//input[@name='btnLogin']")
	WebElement LogButton;

	public LoginPage_POM(WebDriver rdriver)
	{
		ldriver=rdriver;
		PageFactory.initElements(rdriver,this);
	}
	
	public void SetUserId(String name) {
		UserId.sendKeys(name);
	}

	public void SetPassword(String pass) {
		Password.sendKeys(pass);
	}
	public void ClickLogginButton() {
		LogButton.click();
	}
}
