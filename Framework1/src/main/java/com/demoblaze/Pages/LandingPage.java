package com.demoblaze.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.demoblaze.ActionClass.Action;
import com.demoblaze.BaseClass.BaseClass;

public class LandingPage extends BaseClass {

	Action action = new Action();
	
	
	@FindBy(xpath = "//a[@href=\"prod.html?idp_=1\"][@class=\"hrefch\"]|//a[contains(text(), 'Samsung galaxy s6')]")
	private WebElement selectSamsungPhone;
	
	@FindBy(xpath = "//a[@onclick='logOut()']")
	private WebElement logOut;
	
	public LandingPage() {
		PageFactory.initElements(getDriver(), this);
	} 
	
	
public OrderConfirmationPage selectProduct () {
	action.explicitWait(getDriver(), selectSamsungPhone, 10);
	action.JSClick(getDriver(), selectSamsungPhone);
	return new OrderConfirmationPage();
}
public boolean confirmLogIn() {
	action.explicitWait(getDriver(), logOut, 10);
    boolean result = action.isDisplayed(getDriver(), logOut);
	return result;
}
}
