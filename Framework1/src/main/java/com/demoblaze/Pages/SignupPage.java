package com.demoblaze.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.demoblaze.ActionClass.Action;
import com.demoblaze.BaseClass.BaseClass;

public class SignupPage extends BaseClass {

	Action action = new Action() ;
	
	@FindBy(xpath = "//input[@id='sign-username']")
	private WebElement regName;
	
	@FindBy(xpath = "//input[@id='sign-password']")
	private WebElement regPassword;
	
	@FindBy(xpath = "//button[contains(text(), 'Sign up')]")
	private WebElement signUpBtn;
	
	@FindBy(xpath = "//*[contains(text(), 'Sign up is successful.')]")
	private WebElement successTxt;
	
	
	
	public SignupPage() {
		PageFactory.initElements(getDriver(), this);
	}
	
	public void signUp (String regUsername, String regPswd) {
		action.implicitWait(getDriver(), 20);
		
		action.type(regName, regUsername);
		
		action.implicitWait(getDriver(), 20);
		
		action.type(regPassword, regPswd);
		
		action.implicitWait(getDriver(), 20);
		
		action.click(getDriver(), signUpBtn);
		
		
	}

}
