package com.demoblaze.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.demoblaze.ActionClass.Action;
import com.demoblaze.BaseClass.BaseClass;

public class PlaceOrderPage extends BaseClass {
	
	Action action;
	
	@FindBy(id = "name")
	private WebElement nameInput;
	
	@FindBy(id = "country")
	private WebElement countryInput;
	
	@FindBy(id = "city")
	private WebElement cityInput;
	
	@FindBy(id = "card")
	private WebElement creditCardInput;
	
	@FindBy(id = "month")
	private WebElement monthInput;
	

	@FindBy(id = "year")
	private WebElement yearInput;
	
	@FindBy(xpath = "//button[contains(text(), 'Purchase')]")
	private WebElement purchaseBtn;
	
	 
 public PlaceOrderPage() {
			PageFactory.initElements(getDriver(), this);
		} 
	
 public void completeOrder(
			String name, 
			String country, 
			String city, 
			String creditCard, 
			String month,
			String year) {
	action.type(nameInput, name);
	action.type(countryInput, country);
	action.type(cityInput, city);
	action.type(creditCardInput, creditCard);
	action.type(cityInput, year);
	action.JSClick(getDriver(), purchaseBtn);
	
		}
		
	
}
