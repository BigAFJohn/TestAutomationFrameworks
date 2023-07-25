package com.demoblaze.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.demoblaze.ActionClass.Action;
import com.demoblaze.BaseClass.BaseClass;

public class CartPage extends BaseClass  {
	
  Action action;
  
  @FindBy(xpath = "//td[contains(text(), 'Samsung galaxy s6')]")
 private WebElement confirmProductInCart;
 
  @FindBy(id = "totalp")
 private WebElement totalPrice;
  
  @FindBy (xpath = "//button[@class='btn btn-success']")
  private WebElement placeOrderBtn;
  
  
  public CartPage() {
		PageFactory.initElements(getDriver(), this);
	} 
	
  
  public String  confirmProductInCart() {
		String productInCart = confirmProductInCart.getText();
		return productInCart;
		}
  
  public String confirmTotalPrice () {
	  String totalPriceOfProduct = totalPrice.getText();
	  return totalPriceOfProduct;
  }
  
  public PlaceOrderPage clickOrderBtn () {
	  action.JSClick(getDriver(), placeOrderBtn);
	  return new PlaceOrderPage();
  }
}
