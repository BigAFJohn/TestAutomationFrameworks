package com.demoblaze.Pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.demoblaze.ActionClass.Action;
import com.demoblaze.BaseClass.BaseClass;

public class HomePage extends BaseClass {
	
	Action action = new Action() ;
	
	@FindBy(css = "#login2")
	private WebElement clickLogInBtn;
	
	@FindBy(xpath = "//a[@data-target='#signInModal']")
	private WebElement clickSignUpBtn;
	
	@FindBy(xpath = "//input[@id='sign-username']")
	private WebElement regName;
	
	@FindBy(xpath = "//input[@id='sign-password']")
	private WebElement regPassword;
	
	@FindBy(xpath = "//button[contains(text(), 'Sign up')]")
	private WebElement signUpBtn;
	
	@FindBy(xpath = "//*[contains(text(), 'Sign up is successful.')]")
	private WebElement successTxt;
	
	public HomePage() {
		PageFactory.initElements(getDriver(), this);
	}

	public LoginPage clickLogInBtn () {
			
			action.click(getDriver(), clickLogInBtn);
	
		return new LoginPage();
	}
	
	public SignupPage clickSignUpBtn () throws InterruptedException {
		action.explicitWait(getDriver(), clickSignUpBtn, 20);
		action.click(getDriver(), clickSignUpBtn);
		return new SignupPage();
	}
	public SignupPage signUp (String regUsername, String regPswd) {
		action.implicitWait(getDriver(), 20);
		
		action.type(regName, regUsername);
		
		action.implicitWait(getDriver(), 20);
		
		action.type(regPassword, regPswd);
		
		action.implicitWait(getDriver(), 20);
		
		action.click(getDriver(), signUpBtn);	
		action.implicitWait(getDriver(), 20);
		return new SignupPage();
	}
	public String getAlertText() {
	    try {
	        WebDriverWait wait = new WebDriverWait(getDriver(), 10);
	        wait.until(ExpectedConditions.alertIsPresent());
	        Alert alert = getDriver().switchTo().alert();
	        String alertText = alert.getText();
	        System.out.println("Alert text is: " + alertText);  // print alert text
	        alert.accept();
	        return alertText;
	    } catch (NoAlertPresentException Ex) {
	        System.out.println("No alert was present at the moment.");
	        return null;
	    } catch (Exception e) {
	        System.out.println("An unexpected error occurred: " + e.getMessage());
	        return null;
	    }
	}

	}


	


