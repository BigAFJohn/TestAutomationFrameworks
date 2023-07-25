/**
 * 
 */
package com.demoblaze.TestCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.demoblaze.BaseClass.BaseClass;
import com.demoblaze.DataProvider.DataProviders;
import com.demoblaze.Pages.HomePage;
import com.demoblaze.Pages.LandingPage;
import com.demoblaze.Utilities.LogClass;

/**
 * @author bigaf
 *
 */
public class LoginPageTest extends BaseClass{
	
	
	private HomePage homePage;
	private LandingPage landingPage;
	
	
	@Test(groups = {"Smoke","Sanity"},dataProvider = "credentials", dataProviderClass = DataProviders.class)
	public void loginTest(String uname, String pswd) throws InterruptedException {
			homePage = new HomePage();
		  	LogClass.startTestCase("loginTest");
		  	
		  	LogClass.info("user is going to click on SignIn");
		  	
		  	LogClass.info("user is entering valid username and password");
		  	landingPage = homePage.clickLogInBtn().login(uname, pswd);
			
			Assert.assertTrue(landingPage.confirmLogIn());
		
			
			LogClass.info("End of test");
	
			LogClass.endTestCase("End test case");
	
	}
}

