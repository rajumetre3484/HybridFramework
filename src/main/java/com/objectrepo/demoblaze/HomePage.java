package com.objectrepo.demoblaze;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage 
{

	@FindBy(xpath = "//a[@id='login2']")
	private WebElement Login1;
	
	@FindBy(xpath = "//input[@id='loginusername']")
	private WebElement Loginusername;
	
	@FindBy(xpath = "//input[@id='loginpassword']")
	private WebElement Loginpassword;
	
	@FindBy(xpath = "//button[@onclick='logIn()']")
	private WebElement LoginButton2;

	@FindBy(xpath = "//a[text()='Welcome Raj123@']")  
	private WebElement NameOfTheUser;
	
	@FindBy(xpath = "//a[text()='Log out']")  
	private WebElement Logout;
	
	@FindBy (xpath="//a[text()='Nexus 6']")
	private WebElement Nexus6;

	@FindBy (xpath="//a[text()='Add to cart']")
	private WebElement AddToCart;
	
	
	@FindBy (xpath="//a[text()='Cart']")
	private WebElement Cart;
	
	@FindBy (xpath="//a[text()='Contact']") 
	private WebElement contact;
	
	@FindBy (xpath="//input[@id='recipient-email']")
	private WebElement CantactEmail;
	
	@FindBy (xpath="//input[@id='recipient-name']")
	private WebElement CantactNmae;
	
	@FindBy (xpath="//textarea[@id='message-text']")
	private WebElement CantactMessage;
	
	@FindBy (xpath="//button[text()='Send message']")
	private WebElement CantactSendMessagebtn;

	
	//Getters
	public WebElement getLogin1() {
		return Login1;
	}

	public WebElement getLoginusername() {
		return Loginusername;
	}

	public WebElement getLoginpassword() {
		return Loginpassword;
	}

	public WebElement getLoginButton2() {
		return LoginButton2;
	}

	public WebElement getNameOfTheUser() {
		return NameOfTheUser;
	}

	public WebElement getLogout() {
		return Logout;
	}

	public WebElement getNexus6() {
		return Nexus6;
	}

	public WebElement getAddToCart() {
		return AddToCart;
	}

	public WebElement getCart() {
		return Cart;
	}

	public WebElement getContact() {
		return contact;
	}

	public WebElement getCantactEmail() {
		return CantactEmail;
	}

	public WebElement getCantactNmae() {
		return CantactNmae;
	}

	public WebElement getCantactMessage() {
		return CantactMessage;
	}

	public WebElement getCantactSendMessagebtn() {
		return CantactSendMessagebtn;
	}
	

}
