package com.demoblaze.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.demoblaze.ActionClass.Action;
import com.demoblaze.BaseClass.BaseClass;

public class OrderSuccessPage extends BaseClass {

	Action action;
	@FindBy(xpath = "//h2[text() = 'Thank you for your purchase!']")
	private WebElement successMessage;
	@FindBy (xpath = "//button[@class=\"confirm btn btn-lg btn-primary\"]")
	private WebElement clickOkBtn;
	
	public OrderSuccessPage() {
		PageFactory.initElements(getDriver(), this);
	} 
	
	public String confirmSuccessMessage () {
		String confirmSuccesstxt = successMessage.getText();
		return confirmSuccesstxt;
	}
	
	public LandingPage clickOkBtn () {
		action.JSClick(getDriver(), clickOkBtn);
		return new LandingPage();
		
		
	}
}


