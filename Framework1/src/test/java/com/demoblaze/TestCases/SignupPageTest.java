package com.demoblaze.TestCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.demoblaze.BaseClass.BaseClass;
import com.demoblaze.Pages.HomePage;
import com.demoblaze.Utilities.LogClass;

import com.demoblaze.Utilities.RandomUtility;

public class SignupPageTest extends BaseClass {

	
    @Test
    public void signUpTest() throws InterruptedException {
    	String regUsername=RandomUtility.generateRandomString();
    	String regPswd = RandomUtility.generateRandomString();
        HomePage homePage = new HomePage();
        

        LogClass.startTestCase("signUpTest");
        LogClass.info("User clicks the sign up button");
        homePage.clickSignUpBtn();
        LogClass.info("User enters registration username and password");
        
        homePage.signUp(regUsername, regPswd);

        String alertText = homePage.getAlertText();
        Assert.assertEquals(alertText, "Sign up successful.");

        LogClass.endTestCase("End test case");
    }
}
