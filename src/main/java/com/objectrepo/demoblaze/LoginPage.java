package com.objectrepo.demoblaze;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage 
{
	@FindBy(id="loginusername")
	private WebElement LoginUsername;
	
	@FindBy(xpath="//input[@id='loginpassword']")
	private WebElement Loginpassword;
	

	@FindBy(xpath="//button[text()='Log in']")
	private WebElement LoginButton;


	//Getters
	public WebElement getLoginUsername() {
		return LoginUsername;
	}


	public WebElement getLoginpassword() {
		return Loginpassword;
	}


	public WebElement getLoginButton() {
		return LoginButton;
	}
	

}
