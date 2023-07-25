package com.demoblaze.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.demoblaze.ActionClass.Action;
import com.demoblaze.BaseClass.BaseClass;

public class LoginPage extends BaseClass {
	
	Action action = new Action () ;
	
	@FindBy(xpath = "//input[@id='loginusername']")
	private WebElement userName;
	
	@FindBy(xpath = "//input[@id='loginpassword']")
	private WebElement password;
	
	@FindBy(xpath = "//button[contains(text(), 'Log in')]")
	private WebElement signInBtn;
	
	
	
	public LoginPage() {
		PageFactory.initElements(getDriver(), this);
	}
	
	public LandingPage login(String uname, String pswd) {
		/*
		 * System.out.println("Username: " + uname); System.out.println("Password: " +
		 * pswd);
		 */
	    action.implicitWait(getDriver(), 20);
	    action.type(userName, uname);
	    action.implicitWait(getDriver(), 20);
	    action.type(password, pswd);
	    action.explicitWait(getDriver(), signInBtn, 10);
	    
	    action.JSClick(getDriver(), signInBtn);
	    return new LandingPage();
	}

	
}
