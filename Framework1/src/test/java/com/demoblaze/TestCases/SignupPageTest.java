package com.demoblaze.TestCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.demoblaze.BaseClass.BaseClass;
import com.demoblaze.DataProvider.DataProviders;
import com.demoblaze.Pages.HomePage;
import com.demoblaze.Utilities.LogClass;

public class SignupPageTest extends BaseClass {
	

    @Test(groups = {"Smoke","Sanity"},dataProvider = "regDetails", dataProviderClass = DataProviders.class)
    public void signUpTest(String regUsername, String regPswd ) throws InterruptedException {
        HomePage homePage = new HomePage();

        LogClass.startTestCase("signUpTest");
        LogClass.info("User clicks the sign up button");
        homePage.clickSignUpBtn();
        LogClass.info("User enters registration username and password");
        homePage.signUp(regUsername, regPswd);

        String alertText = homePage.getAlertText();
        if (alertText != null) {
            Assert.assertTrue(alertText.contains("This user already exist."), "The alert text doesn't contain expected message");
        } else {
            Assert.fail("Alert text is null");
        }

        LogClass.endTestCase("End test case");
    }
}
