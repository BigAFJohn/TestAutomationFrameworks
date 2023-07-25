package com.demoblaze.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.demoblaze.ActionClass.Action;
import com.demoblaze.BaseClass.BaseClass;

public class OrderConfirmationPage extends BaseClass {
	
	Action action = new Action ();
	
	@FindBy(xpath = "//a[@class='btn btn-success btn-lg']|//a[contains(text(),'addToCart(1)')]")
	private WebElement addProductToCart;
	@FindBy(xpath = "//h2[@class=\"name\"]")
	private WebElement productName;
	@FindBy(xpath = "//h3[starts-with (text(),'$')]")
	private WebElement productPrice;
	@FindBy(xpath = "//a[@id=\"cartur\"]")
	private WebElement clickCartBtn;
	
	public OrderConfirmationPage() {
		PageFactory.initElements(getDriver(), this);
	} 
	
	
	public OrderConfirmationPage addItemToCart () {
	action.JSClick(getDriver(), addProductToCart);
	return new OrderConfirmationPage();
}
	public String confirmProductCartName() {
	String productCartName = productName.getText();
	return productCartName;
	
}
	public String confirmProductCartPrice () {
		String productCartPrice = productPrice.getText();
		return productCartPrice;
	}
	
	public OrderConfirmationPage acceptAlert () {
		action.Alert(getDriver());
		return new OrderConfirmationPage();
		
	}
	
	public CartPage clickCartBtn () {
	action.explicitWait(getDriver(), clickCartBtn, 10);
	action.JSClick(getDriver(), clickCartBtn);
	return new CartPage();
	
	}
}
